  ### V8 执行方案 (批量规则与配方验证策略)

  1.0 任务编排 (Task Orchestration)
  *   1.1 从 `mytask.md` 读取待验证规则清单，逐条创建执行记录。
      *   1.1.1 为每条规则标注：规则 ID、Sonar 官方链接、对应 OpenRewrite Recipe FQN、最大重试次数（建议 2）。
      *   1.1.2 初始化状态机：`pending` → `running` → `success|runFailed`，供批量脚本与报告引用。
  *   1.2 为每条规则准备目录 `src/test/java/com/sonarorw/rules/<ruleId>/`。
      *   1.2.1 约定三类产物：`<ruleId>_uncompliant.java`、`<ruleId>_compliant_official.java`、`<ruleId>-diff.md`。

  2.0 官方资料采集 (Official Docs Harvest)
  *   2.1 首次运行使用 `Invoke-WebRequest` 或 `curl` 抓取 Sonar 官方页面，缓存到 `docs/sonar/RSPEC-<ruleId>.html`。
      *   2.1.1 如果本地已存在同名 HTML，则直接读取缓存，避免重复访问网络。
      *   2.1.2 抓取失败时写日志并按预设次数重试；若仍失败，标记该规则为 `runFailed`，并继续后续规则。
  *   2.2 使用解析脚本完整提取页面中的 “Noncompliant code example(s)” 与 “Compliant solution(s)” 区块。
      *   2.2.1 必须保留官方示例的全部代码块、说明文字、顺序；禁止只截取部分片段。
      *   2.2.2 对无法直接编译的片段，以注释或桩代码保留原文，同时注明“编译占位”。

  3.0 样例源码生成 (Sample Materialization)
  *   3.1 生成 `<ruleId>_uncompliant.java`。
      *   3.1.1 文件顶部注释写入完整“不合规”描述与代码，可通过转义确保 ASCII 编译。
      *   3.1.2 将每个不合规示例封装为独立方法（如 `example1()`、`example2()`），必要时补充字段或内部类保持上下文。
  *   3.2 生成 `<ruleId>_compliant_official.java`。
      *   3.2.1 注释写入完整“合规”描述与代码，与官方内容一致。
      *   3.2.2 方法签名与不合规文件保持可比较性，便于 diff。
  *   3.3 若示例需额外依赖或占位，在文件中建立统一的“官方原文保留说明”。

  4.0 Maven 配置管理 (Maven Profiles)
  *   4.1 `pom.xml` 统一维护 `rewrite.version`、`rewrite.plugin.version`、`rewrite.recipes.version` 等属性。
  *   4.2 根 `build` 下的 `rewrite-maven-plugin` 默认启用 `org.openrewrite.java.format.AutoFormat`，并显式添加 `rewrite-static-analysis` 依赖。
  *   4.3 每条规则新增 `<profile>`：
      *   4.3.1 `<id>`=规则 ID，`<activeRecipes>` 列出全部关联的 Recipe。
      *   4.3.2 Profile 内同样追加 `rewrite-static-analysis` 依赖，确保 Recipe 可解析。
      *   4.3.3 若需组合 Recipe，可拓展 `<activeStyles>` 或 `<recipeList>`。

  5.0 执行控制 (Execution Control)
  *   5.1 对每条规则执行 `mvn rewrite:run -P <ruleId> -f pom.xml`，记录退出码与日志。
      *   5.1.1 非零退出码触发自动重试（不超过步骤 1.1.1 预设），并采集错误日志。
      *   5.1.2 重试仍失败即标记 `runFailed`，在 `report.md` 记录失败原因及日志路径。
  *   5.2 成功运行后保存 `target/rewrite` 输出，并生成 `<ruleId>-diff.md`（使用 `git diff --no-index -U0`）。
      *   5.2.1 若 Recipe 未改动 `_uncompliant`，在 Memo 标记 `No change`，并考虑评估为 `NO` 或 `PARTIAL`。
      *   5.2.2 若 Recipe 修改了注释文案，需确认核心代码是否符合预期。

  6.0 报告汇总 (Reporting)
  *   6.1 `report.md` 首行添加表头：`| Rule | Recipe | Can Fix | Memo |`。
  *   6.2 每条规则追加一行：
      *   6.2.1 `Can Fix` 取值：`YES`、`PARTIAL`、`NO`、`runFailed`。
      *   6.2.2 Memo 描述修复策略、差异文件（如 `<ruleId>-diff.md`）或失败原因。
  *   6.3 可选输出 `report.json`，记录执行耗时、重试次数、产物路径。

  7.0 后处理与清理 (Post Processing)
  *   7.1 若需保留原始不合规代码，验证完成后执行 `git checkout -- <ruleId>_uncompliant.java`，并将差异只留在 diff。
  *   7.2 定期校验 `docs/sonar` 缓存是否过期，官方内容更新时重新抓取与生成样例。
  *   7.3 对 `runFailed` 规则集中分析：可能是 Recipe 缺失、HTML 结构变化或示例无法编译。

  8.0 扩展与自动化 (Future Enhancements)
  *   8.1 开发批量执行脚本（PowerShell/Java）串联“抓取 → 解析 → 生成 → 执行 → 报告”。
  *   8.2 为解析器编写单元测试，确认生成的注释内容与 HTML 原文完全一致。
  *   8.3 记录成功运行的 commit hash，实现增量执行或快速回滚。
