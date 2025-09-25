# OpenRewrite OSS 采纳快照

## 范围
- 基于 `docs/task2.md`（2025-02-14 OSS 目录）并对重点模块完成许可核对。
- 聚焦公司短期内计划落地的开源组件。
- 以下条目均为宽松许可（Apache 2.0 等）并可在无 Moderne 订阅下使用。

## 优先模块与核心能力
| 模块 | 主要特性亮点 | 适配说明 |
| --- | --- | --- |
| `org.openrewrite.recipe:rewrite-static-analysis` | 1) 汇集数十个 Java 静态分析修复（BigDecimal 构造、equals 合约、多余分号等）；<br>2) 结合 AutoFormat 保持修复后代码风格一致。 | 直接承接 Task 1 规则覆盖，适合接入 CI。 |
| `org.openrewrite.recipe:rewrite-migrate-java` | 1) 提供 Java 6→8→11→17 的升级配方；<br>2) 覆盖 try-with-resources、菱形操作符、模式匹配等现代特性启用步骤。 | 满足 Tomcat/WebLogic/WebSphere 升级路线的基础需求。 |
| `org.openrewrite.recipe:rewrite-java-security` | 1) 强化 TLS/加密配置，替换弱协议/随机源；<br>2) 推进 XXE 防护、凭据遮蔽等与 OWASP 对齐的安全改造。<br><br>*上游仓库虽已归档，但源码仍为 Apache-2.0，可在内部继续构建使用。* | 在保持开源属性的同时弥补合规审计短板。 |
| `org.openrewrite.recipe:rewrite-java-annotproc` | 1) 统一注解处理器的生成目录与编译参数；<br>2) 清理冗余或失效的处理器以缩短构建时间。 | 支撑编译器升级时期的流水线稳定性。 |
| `org.openrewrite.recipe:rewrite-okhttp` | 1) 将 OkHttp 3.x 调用迁移至 4.x `OkHttpClient`/`Request` API；<br>2) 对齐连接池、超时、TLS 等默认配置。 | 覆盖公司共享 HTTP 客户端库。 |
| `org.openrewrite.recipe:rewrite-jackson` | 1) 自动注册 JavaTimeModule、ParameterNamesModule 等必备模块并更新废弃配置；<br>2) 套用更安全的 `SerializationFeature`/`DeserializationFeature` 默认值。 | 降低序列化偏差与 CVE 触发概率。 |
| `org.openrewrite.recipe:rewrite-joda` | 1) 将 `org.joda.time` 类型迁移至 `java.time`；<br>2) 在迁移完成后自动剔除冗余依赖。 | 为平台认证前的 Joda 清退提供自动化支撑。 |
| `org.openrewrite.recipe:rewrite-spring` | 1) 自动推进 Spring/Spring Boot 版本列车（属性、依赖、BOM）；<br>2) 在可行场景下将 XML Bean 转换为注解/Java 配置；<br>3) 更新 WebMVC、Security、Data、Scheduling 等 API 使用。 | 解决 Tomcat/WebLogic/TongWeb 环境中 Spring 版本杂糅问题。 |
| `org.openrewrite.recipe:rewrite-npm` | 1) 合并重复依赖并统一 semver 范围；<br>2) 重新生成锁文件以暴露并清除漏洞包。 | 保障 WAR/EAR 所携带前端资产符合安全策略。 |
| `org.openrewrite.recipe:rewrite-logging-frameworks` | 1) 将 `System.out/err` 重定向至 SLF4J；<br>2) 将 Log4J 1.x/commons logging 升级到 Logback 或 Log4J2。 | 降低容器运行时的噪声与风险。 |
| `org.openrewrite:rewrite-javascript` | 1) 提供 JS/TS 解析与 CommonJS→ESM、现代语法改造配方；<br>2) 统一格式，保障多语言工程的 lint 友好性。 | 支撑企业门户中嵌入的前端代码。 |

## 执行计划
1. **配置集成**：整理共享版 `rewrite.yml` 并置于 `config/rewrite`，供 Maven Profile 引用。
2. **试点服务**：针对 Tomcat、WebLogic、WebSphere、TongWeb 各挑选一个代表项目执行 `mvn rewrite:dryRun`，收集 diff 与指标。
3. **缺口记录**：将成功/失败样例写入 `report.md`，必要时把配方不适用情况归档到 `docs/exceptions/`。
4. **自动化落地**：在 Jenkins/GitLab CI 引入 Rewrite 插件流程，确保目标模块 dry-run 通过后方可合并。
5. **前端同步**：在前端构建流水线内启用 `rewrite-npm` 与 `rewrite-javascript`，保证 Node 依赖与脚本一致。
6. **安全巡检**：季更执行 `rewrite-java-security` 与 `rewrite-logging-frameworks` 检查，保持合规节奏。
7. **复盘迭代**：季度复盘后参考 `task2.md` 更新模块清单，并根据新增 OSS 配方调整 profile。
