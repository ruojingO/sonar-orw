# Task 2 – OpenRewrite Free Capability Catalog

## Scope & Assumptions
- Snapshot based on GitHub `openrewrite/*` repositories queried during this task (Invoke-RestMethod, 2025-02-14 UTC).
- Focus stays on freely available assets; no commercial Moderne services included.
- All entries listed in the free catalog originate from public repositories in the openrewrite GitHub org and run without a Moderne subscription.
- `*` in the Fit column highlights repositories immediately valuable to our Java EE runtime mix (Tomcat, WebLogic, WebSphere, TongWeb) or supporting pipelines.

## How to Read This Catalog
- **Repository**: GitHub project name for quick navigation.
- **Key Artifacts (OSS)**: Maven coordinates or packaged deliverables published to Maven Central (when applicable).
- **Purpose**: Concise description of what the repository delivers.
- **Fit**: `*` = high-priority for our estate; blank = optional/niche yet still free to experiment with.

## Core Platform & Authoring
| Repository | Key Artifacts (OSS) | Purpose | Fit |
| --- | --- | --- | --- |
| rewrite | `org.openrewrite:rewrite-core`, `org.openrewrite:rewrite-java` | Core engine & Java parser | * |
| rewrite-analysis | `org.openrewrite:rewrite-analysis` | Shared analysis utilities | * |
| rewrite-static-analysis | `org.openrewrite.recipe:rewrite-static-analysis` | Static-analysis fix suite | * |
| rewrite-all | — | Aggregate BOM of all recipes |  |
| rewrite-recipe-bom | `org.openrewrite.recipe:rewrite-recipe-bom` | Version-pinned recipe BOM | * |
| rewrite-template-generator | — | Recipe scaffolding helpers |  |
| rewrite-templating | — | Templating DSL utilities |  |
| rewrite-recipe-markdown-generator | — | Recipe documentation generator |  |
| rewrite-recommendations | — | Recipe prioritisation experiments |  |
| rewrite-generative-ai | — | AI-assisted diff/recipe drafts |  |
| rewrite-rewrite | — | Self-hosted rewrite playground |  |

## JVM Modernization & Library Recipes
| Repository | Key Artifacts (OSS) | Purpose | Fit |
| --- | --- | --- | --- |
| rewrite-migrate-java | `org.openrewrite.recipe:rewrite-migrate-java` | JDK upgrade playbooks | * |
| rewrite-java-dependencies | `org.openrewrite.recipe:rewrite-java-dependencies` | Dependency realignment recipes | * |
| rewrite-java-security | `org.openrewrite.recipe:rewrite-java-security` | Security hardening fixes | * |
| rewrite-java-annotproc | `org.openrewrite.recipe:rewrite-java-annotproc` | Annotation processor cleanup | * |
| rewrite-java-8 | — | Legacy Java 8 uplift samples | * |
| rewrite-openapi | `org.openrewrite.recipe:rewrite-openapi` | OpenAPI spec/client alignment | * |
| rewrite-okhttp | `org.openrewrite.recipe:rewrite-okhttp` | OkHttp API migration helpers |  |
| rewrite-jackson | `org.openrewrite.recipe:rewrite-jackson` | Jackson configuration updates | * |
| rewrite-joda | `org.openrewrite.recipe:rewrite-joda` | Joda-Time to java.time migration | * |
| rewrite-dropwizard | `org.openrewrite.recipe:rewrite-dropwizard` | Dropwizard service upkeep |  |

## Framework & Server Modernization
| Repository | Key Artifacts (OSS) | Purpose | Fit |
| --- | --- | --- | --- |
| rewrite-spring | `org.openrewrite.recipe:rewrite-spring` | Spring/Boot upgrade suite | * |
| rewrite-spring-to-quarkus | `org.openrewrite.recipe:rewrite-spring-to-quarkus` | Spring-to-Quarkus transition |  |
| rewrite-quarkus | `org.openrewrite.recipe:rewrite-quarkus` | Quarkus upkeep recipes |  |
| rewrite-micronaut | `org.openrewrite.recipe:rewrite-micronaut` | Micronaut modernization |  |
| rewrite-jhipster | `org.openrewrite.recipe:rewrite-jhipster` | JHipster scaffold maintenance |  |
| rewrite-liberty | `org.openrewrite.recipe:rewrite-liberty` | WebSphere Liberty alignment | * |
| rewrite-apache | `org.openrewrite.recipe:rewrite-apache` | Apache library modernization | * |
| rewrite-struts | `org.openrewrite.recipe:rewrite-struts` | Struts hardening & migrations | * |
| rewrite-hibernate | `org.openrewrite.recipe:rewrite-hibernate` | Hibernate/JPA best practices | * |
| rewrite-netty | `org.openrewrite.recipe:rewrite-netty` | Netty service tuning |  |

## Build, CI/CD & Runtime Tooling
| Repository | Key Artifacts (OSS) | Purpose | Fit |
| --- | --- | --- | --- |
| rewrite-maven-plugin | `org.openrewrite.maven:rewrite-maven-plugin` | Maven goals for rewrite runs | * |
| rewrite-gradle-plugin | `org.openrewrite.gradle.plugin:rewrite-gradle-plugin` | Gradle plugin for recipe runs |  |
| rewrite-gradle | `org.openrewrite:rewrite-gradle` | Gradle build parser & recipes |  |
| rewrite-build-gradle-plugin | — | Legacy Gradle plugin support |  |
| rewrite-gradle-tooling-model | — | Gradle tooling API bridge |  |
| rewrite-github-actions | — | GitHub Actions workflow templates |  |
| rewrite-gitlab | — | GitLab CI pipeline templates |  |
| rewrite-jenkins | — | Jenkins automation library | * |
| rewrite-docker | `org.openrewrite.recipe:rewrite-docker` | Dockerfile modernization recipes |  |
| rewrite-npm | `org.openrewrite.recipe:rewrite-npm` | Node/NPM dependency updates |  |
| rewrite-cloud-suitability-analyzer | `org.openrewrite.recipe:rewrite-cloud-suitability-analyzer` | Cloud readiness scoring | * |
| rewrite-testcontainers | `org.openrewrite.recipe:rewrite-testcontainers` | Testcontainers alignment |  |

## Testing, Observability & Quality
| Repository | Key Artifacts (OSS) | Purpose | Fit |
| --- | --- | --- | --- |
| rewrite-testing-frameworks | `org.openrewrite.recipe:rewrite-testing-frameworks` | JUnit/TestNG upgrade suite | * |
| rewrite-cucumber-jvm | `org.openrewrite.recipe:rewrite-cucumber-jvm` | Cucumber step upkeep |  |
| rewrite-logging-frameworks | `org.openrewrite.recipe:rewrite-logging-frameworks` | Logging framework normalization | * |
| rewrite-micrometer | `org.openrewrite.recipe:rewrite-micrometer` | Micrometer metrics alignment | * |
| rewrite-checkstyle | `org.openrewrite.recipe:rewrite-checkstyle` | Checkstyle rules as recipes | * |
| rewrite-feature-flags | `org.openrewrite.recipe:rewrite-feature-flags` | Feature toggle harmonization |  |

## Polyglot & Extended Ecosystem
| Repository | Key Artifacts (OSS) | Purpose | Fit |
| --- | --- | --- | --- |
| rewrite-polyglot | — | Multi-language parsing support |  |
| rewrite-kotlin | `org.openrewrite:rewrite-kotlin` | Kotlin AST & recipes |  |
| rewrite-python | `org.openrewrite:rewrite-python` | Python AST & experiments |  |
| rewrite-javascript | `org.openrewrite:rewrite-javascript` | JavaScript/TypeScript recipes |  |
| rewrite-csharp | `org.openrewrite:rewrite-csharp` | C# parser foundation |  |
| rewrite-csharp-recipes | — | C# modernization samples |  |
| proleap-cobol-parser | — | COBOL grammar for legacy apps |  |

## Reference, Samples & Org Utilities
| Repository | Key Artifacts (OSS) | Purpose | Fit |
| --- | --- | --- | --- |
| spring-petclinic-migration | — | Spring upgrade showcase | * |
| sample-maven-dependencies | — | Dependency test fixtures |  |
| rewrite-docs | — | Docs site source |  |
| openrewrite.github.io | — | Website content repo |  |
| rewrite-houston-jug | — | JUG workshop material |  |
| rewrite-sandbox | — | Experimental recipe playground |  |
| collaboration-proposals | — | RFC discussion hub |  |
| rewrite-third-party | — | Community recipe packs | * |
| moderneinc__git-test | — | Org CI regression harness |  |
| gh-automation | — | Org automation scripts |  |
| .github | — | Shared issue/CI templates |  |
| java-object-diff | — | Object diff utility mirror |  |
| jgit | — | Eclipse JGit mirror |  |
| h2database | — | Embedded DB fixture mirror |  |
| lombok | — | Lombok mirror for parser support |  |

## Non-Free (Moderne) Services
| Offering | Access Mechanism | Purpose | Audience |
| --- | --- | --- | --- |
| Moderne Spring Web XML Migration | `mod run moderne/spring-webxml` (Moderne CLI) | Spring XML dispatcher → Java config | Enterprise customers with active Moderne subscriptions |
| Moderne Spring Release Train Upgrades | Moderne SaaS catalog (`app.moderne.io`), `mod run moderne/spring-release-upgrade` | Spring/Boot release alignment | Business users under Moderne commercial licensing |
| Moderne Apache Modernization Pack | Moderne SaaS catalog (`app.moderne.io`), `mod run moderne/apache-hardening` | Advanced Apache stack hardening | Organisations licensing Moderne packs for ASF workloads |
| Moderne Java Security Hardening | Moderne SaaS catalog (`app.moderne.io`), `mod run moderne/java-security-hardening` | Managed security policy updates | Regulated enterprises leveraging Moderne security SLAs |
| Moderne Cloud & Container Readiness | Moderne SaaS catalog (`app.moderne.io`), `mod run moderne/cloud-ready` | Container & cloud migration guidance | Enterprises pursuing managed cloud migration engagements |
| Moderne Data & Persistence Modernization | Moderne SaaS catalog (`app.moderne.io`), `mod run moderne/persistence-modernize` | Legacy data access → JPA/Spring Data | Organisations signed to Moderne data-modernization offerings |

*Command identifiers reflect Moderne catalog naming conventions; confirm with your Moderne representative before scripting.*

## Coverage Notes
- Every public repository returned by the GitHub API (71 at capture time) is represented above; cross-cutting projects are listed once under their dominant focus.
- Recipes without published artifacts still provide source-level guidance and can be vendored into our internal rewrite distributions if needed.

## Follow-Up Ideas
1. Build a shared `rewrite.yml` enabling all `*` modules, run `mvn rewrite:dryRun` on representative WAR/EAR services, and document gaps in `report.md`.
2. Use Dependabot/Renovate to watch `rewrite-recipe-bom` and other starred artifacts so modernization queues stay current.
3. For starred framework packs (Struts, Liberty, Hibernate), schedule pilot migrations and record exceptions in `docs/exceptions/`.
4. Re-run the GitHub inventory quarterly and append new repositories or retire archived ones to keep this catalog evergreen.
