# tools 目录说明

此目录存放构建与验证过程使用的辅助脚本。

- `generate_rule_snippets.py`：读取 `docs/sonar/RSPEC-xxxx.json`，提取官方 "Noncompliant/Compliant" 示例，生成对应的源代码片段与文本说明。
- `extract_rule.py`：从 `page-data` JSON 中按 `ruleKey` 提取完整规则描述，便于调试或人工审查。
- `extract_text.py`：将规则 HTML 片段转换为纯文本（带保留的代码块），辅助检查解析结果。
- `show_codes.py`：快速打印某条规则描述中的 `<pre>` 代码块，验证抓取内容是否完整。
- `tmp_edit.py`：当前会话中的临时脚本，可根据需要二次利用或删除。

使用脚本前需确保 Python 3 可用，且相关 `RSPEC-*.json` 已缓存于 `docs/sonar/`。
