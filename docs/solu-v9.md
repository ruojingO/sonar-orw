### V9 执行方案 (批量规则、配方与例外验证策略)

1.0 任务编排 (Task Orchestration)
* 1.1 从 mytask.md 读取待验证规则清单，逐条创建执行记录。
  * 1.1.1 为每条规则标注：规则 ID、Sonar 官方链接、对应 OpenRewrite Recipe FQN、最大重试次数（建议 2）。
  * 1.1.2 初始化状态机：pending → unning → success|runFailed；额外维护 exceptionGuard 布尔位标记例外校验是否通过。
  * 1.1.3 若规则存在多个 Recipe 组合，拆分成子任务并记录依赖顺序，确保例外检查可定位到具体 Recipe。
* 1.2 为每条规则准备目录 src/test/java/com/sonarorw/rules/<ruleId>/。
  * 1.2.1 约定产物：<ruleId>_uncompliant.java、<ruleId>_compliant_official.java、<ruleId>_exceptions.java（可选）、docs/diffs/<ruleId>-diff.md。
  * 1.2.2 每个目录附带 README.md 或注释说明例外场景的来源与假设，便于代码评审。

2.0 官方资料采集 (Official Docs Harvest)
* 2.1 首次运行使用 Invoke-WebRequest 或 curl 抓取 Sonar 官方页面，缓存到 docs/sonar/RSPEC-<ruleId>.html。
  * 2.1.1 若本地已存在缓存则直接读取，避免重复访问网络。
  * 2.1.2 抓取失败写日志并按预设次数重试；若仍失败，标记 unFailed 并记录失败原因。
* 2.2 解析页面中的 “Noncompliant code example(s)” 与 “Compliant solution(s)” 区块。
  * 2.2.1 保留官方示例的全部代码块、说明文字、顺序；禁止截取部分片段。
  * 2.2.2 对无法直接编译的片段，以注释或桩代码保留原文，并注明“编译占位”。
* 2.3 同步解析页面的 “Exceptions” / “Why is this not an issue?” / “See also” 等例外说明，归档为 docs/sonar/RSPEC-<ruleId>-exceptions.json。
  * 2.3.1 若官方未显式列出例外，记录 exceptions: [] 并在日志中写明“无官方例外”。
  * 2.3.2 对于仅在文字描述中提到的例外，提取关键术语（如 week-based date, 
ull, debug mode）供后续匹配。

3.0 样例源码生成 (Sample Materialization)
* 3.1 生成 <ruleId>_uncompliant.java。
  * 3.1.1 文件顶部注释写入官方“不合规”描述与代码，可通过转义确保 ASCII 编译。
  * 3.1.2 每个不合规示例封装为独立方法（example1()、example2() 等），必要时补充字段或内部类维持上下文。
* 3.2 生成 <ruleId>_compliant_official.java。
  * 3.2.1 注释写入完整“合规”描述，与官方内容一致。
  * 3.2.2 方法签名与不合规文件保持可比较性，便于 diff。
* 3.3 依据 RSPEC-<ruleId>-exceptions.json 生成或扩充 <ruleId>_exceptions.java（或追加到 compliant 文件）。
  * 3.3.1 至少覆盖每条官方例外一个可编译样例；若例外依赖运行时条件，则注释说明并模拟最小可编译上下文。
  * 3.3.2 例外样例需附带单元测试或断言，确保 Recipe 不应改动该代码；使用 @SuppressWarnings 记录原因。
* 3.4 当官方示例即包含例外情况，需加注“官方例外引用”并保留原注释，避免二次误读。

4.0 Maven 配置与依赖 (Maven Profiles)
* 4.1 pom.xml 统一维护版本属性，主 profile 启用 org.openrewrite.java.format.AutoFormat，并显式添加 ewrite-static-analysis。
* 4.2 为每条规则新增 <profile>。
  * 4.2.1 <id>=规则 ID，<activeRecipes> 列出全部 Recipe。
  * 4.2.2 Profile 内继续追加 ewrite-static-analysis 依赖，必要时补充额外 Recipe 仓库。
  * 4.2.3 若例外校验需要禁用部分 Recipe，使用 <excludeRecipes> 或拆分 profile。

5.0 执行控制与例外校验 (Execution & Exception Guard)
* 5.1 对每条规则执行 mvn rewrite:run -P <ruleId> -f pom.xml，记录退出码与日志。
  * 5.1.1 非零退出码触发自动重试（不超过预设次数），并采集错误日志。
  * 5.1.2 重试仍失败标记 unFailed，在 eport.md 记录失败原因。
* 5.2 成功运行后保存 	arget/rewrite 输出，并生成 <ruleId>-diff.md（使用 git diff --no-index -U0）。
  * 5.2.1 若 Recipe 未改动 _uncompliant 文件，在 Memo 标记 No change 或 Recipe mismatch。
  * 5.2.2 若 Recipe 修改注释文案，核实核心代码是否符合预期。
* 5.3 对 _exceptions 样例执行“守护 diff”：
  * 5.3.1 比较执行前后源码，若出现非预期修改，立即标记 exceptionGuard=false 并回滚变更。
  * 5.3.2 将守护结果写入 logs/<ruleId>-exception-guard.log，包括 diff 摘要与处理意见。
  * 5.3.3 如需手工豁免，必须在报告中说明理由与验证步骤。

6.0 报告与可追溯性 (Reporting)
* 6.1 eport.md 表头保持 | Rule | Recipe | Can Fix | Memo |，并新增 | Exception Guard | 列。
* 6.2 每条规则追加一行：
  * 6.2.1 Can Fix 取值：YES、PARTIAL、NO、unFailed。
  * 6.2.2 Exception Guard 取值：PASS、WARN、FAIL，分别对应 Recipe 未触及例外、手工确认、破坏例外。
  * 6.2.3 Memo 描述修复策略、差异文件、例外样例与验证日志路径。
* 6.3 如需导出 eport.json，增加字段 exceptionGuard, exceptionsSamplePath, exceptionsNotes。
* 6.4 若某规则无例外，Memo 明确写入“官方未列出例外，已验证默认行为”。

7.0 后处理与清理 (Post Processing)
* 7.1 若需保留原始不合规代码，验证完成后执行 git checkout -- <ruleId>_uncompliant.java，差异仅留在 diff。
* 7.2 定期校验 docs/sonar 缓存是否过期，官方内容更新时重新抓取、生成样例并复验例外。
* 7.3 汇总 exceptionGuard=FAIL 的规则，分析是否 Recipe 缺陷或示例编造问题，并提出修复计划。

8.0 扩展与自动化 (Future Enhancements)
* 8.1 开发批量脚本串联“抓取 → 解析 → 生成 → 执行 → 例外校验 → 报告”，支持断点续跑。
* 8.2 为解析与例外提取器编写单元测试，确保文本抽取稳定。
* 8.3 引入覆盖度统计：通过 pytest/JUnit 或定制脚本验证例外样例未被改写。
* 8.4 与 CI 集成：在 PR 流水线中执行异常守护脚本，并提供机器可读的失败摘要。

9.0 例外审核操作手册 (Exception Review Playbook)
* 9.1 建立 docs/exception-checklist.md，列出审核要点：官方描述、上下文前置条件、Recipe 行为、测试验证。
* 9.2 每次评审至少由二人复核 _exceptions 代码与 diff，保证例外场景无回归。
* 9.3 对需要豁免的例外记录变更单（包含链接、原因、风险缓解），存档于 docs/exceptions/。

