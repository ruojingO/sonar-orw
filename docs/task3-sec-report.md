# Task 3 – rewrite-java-security 可用性验证

## 任务概述
- 目标：确认 `org.openrewrite.recipe:rewrite-java-security` 仍以开源方式发布，列举 1–3 个可直接使用的安全配方，并说明如何获取。
- 结果：Maven Central 提供最新的 2.1.x 版本（Apache-2.0 许可证），无需 Moderne 付费账号即可下载源码与二进制。

## 工件来源与许可证
1. GitHub 仓库：`https://github.com/openrewrite/rewrite-java-security`（状态为 Archived，但保留 Apache-2.0 许可）。
2. Maven Central：`https://repo1.maven.org/maven2/org/openrewrite/recipe/rewrite-java-security/` 可浏览全部版本。
3. 通过 PowerShell 直接下载源码包验证：
   ```powershell
   Invoke-WebRequest "https://repo1.maven.org/maven2/org/openrewrite/recipe/rewrite-java-security/2.1.3/rewrite-java-security-2.1.3-sources.jar" -OutFile tmp/rewrite-java-security-2.1.3-sources.jar
   ```
   解压后可看到完整 Java 源码及 META-INF/rewrite 配置，证明配方可离线使用。

## 代表性配方（示例）
| 配方类 | 主要作用 | 备注 |
| --- | --- | --- |
| `SecureRandom` | 将 `new java.util.Random()` 自动替换为 `new java.security.SecureRandom()`，遵循 Sonar RSPEC-2245。 | 位于 `org/openrewrite/java/security/SecureRandom.java`。 |
| `XmlParserXXEVulnerability` | 扫描 XML 解析工厂（`DocumentBuilderFactory`、`TransformerFactory`、`XMLInputFactory`）并设置防 XXE 选项。 | 利用 ScanningRecipe 聚合多个 visitor。 |
| `SecureTempFileCreation` | 将 `File.createTempFile` 迁移为 `Files.createTempFile(...).toFile()`，避免不安全的默认权限。 | 同时复用 `UseFilesCreateTempDirectory`。 |

> 以上类均包含 Apache-2.0 头部声明，可在源码包中查看。

## 项目内验证步骤
1. **新增样例代码**：在 `src/test/java/com/sonarorw/sec/` 下创建：
   - `SecuritySamples_uncompliant.java`（包含 `new Random()`、`File.createTempFile`、未加固的 `DocumentBuilderFactory`）；
   - `SecuritySamples_compliant.java`（对应安全写法）。
2. **新增 Maven Profile**：在 `pom.xml` 中加入 `S-SECURITY`，激活下列配方：
   - `org.openrewrite.java.security.SecureRandom`
   - `org.openrewrite.java.security.SecureTempFileCreation`
   - `org.openrewrite.java.security.XmlParserXXEVulnerability`
   并通过 `<dependency>` 引入 `org.openrewrite.recipe:rewrite-java-security:2.1.3`。
3. **命令执行**：
   ```bash
   mvn rewrite:dryRun -P S-SECURITY -Drewrite.metricsJson=logs/S-SECURITY-dryrun-metrics.json
   ```

## 实际运行结果
- Maven 能够自动下载 `rewrite-java-security-2.1.3.jar`，验证依赖在公共仓库可用。
- 在主工程（rewrite plugin 6.18.0 + rewrite-bom 8.62.1）下执行 dry-run，出现 `NoSuchMethodError: ChangeDependencyGroupIdAndArtifactId`，确认是新版 Rewrite Core API 变更导致的兼容性问题。
- 另建独立 `pom-sec.xml`（锁定 rewrite-bom 8.11.1、rewrite-maven-plugin 6.10.0 并将配方依赖挂在 `<plugin><dependencies>`），dry-run 可以解析配方，但仍因插件内部拉取的高版本 Rewrite 组件触发 `DataTable` 构造函数签名不匹配。后续需继续在插件依赖中补齐其它 8.11.x 组件或改用老版本 Rewrite CLI 执行。
- 推荐处理路径：
  1. 建立专门的 “security sample” 工程，将所有 Rewrite 组件固定到 8.11.1 生态后再运行配方；
  2. 若主仓库仍需使用最新 Rewrite，可关注 `rewrite-java-security` 是否发布新版本，或在 Moderne 平台寻找同步更新的安全配方。

## 免费/付费结论
- `rewrite-java-security` 及其源码、配方均可从 Maven Central 下载，无需登陆或订阅，证实其属于 Task 2 所定义的 OSS 资源。
- Moderne 平台仍提供更多托管安全组合，但基础配方已经可以在开源环境脱机使用；只需解决版本兼容即可运行。

## 后续动作
1. 评估是否建立基于 Rewrite 8.11.1 的轻量示例工程，以便运行安全配方并输出修复 diff。
2. 记录 dry-run 过程中遇到的兼容性异常，纳入 `docs/exceptions/` 或 `report.md`，以便团队在统一升级策略时参考。
