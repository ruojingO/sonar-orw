# Changelog

### feat (新功能)
- feat(规则): 为 S3599, S1124, S1197, S1217, S1659, S2129 等6条规则补充了官方合规文件 (`_compliant_official.java`)。

### docs (文档)
- docs(文档): 同步了 `sonar-openrewrite.csv` 与 `report.md` 文件中的规则状态。
- docs(文档): 为3条因缺少示例或已废弃而无法完成的规则 (S1193, S1610, S2097) 添加了备注说明。

### docs

## 2025-09-21
- 整理项目结构：将 diff 报告归档至 `docs/diffs/`，脚本集中到 `tools/`，清理临时与构建产物。
- 引入 README 与本变更记录，简述执行流程与目录结构。
- 补充最新 17 条规则的执行结果至 `report.md`，覆盖 S888、S5411、S1126、S2293、S2112、S2162、S106 等。
- 更新 Maven profiles 与示例源码，确保每条规则可通过 `rewrite:run` 单独验证。
