# Task 2 – OpenRewrite 免费能力目录（中文）

## 范围与假设
- 数据来自 2025-02-14 UTC 使用 `Invoke-RestMethod` 抓取的 GitHub `openrewrite/*` 仓库快照。
- 仅收录可自由使用的开源资产；不含 Moderne 付费内容。
- 表格中带 `*` 的条目对我们的 Java EE 运行环境（Tomcat、WebLogic、WebSphere、TongWeb 等）最具即时价值。

## 阅读指引
- **仓库**：GitHub 项目名称，便于跳转。
- **开源制品**：发布到 Maven Central 的坐标或可直接使用的制品（若存在）。
- **用途**：精炼描述该仓库提供的能力。
- **适配度**：`*` 表示对当前环境优先推荐；留空代表可选或场景特殊。

## 核心平台与编写工具
| 仓库 | 开源制品 | 用途 | 适配度 |
| --- | --- | --- | --- |
| rewrite | `org.openrewrite:rewrite-core`, `org.openrewrite:rewrite-java` | 核心引擎与 Java 解析 | * |
| rewrite-analysis | `org.openrewrite:rewrite-analysis` | 通用分析工具集 | * |
| rewrite-static-analysis | `org.openrewrite.recipe:rewrite-static-analysis` | 静态分析修复套件 | * |
| rewrite-all | — | 全量配方聚合 BOM |  |
| rewrite-recipe-bom | `org.openrewrite.recipe:rewrite-recipe-bom` | 配方版本锁定 BOM | * |
| rewrite-template-generator | — | 配方脚手架工具 |  |
| rewrite-templating | — | 模板 DSL 组件 |  |
| rewrite-recipe-markdown-generator | — | 配方文档生成 |  |
| rewrite-recommendations | — | 配方优先级实验 |  |
| rewrite-generative-ai | — | AI Diff/配方草稿 |  |
| rewrite-rewrite | — | Rewrite 自托管沙箱 |  |

## JVM 现代化与类库配方
| 仓库 | 开源制品 | 用途 | 适配度 |
| --- | --- | --- | --- |
| rewrite-migrate-java | `org.openrewrite.recipe:rewrite-migrate-java` | JDK 升级脚本 | * |
| rewrite-java-dependencies | `org.openrewrite.recipe:rewrite-java-dependencies` | 依赖重整配方 | * |
| rewrite-java-security | `org.openrewrite.recipe:rewrite-java-security` | 安全加固修复 | * |
| rewrite-java-annotproc | `org.openrewrite.recipe:rewrite-java-annotproc` | 注解处理清理 | * |
| rewrite-java-8 | — | Java 8 代码提升示例 | * |
| rewrite-openapi | `org.openrewrite.recipe:rewrite-openapi` | OpenAPI 规范/客户端对齐 | * |
| rewrite-okhttp | `org.openrewrite.recipe:rewrite-okhttp` | OkHttp API 迁移 |  |
| rewrite-jackson | `org.openrewrite.recipe:rewrite-jackson` | Jackson 配置更新 | * |
| rewrite-joda | `org.openrewrite.recipe:rewrite-joda` | Joda-Time 到 java.time | * |
| rewrite-dropwizard | `org.openrewrite.recipe:rewrite-dropwizard` | Dropwizard 维护 |  |

## 框架与服务器现代化
| 仓库 | 开源制品 | 用途 | 适配度 |
| --- | --- | --- | --- |
| rewrite-spring | `org.openrewrite.recipe:rewrite-spring` | Spring/Boot 升级总集 | * |
| rewrite-spring-to-quarkus | `org.openrewrite.recipe:rewrite-spring-to-quarkus` | Spring 向 Quarkus 迁移 |  |
| rewrite-quarkus | `org.openrewrite.recipe:rewrite-quarkus` | Quarkus 版本跟进 |  |
| rewrite-micronaut | `org.openrewrite.recipe:rewrite-micronaut` | Micronaut 现代化 |  |
| rewrite-jhipster | `org.openrewrite.recipe:rewrite-jhipster` | JHipster 脚手架维护 |  |
| rewrite-liberty | `org.openrewrite.recipe:rewrite-liberty` | WebSphere Liberty 对齐 | * |
| rewrite-apache | `org.openrewrite.recipe:rewrite-apache` | Apache 类库现代化 | * |
| rewrite-struts | `org.openrewrite.recipe:rewrite-struts` | Struts 加固与迁移 | * |
| rewrite-hibernate | `org.openrewrite.recipe:rewrite-hibernate` | Hibernate/JPA 最佳实践 | * |
| rewrite-netty | `org.openrewrite.recipe:rewrite-netty` | Netty 服务调优 |  |

## 构建、CI/CD 与运行支撑
| 仓库 | 开源制品 | 用途 | 适配度 |
| --- | --- | --- | --- |
| rewrite-maven-plugin | `org.openrewrite.maven:rewrite-maven-plugin` | Maven 执行入口 | * |
| rewrite-gradle-plugin | `org.openrewrite.gradle.plugin:rewrite-gradle-plugin` | Gradle 插件 |  |
| rewrite-gradle | `org.openrewrite:rewrite-gradle` | Gradle 脚本解析与配方 |  |
| rewrite-build-gradle-plugin | — | 旧版 Gradle 插件支持 |  |
| rewrite-gradle-tooling-model | — | Gradle Tooling API 桥接 |  |
| rewrite-github-actions | — | GitHub Actions 模板 |  |
| rewrite-gitlab | — | GitLab CI 模板 |  |
| rewrite-jenkins | — | Jenkins 自动化库 | * |
| rewrite-docker | `org.openrewrite.recipe:rewrite-docker` | Dockerfile 现代化 |  |
| rewrite-npm | `org.openrewrite.recipe:rewrite-npm` | Node/NPM 依赖维护 |  |
| rewrite-cloud-suitability-analyzer | `org.openrewrite.recipe:rewrite-cloud-suitability-analyzer` | 上云适配评分 | * |
| rewrite-testcontainers | `org.openrewrite.recipe:rewrite-testcontainers` | Testcontainers 规范化 |  |

## 测试、可观测性与质量
| 仓库 | 开源制品 | 用途 | 适配度 |
| --- | --- | --- | --- |
| rewrite-testing-frameworks | `org.openrewrite.recipe:rewrite-testing-frameworks` | JUnit/TestNG 升级 | * |
| rewrite-cucumber-jvm | `org.openrewrite.recipe:rewrite-cucumber-jvm` | Cucumber 步骤维护 |  |
| rewrite-logging-frameworks | `org.openrewrite.recipe:rewrite-logging-frameworks` | 日志框架统一 | * |
| rewrite-micrometer | `org.openrewrite.recipe:rewrite-micrometer` | Micrometer 指标对齐 | * |
| rewrite-checkstyle | `org.openrewrite.recipe:rewrite-checkstyle` | Checkstyle 规则迁移 | * |
| rewrite-feature-flags | `org.openrewrite.recipe:rewrite-feature-flags` | 功能开关统一 |  |

## 多语言生态扩展
| 仓库 | 开源制品 | 用途 | 适配度 |
| --- | --- | --- | --- |
| rewrite-polyglot | — | 多语言解析支撑 |  |
| rewrite-kotlin | `org.openrewrite:rewrite-kotlin` | Kotlin AST 与配方 |  |
| rewrite-python | `org.openrewrite:rewrite-python` | Python AST 与实验 |  |
| rewrite-javascript | `org.openrewrite:rewrite-javascript` | JavaScript/TypeScript 配方 |  |
| rewrite-csharp | `org.openrewrite:rewrite-csharp` | C# 解析基础 |  |
| rewrite-csharp-recipes | — | C# 现代化示例 |  |
| proleap-cobol-parser | — | COBOL 语法支持 |  |

## 参考样例与组织工具
| 仓库 | 开源制品 | 用途 | 适配度 |
| --- | --- | --- | --- |
| spring-petclinic-migration | — | Spring 升级示例 | * |
| sample-maven-dependencies | — | 依赖测试样例 |  |
| rewrite-docs | — | 文档站点源码 |  |
| openrewrite.github.io | — | 官网内容仓库 |  |
| rewrite-houston-jug | — | JUG 活动素材 |  |
| rewrite-sandbox | — | 配方实验沙箱 |  |
| collaboration-proposals | — | RFC 讨论区 |  |
| rewrite-third-party | — | 社区配方集合 | * |
| moderneinc__git-test | — | 组织级 CI 回归 |  |
| gh-automation | — | 组织自动化脚本 |  |
| .github | — | Issue/CI 模板 |  |
| java-object-diff | — | 对象 Diff 工具镜像 |  |
| jgit | — | Eclipse JGit 镜像 |  |
| h2database | — | 嵌入式 DB 镜像 |  |
| lombok | — | Lombok 支持镜像 |  |

## 非免费（Moderne）服务
| 服务 | 获取方式 | 用途 | 适用对象 |
| --- | --- | --- | --- |
| Moderne Spring Web XML Migration | `mod run moderne/spring-webxml`（Moderne CLI） | Spring XML Dispatcher 转 Java 配置 | 持有 Moderne 订阅的企业用户 |
| Moderne Spring Release Train Upgrades | Moderne SaaS (`app.moderne.io`)，`mod run moderne/spring-release-upgrade` | Spring/Boot 版本列车对齐 | 付费商务用户 |
| Moderne Apache Modernization Pack | Moderne SaaS (`app.moderne.io`)，`mod run moderne/apache-hardening` | Apache 技术栈强化 | 购买 ASF 方案的组织 |
| Moderne Java Security Hardening | Moderne SaaS (`app.moderne.io`)，`mod run moderne/java-security-hardening` | 托管安全策略更新 | 受监管企业 |
| Moderne Cloud & Container Readiness | Moderne SaaS (`app.moderne.io`)，`mod run moderne/cloud-ready` | 容器与上云迁移指导 | 推进云化的企业 |
| Moderne Data & Persistence Modernization | Moderne SaaS (`app.moderne.io`)，`mod run moderne/persistence-modernize` | 旧版数据访问转 JPA/Spring Data | 参与 Moderne 数据现代化方案的组织 |

*命令标识以 Moderne 目录命名为准，落地前请先向 Moderne 客服确认。*

## 覆盖说明
- 上述列表覆盖 GitHub API 返回的全部 71 个公开仓库，每个仓库仅按照主用途列出一次。
- 仍未发布制品的仓库可直接拉源码自建配方或内部分发。

## 后续行动建议
1. 基于表内 `*` 条目整理公共 `rewrite.yml`，先在代表性 WAR/EAR 服务上执行 `mvn rewrite:dryRun`，同步结果到 `report.md`。
2. 使用 Dependabot/Renovate 关注 `rewrite-recipe-bom` 等重点组件的版本更新。
3. 对 Struts、Liberty、Hibernate 等重点框架安排试跑，将例外情况记录到 `docs/exceptions/`。
4. 每季度重新抓取 GitHub 列表，追加新仓库或标注已归档项目，保持目录最新。
