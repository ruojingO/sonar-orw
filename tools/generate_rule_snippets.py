import sys
import json
import re
import html
from pathlib import Path

rule_id = sys.argv[1]  # e.g. 3457
json_path = Path(f"docs/sonar/RSPEC-{rule_id}.json")
rule_key = f"RSPEC-{int(rule_id)}"

data = json.loads(json_path.read_text())
rules = data['result']['data']['allFile']['nodes'][0]['childLanguageJson']['rules']
for rule in rules:
    if rule.get('ruleKey') == rule_key:
        description = rule['description']
        break
else:
    raise SystemExit(f"Rule {rule_key} not found in {json_path}")

SECTION_TITLES = {
    'noncompliant': [
        'Noncompliant code example',
        'Noncompliant Code Example',
        'Noncompliant code examples',
        'Noncompliant code sample',
        'Noncompliant'
    ],
    'compliant': [
        'Compliant solution',
        'Compliant Solution',
        'Compliant code example',
        'Compliant code examples',
        'Compliant'
    ]
}

def extract_section(desc: str, titles):
    for title in titles:
        pattern = re.compile(rf'<h[234][^>]*>{re.escape(title)}</h[234]>(.*?)(?=<h[234]|<h2|$)', re.S | re.I)
        match = pattern.search(desc)
        if match:
            return match.group(1)
    raise ValueError(f"Section with titles {titles} not found")

def html_to_text(block: str):
    # preserve code blocks placeholders
    codes = []
    def code_repl(match):
        code = html.unescape(match.group(1).strip('\n'))
        codes.append(code)
        return f"__CODE_BLOCK_{len(codes)-1}__"
    block = re.sub(r'<pre[^>]*>(.*?)</pre>', code_repl, block, flags=re.S)
    # replace common HTML tags with text equivalents
    replacements = {
        r'<br\s*/?>': '\n',
        r'</p>': '\n',
        r'<p[^>]*>': '',
        r'</li>': '\n',
        r'<li>': '- ',
        r'</?ul[^>]*>': '\n',
        r'</?ol[^>]*>': '\n',
        r'</?strong>': '',
        r'</?em>': '',
        r'</?span[^>]*>': '',
        r'</?div[^>]*>': '\n',
        r'</?blockquote[^>]*>': '\n',
        r'</?code[^>]*>': '',
        r'</?a[^>]*>': ''
    }
    for pattern, replacement in replacements.items():
        block = re.sub(pattern, replacement, block, flags=re.S | re.I)
    block = re.sub(r'<[^>]+>', '', block)
    text = html.unescape(block)
    lines = [line.rstrip() for line in text.splitlines()]
    text = '\n'.join(line for line in lines if line.strip())
    # reinject code blocks
    for idx, code in enumerate(codes):
        placeholder = f"__CODE_BLOCK_{idx}__"
        text = text.replace(placeholder, f"\n{code}\n")
    return text.strip(), codes

non_block = extract_section(description, SECTION_TITLES['noncompliant'])
com_block = extract_section(description, SECTION_TITLES['compliant'])
non_text, non_codes = html_to_text(non_block)
com_text, com_codes = html_to_text(com_block)

out_dir = Path('docs/sonar')
(out_dir / f"RSPEC-{rule_id}-noncompliant.txt").write_text(non_text, encoding='utf-8')
(out_dir / f"RSPEC-{rule_id}-compliant.txt").write_text(com_text, encoding='utf-8')
# also dump codes for reference
json.dump({
    'noncompliant_code_blocks': non_codes,
    'compliant_code_blocks': com_codes
}, open(out_dir / f"RSPEC-{rule_id}-codes.json", 'w', encoding='utf-8'), ensure_ascii=False, indent=2)
