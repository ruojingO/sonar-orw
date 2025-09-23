### V8.2 执行策略 (扩展覆盖 40+ Sonar 规则)

0. 目标概述
* 基于 V8.1 的例外守护体系，将 Sonar ↔ OpenRewrite 映射从 23 条扩展到 ≥40 条，并确保新增规则同样具备：官方资料缓存、语义一致的样例、例外 JSON、 _exceptions.java 守护、报告可追溯。
* 输出成果包括：
  * 更新版映射文档（docs/mappings/sonar-openrewrite.csv）。
  * 扩充后的 eport.md（≥40 行，含 Exception Guard、Exception Memo）。
  * 新增规则的 docs/sonar/RSPEC-*-exceptions.json + _exceptions.java + 守护日志。
  * 自动化脚本更新（需在 scripts/ 下维护批量爬取、解析、校验工具）。

1. 规则收集与映射维护
* 1.1 通过以下途径收集候选规则列表：
  * 现有 mytask.md 映射表补充。
  * OpenRewrite 官方文档（staticanalysis、logging、java-best-practices 等目录）交叉检索关键字 RSPEC。
  * Sonar 官方 RSPEC 页面按标签（Code Smell、Bug）与“Has quick fix”筛选可能存在配方的规则。
* 1.2 将收集结果统一写入 docs/mappings/sonar-openrewrite.csv，字段包含：ule, ecipe_fqn, status（existing/new/unknown）, 
otes。
* 1.3 对于 status=new 的项，进入后续流程；status=unknown 记录原因（无匹配配方、配方尚未发布等）。

2. 官方资料抓取与缓存
* 2.1 延续 V8.1 约定优先使用 page-data.json（GraphQL 缓存），命名为 docs/sonar/RSPEC-<数字>.json；必要时保留 HTML 以供人工核查。
* 2.2 批量脚本 scripts/fetch_rspec.ps1 支持输入规则列表，自动抓取并检测已有缓存，失败时记录重试与备选镜像地址。
* 2.3 更新 docs/exceptions/strategy/<ruleId>.md，写入抓取时间、DOM/JSON 解析策略、例外关键字，确保新增规则也有可追溯记录。

3. 样例生成与例外解析
* 3.1 重用或增强 V8.1 中的解析逻辑，将新增规则的 Exceptions 段落转换为 JSON（落盘 docs/sonar/RSPEC-<ruleId>-exceptions.json）。
* 3.2 自动/半自动生成 _uncompliant.java、_compliant_official.java、_exceptions.java：
  * _uncompliant / _compliant 沿用 V8.1 结构，保持官方语义。
  * _exceptions 需结合 JSON 里每条例外给出可编译样例，对于复杂场景可留 “TODO + 原文” 注释待人工完善。
* 3.3 新增规则的 src/test/java/com/sonarorw/rules/<ruleId>/README.md（可选），列出官方原文与本地实现差异。

4. 守护执行与验证
* 4.1 扩展 scripts/exception_guard.ps1：
  * 支持接收规则列表（默认全量），检查 _exceptions.java 是否存在。
  * mvn rewrite:dryRun -P <rule> 后比较 _exceptions.java 有无改动，生成 logs/<rule>-exception-guard.log。
  * 若产生改动，保留 diff 于 docs/diffs/<rule>-exceptions-diff.md 并自动回滚。
* 4.2 将守护通过的规则写入 eport.md 的 Exception Guard=PASS，同时更新 Exception Memo（记录例外类别、守护结论、注意事项）。

5. 报告与追踪资产
* 5.1 eport.md 增加对新增规则的记录，确保表格排序按规则 ID。
* 5.2 logs/exception-summary-v8.2.md（新增）记录扩展规则的巡检状态，旧日志保留作历史参考。
* 5.3 更新 docs/solu-v8.2.md 为实施指南：含流程步骤、自动化工具、常见失败场景（无例外、配方缺失、守护失败等）。
* 5.4 若本轮有新发现的“官方声明无例外”规则，将结论同步至 Exception Memo 与策略文档。

6. 自动化与脚本增强
* 6.1 scripts/fetch_rspec.ps1：批量抓取 + 缓存校验。
* 6.2 scripts/parse_exceptions.py：读取 JSON 生成 _exceptions.java 模板（保留 TODO 注释待人工完成）。
* 6.3 scripts/update_report.py：对比 eport.md 与巡检日志自动同步 Exception Guard、Exception Memo。
* 6.4 CI/预提交钩子：运行 
vn rewrite:dryRun 守护列表，并在失败时阻断提交。

7. 时间规划与优先级
* 7.1 优先处理与项目场景关系最大的规则（如 log/collections/serialization 等），先完成 10 条扩展。
* 7.2 依次推进其余规则，预计分两批（各 10 条）完成，使总数超过 40。
* 7.3 每批扩展完成时提交阶段报告，包括新增规则列表、守护结果、待解决问题。

8. 复盘与下一步
* 8.1 汇总本轮新增规则的守护数据，更新 docs/exceptions/summary-<date>.md。
* 8.2 识别仍为 WARN 的规则，分类原因（例外未知、样例缺失、守护失败）。
* 8.3 为后续 V9 (覆盖全量/自动化集成) 做准备：考虑接入覆盖率统计、引入 diff 审阅器、自动生成 PR 模板等。

