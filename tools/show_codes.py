import json
import html
import re
from pathlib import Path

path = Path('docs/sonar/RSPEC-2692.json')
data = json.loads(path.read_text())
rules = data['result']['data']['allFile']['nodes'][0]['childLanguageJson']['rules']
rule = next(r for r in rules if r['ruleKey'] == 'RSPEC-2692')
desc = rule['description']
for idx, match in enumerate(re.finditer(r'<pre[^>]*>(.*?)</pre>', desc, re.S), start=1):
    code = html.unescape(match.group(1).strip())
    print(f'Code {idx}:\n{code}\n')
