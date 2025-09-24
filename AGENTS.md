# Repository Guidelines

## Project Snapshot
- Sonar Rules vs OpenRewrite Recipes Lab targets JDK 8 with Maven 3.9+, comparing SonarQube rule behaviour to OpenRewrite recipes.
- Source code lives entirely under `src/test/java`, where each Sonar rule owns its own package of compliant and noncompliant examples.
- Rewrite runs produce diffs and guard outputs that are archived in `docs/` and `logs/` to support analysis.
- Python helper scripts in `tools/` assist with scraping RSPEC content and generating example snippets.

## Directory Layout
- `src/test/java/com/sonarorw/rules/<rule_id>/` - Java samples; keep files in the pattern `<RuleId>_uncompliant.java`, `<RuleId>_compliant_official.java`, plus optional `_exceptions.java` when needed.
- `docs/` - research material and generated artifacts.
  - `docs/sonar/` caches `RSPEC-*.json` payloads pulled from Sonar.
  - `docs/diffs/` stores Markdown diffs emitted after each recipe run.
  - `docs/mappings/` and `docs/exceptions/` capture rule-to-recipe notes and edge cases.
  - `docs/solu*.md` chronicles solution iterations; add new versions rather than overwriting history.
- `logs/` - raw rewrite logs (scan vs guard) for reproducibility; mirror the naming convention `SXXXX-*.log`.
- `tools/` - Python utilities; update `README-tools.md` whenever a new script is added.
- `report.md`, `mytask.md`, `todo.md` - living documents driving the experiment backlog; treat them as part of the deliverable set.
- `pom.xml` - single source of truth for plugin versions, active rewrite recipes, and rule-specific Maven profiles.

## Build, Test, and Rewrite Commands
- `mvn -q --no-transfer-progress verify` runs the full lifecycle (compiles rule samples and executes rewrite plugin dry runs where configured).
- `mvn rewrite:run -P SXXXX` applies the recipe defined in the matching profile; replace `SXXXX` with the rule identifier (for example `S3457`).
- `mvn rewrite:dryRun -P SXXXX -Drewrite.metricsJson=logs/SXXXX-exception-scan.log` keeps changes off disk while capturing metrics; reuse the `logs/` folder and naming scheme.
- `mvn clean` resets the workspace before re-running a recipe to avoid stale diffs.
- `python tools/generate_rule_snippets.py --rule SXXXX` (optional) regenerates compliant and noncompliant samples from cached RSPEC data.
Log every command variation you rely on inside `report.md` or the relevant diff so others can reproduce the session.

## Working with Rules
1. Pick the next target from `report.md` or `mytask.md` and confirm its Maven profile exists in `pom.xml`.
2. Update or add the Java samples under `src/test/java/com/sonarorw/rules/<rule_id>/`, keeping the file naming pattern and minimal imports.
3. Run `mvn rewrite:run -P <rule_id>` and capture the resulting diff under `docs/diffs/<rule_id>-diff.md`; archive guard and scan logs in `logs/`.
4. Summarise outcomes in `report.md` (status `YES`, `PARTIAL`, `NO`, etc.) and note any manual adjustments or recipe gaps in `docs/mappings/` or `docs/exceptions/`.
5. When diffs require human follow up, record TODOs in `todo.md` with direct links to the affected files.

## Coding Standards and Style
- Java samples should compile on JDK 8; prefer standard Java conventions (4 space indentation, meaningful class names, final fields when appropriate).
- Keep imports minimal; rely on `org.openrewrite.java.format.AutoFormat` (enabled globally) to normalise whitespace and brace placement.
- Factor shared scaffolding into helper methods inside the same package to avoid introducing a shared `src/main` module unless cross rule reuse becomes substantial.
- Python helper scripts target Python 3.9+; follow PEP 8, use type hints where practical, and keep external dependencies optional.
- Preserve ASCII unless the source material mandates Unicode (for example copied rule descriptions).

## Documentation and Reporting
- Treat `docs/diffs/`, `logs/`, and `report.md` as authoritative evidence; do not delete historical runs. Append with timestamps or version tags when rerunning a rule.
- File new observations about Sonar and OpenRewrite mismatches under `docs/exceptions/` to keep the reasoning close to the artifacts.
- Align naming across artifacts (rule ID casing, suffixes like `_exceptions`) so automated parsing remains straightforward.

## Contribution Process
- Use Conventional Commit prefixes (`feat`, `fix`, `docs`, `chore`, `refactor`, `test`, `ci`) with subjects no longer than 72 characters.
- Reference the related rule ID or ticket in the commit body and list the Maven command or commands used for validation.
- Open draft PRs for large profile additions or when introducing new automation into `tools/`.
- Before pushing, run the relevant `mvn` commands (and Python scripts, if touched) to confirm reproducibility.

## Security and Dependency Notes
- Do not commit credentials or Sonar tokens; keep local values in `.env` (document keys in `.env.example` if shared configuration emerges).
- Track Maven dependency updates in `CHANGELOG.md` and rerun `mvn verify` plus `mvn rewrite:dryRun` for a representative rule to detect regressions.
- When Python dependencies become necessary, pin them in `tools/requirements.txt` and document the installation step in the tools README.
