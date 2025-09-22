# Changelog

## 2025-09-21
- 整理项目结构：将 diff 报告归档至 `docs/diffs/`，脚本集中到 `tools/`，清理临时与构建产物。
- 引入 README 与本变更记录，简述执行流程与目录结构。
- 补充最新 17 条规则的执行结果至 `report.md`，覆盖 S888、S5411、S1126、S2293、S2112、S2162、S106 等。
- 更新 Maven profiles 与示例源码，确保每条规则可通过 `rewrite:run` 单独验证。
