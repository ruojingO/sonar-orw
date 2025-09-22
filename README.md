# Sonar Rules vs OpenRewrite Recipes Lab

这是一个基于 JDK 8 的 Maven 示例项目，用于验证 SonarQube 规则与对应 OpenRewrite 配方之间的自动修复能力。仓库通过为每条规则准备“不合规 / 合规”示例代码、运行 rewrite-maven-plugin、收集 diff 与报告来记录配方的真实表现。

## 目录结构
- `docs/`：说明文档与外部资料缓存
  - `sonar/RSPEC-xxxx.json`：从官方 `page-data` 抓取的规则描述
  - `diffs/`：各规则执行后的差异文件（`Sxxxx-diff.md`）
  - `solu.md`：当前执行方案（V8）
- `src/test/java/com/sonarorw/rules/`：按规则划分的示例源码目录
  - `<ruleId>_uncompliant.java` / `<ruleId>_compliant_official.java`
- `tools/`：辅助脚本（抓取、解析与生成示例）
- `pom.xml`：统一维护 rewrite 插件版本、依赖与每条规则的 `<profile>`
- `report.md`：Sonar 规则、OpenRewrite 配方与修复结论的汇总表

## 使用方法
1. 选择目标规则（参见 `report.md` 或 `mytask.md`）。
2. 准备 / 更新对应目录下的 `_uncompliant` 与 `_compliant_official` 示例。
3. 运行 `mvn rewrite:run -P <规则ID> -f pom.xml` 触发配方。
4. 查看 `docs/diffs/<规则ID>-diff.md` 与 `report.md`，判断修复效果。

## 已知情况
- `S3457`、`S2692` 仅实现部分自动修复（报告中标记为 `PARTIAL`）。
- `S2162`、`S888` 当前配方无改动（报告中标记为 `NO`），需要人工介入。
- 其余规则均完成自动修复并产生对应 diff。

## 依赖环境
- JDK 8
- Maven 3.9+
- OpenRewrite 8.62.1（插件 6.18.0，静态分析配方 2.17.0）

