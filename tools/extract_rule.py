import json
import sys
from pathlib import Path
path = Path(sys.argv[1])
rule_key = sys.argv[2]
data = json.loads(path.read_text())
rules = data['result']['data']['allFile']['nodes'][0]['childLanguageJson']['rules']
for rule in rules:
    if rule.get('ruleKey') == rule_key:
        json.dump(rule, sys.stdout, ensure_ascii=False, indent=2)
        break
else:
    raise SystemExit(f"Rule {rule_key} not found")
