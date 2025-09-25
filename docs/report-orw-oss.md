# OpenRewrite OSS Adoption Snapshot

## Scope
- Derived from `docs/task2.md` (2025-02-14 OSS catalog) with license spot-checks on highlighted modules.
- Focus on the OSS components our company prioritised for near-term rollout.
- All entries below are covered by permissive licenses (Apache 2.0 or equivalent) and runnable without Moderne subscriptions.

## Priority Modules & Key Capabilities
| Module | Main Feature Highlights | Fit Notes |
| --- | --- | --- |
| `org.openrewrite.recipe:rewrite-static-analysis` | 1) Bundles dozens of Java static-analysis remediations (BigDecimal constructors, equals contracts, unnecessary semicolons).<br>2) Leverages OpenRewrite AutoFormat to keep whitespace/brace style consistent after fixes. | Direct bridge from Task 1 rule coverage; ready for CI integration. |
| `org.openrewrite.recipe:rewrite-migrate-java` | 1) Provides curated upgrade recipes for each major Java release (6→8, 8→11, 11→17).<br>2) Includes optional steps to adopt modern language features (try-with-resources, diamond operator, pattern matching). | Supports mandated JDK uplift roadmap across Tomcat/WebLogic/WebSphere services. |
| `org.openrewrite.recipe:rewrite-java-security` | 1) Harden TLS/crypto usage by replacing weak protocol/cipher settings and insecure `SecureRandom` initialisation.<br>2) Delivers CWE-focused hardening (e.g. XXE protection, credential masking) aligned with OWASP recommendations.<br><br>*Repository archived upstream but source remains Apache-2.0 and fully buildable locally.* | Addresses compliance gaps flagged by internal audits while staying OSS. |
| `org.openrewrite.recipe:rewrite-java-annotproc` | 1) Normalises annotation processor configuration (generated-source directories, options) to modern compiler defaults.<br>2) Prunes obsolete or duplicate processors that inflate build times. | Keeps build pipelines stable when migrating to newer compilers. |
| `org.openrewrite.recipe:rewrite-okhttp` | 1) Migrates legacy OkHttp 3.x call patterns to the 4.x `OkHttpClient`/`Request` builder API.<br>2) Aligns connection pooling, timeout, and TLS settings with upstream defaults. | Targets shared HTTP client libraries across integration services. |
| `org.openrewrite.recipe:rewrite-jackson` | 1) Auto-registers Jackson modules (JavaTimeModule, ParameterNamesModule) and rewrites deprecated configuration hooks.<br>2) Applies safer `SerializationFeature`/`DeserializationFeature` defaults to prevent CVE-prone behavior. | Mitigates serialization drift and CVE-driven upgrade churn. |
| `org.openrewrite.recipe:rewrite-joda` | 1) Rewrites `org.joda.time` types/usages to `java.time` equivalents.<br>2) Removes redundant dependency coordinates once migration is complete. | Enables removal of legacy Joda dependencies before platform certification checks. |
| `org.openrewrite.recipe:rewrite-spring` | 1) Automates Spring & Spring Boot release train upgrades (properties, dependencies, BOMs).<br>2) Converts XML bean definitions to annotation/Java config where possible.<br>3) Updates API usages across WebMVC, Security, Data, and Scheduling packages. | Critical for apps running across Tomcat/WebLogic/TongWeb with mixed Spring versions. |
| `org.openrewrite.recipe:rewrite-npm` | 1) Resolves duplicate/transitive dependencies and enforces consistent semver ranges.<br>2) Regenerates package lockfiles to surface and eliminate vulnerable packages. | Keeps frontend assets bundled with WAR/EAR projects compliant with security policies. |
| `org.openrewrite.recipe:rewrite-logging-frameworks` | 1) Replaces direct `System.out/err` logging with SLF4J abstractions.<br>2) Upgrades Log4J 1.x/commons-logging code paths to Logback or Log4J2. | Aligns logging with container standards, reducing operational noise. |
| `org.openrewrite:rewrite-javascript` | 1) Supplies a JavaScript/TypeScript parser plus codemods for CommonJS→ESM migration and modern syntax.<br>2) Enforces consistent formatting/lint-friendly patterns across mixed JS/TS codebases. | Supports UI code embedded within enterprise portals. |

## Execution Plan
1. **Profile Assembly**: Build a shared `rewrite.yml` enabling the modules above; store under `config/rewrite` and reference from Maven profiles.
2. **Pilot Services**: Run `mvn rewrite:dryRun` on at least one representative service per container (Tomcat, WebLogic, WebSphere, TongWeb) to capture diffs and metrics.
3. **Gap Logging**: Record successes and misses in `report.md`; document recipe mismatches or exclusions in `docs/exceptions/` when applicable.
4. **Automation Rollout**: Integrate rewrite runs into CI (Jenkins/GitLab) using the OSS plugin; gate merges on clean dry-run output for the targeted modules.
5. **Frontend Alignment**: Apply `rewrite-npm` and `rewrite-javascript` recipes within frontend build pipelines to synchronise Node assets before release.
6. **Security Sweep**: Schedule quarterly executions of `rewrite-java-security` and `rewrite-logging-frameworks` to keep pace with compliance requirements.
7. **Review & Iterate**: After each quarterly run, refresh the module list from `task2.md` and adjust profiles as new OSS recipes become relevant.
