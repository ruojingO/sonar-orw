import json
import html
import re
from pathlib import Path

path = Path('docs/sonar/RSPEC-2692.json')
data = json.loads(path.read_text())
rules = data['result']['data']['allFile']['nodes'][0]['childLanguageJson']['rules']
rule = next(r for r in rules if r['ruleKey'] == 'RSPEC-2692')
desc = rule['description']
# convert html to text similar to previous helper
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
text = desc
text = re.sub(r'<pre[^>]*>(.*?)</pre>', lambda m: '\n' + html.unescape(m.group(1).strip()) + '\n', text, flags=re.S)
for pattern, repl in replacements.items():
    text = re.sub(pattern, repl, text, flags=re.S | re.I)
text = re.sub(r'<[^>]+>', '', text)
text = html.unescape(text)
lines = [line.rstrip() for line in text.splitlines()]
text = '\n'.join(line for line in lines if line.strip())
print(text)
