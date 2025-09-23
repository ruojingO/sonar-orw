### V8.1 增量执行方案 (规则例外巡检专用)

0. 总览
* 目标：在既有 V8 产物基础上，快速验证所有规则的例外（exception）场景是否被覆盖且未被 Rewrite Recipe 误改。
* 触发时机：
  * V8 主流程已完成且 `docs/diffs`、`report.md` 存在。
  * 需要单独复核例外条目，或在官方 RSPEC 更新后进行回归。
* 固定输出：
  * `docs/sonar/RSPEC-<ruleId>.json` 或 `docs/sonar/RSPEC-<id>.json`（GraphQL 缓存，若缺失需重新抓取）。
  * `src/test/java/com/sonarorw/rules/<ruleId>/<ruleId>_exceptions.java`（若缺失则生成占位并提示人工补充）。
  * 巡检日志：`logs/<ruleId>-exception-scan.log`。
* 新增产物：
  * `docs/exceptions/strategy/<ruleId>.md`，记录每条规则的 JSON 解析策略、关键字命中情况与人工假设。
  * `logs/exception-summary-v8.1.md`，汇总本轮巡检结论。

1. 数据准备
* 1.1 读取 `mytask.md` 获取全部规则清单。
* 1.2 针对每条规则检查以下文件是否存在：
  * `docs/sonar/RSPEC-<ruleId>.json` 或 `docs/sonar/RSPEC-<数字>.json`。
  * `docs/exceptions/strategy/<ruleId>.md`。
  * `src/test/java/com/sonarorw/rules/<ruleId>/<ruleId>_exceptions.java`。
* 1.3 若上述文件缺失，记录待补全列表，并在巡检日志中生成 `MISSING` 项。

2. 例外数据提取（基于 RSPEC JSON）
* 2.1 若 GraphQL JSON 缺失或需刷新：
  * 2.1.1 访问 `https://rules.sonarsource.com/java/RSPEC-<数字>/`，抓取静态页面并提取 `window.__NUXT__`/`componentChunkName` 对应的 JSON，保存为缓存文件。
  * 2.1.2 优先命名为 `docs/sonar/RSPEC-<数字>.json`，并创建软链接或同内容副本 `RSPEC-<ruleId>.json` 以便脚本检索。
* 2.2 使用 `System.Web.Script.Serialization.JavaScriptSerializer` 解析 JSON，定位 `childLanguageJson.rules` 中 `ruleKey = RSPEC-<数字>` 的节点，拼接其 `description` 字段。
  * 2.2.1 同时解析 `childMarkdownRemark`，以防官方改用 Markdown 存储正文。
* 2.3 在描述文本中检索：
  * `<h3>Exceptions</h3>` / `<h2>Exceptions</h2>`：判定存在例外段落。
  * “This rule has no exceptions”：判定官方声明无例外。
  * 其它关键提示（如 `Why is this not an issue?`）可作为辅助信号写入策略文档。

3. 例外样例巡检
* 3.1 对每条规则执行脚本 `scripts/exception_guard.ps1 <ruleId>`（待实现 / 可重用本次示例脚本）：
  * 3.1.1 读取 JSON 中的例外段落，生成 `docs/sonar/RSPEC-<ruleId>-exceptions.json`（结构化保存例外标题、摘要、原始 HTML 和关键字）。
  * 3.1.2 校验 `_exceptions.java` 是否至少覆盖 JSON 中的每个例外条目（先比对代码块，再使用 `keyword_signals` 回退匹配）。
  * 3.1.3 对已有示例运行 `mvn rewrite:dryRun -P <ruleId>`（或执行 `rewrite:run` 后立即回滚），捕获 Recipe 是否改动例外代码。
* 3.1.4 针对 S121：NeedBraces dry-run 会改写 `_exceptions` 样例，当前保留 WARN 供人工复核。
* 3.2 将巡检结果写入 `logs/<ruleId>-exception-scan.log`：
  ```text
  [PASS] S3986 :: Exceptions 段落已解析，_exceptions.java 待补充
  [WARN] S3457 :: 未检测到官方例外，请人工确认
  [FAIL] S888 :: Recipe 改写了例外样例 (see docs/diffs/S888-exceptions-diff.md)
  ```

4. Diff 生成与回滚
* 4.1 对于 `FAIL` 项，使用 `git diff --no-index -U0 <before> <after>` 生成 `docs/diffs/<ruleId>-exceptions-diff.md`，供人工评审。
* 4.2 执行 `git checkout -- src/test/java/com/sonarorw/rules/<ruleId>/<ruleId>_exceptions.java` 还原改动，保持工作区整洁。

5. 报告与同步
* 5.1 在 `report.md` 增补一列 `Exception Guard`：
  * `PASS` = 无例外或例外代码未被触及。
  * `WARN` = 例外样例缺失或需人工确认。
  * `FAIL` = Recipe 破坏例外，需要修复。
* 5.2 若 `report.md` 已由 V9 接管，仅将增量结果汇总至 `logs/exception-summary-v8.1.md`，供合并使用。
* 5.3 将增量结论抄送到 `docs/exceptions/summary-<date>.md`，并在其中链接对应的 `strategy/<ruleId>.md` 与异常日志。

6. 复盘与关闭
* 6.1 对 `WARN`、`FAIL` 项提交 issue/任务单，说明修复计划与责任人。
* 6.2 例外巡检完成后，更新 `AGENTS.md` 或对应流水线文档，注明 V8.1 已执行完成时间与版本。
* 6.3 若下一轮将转入 V9 流程，记录迁移注意事项（脚本兼容性、配置差异等）。

