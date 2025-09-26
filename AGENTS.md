# Repository Guidelines (Minimal • Single-Module Maven • JDK 17 • Tests Optional)

> Purpose: provide the smallest, explicit rails for automation/agents in this repo.  
> Scope: allow POM edits, keep old configs via additional profiles (do not remove), default to no tests, and fix build/runtime errors immediately.

---

## 0) response with Chinese
  pls thinking or response  and all docs  always with Chinese , althought i often use english&pinyin even pali together to ask ,input. 

  

## 1) Purpose
Give agents a minimal, unambiguous operating guide: where files go, how to build/run, when to sync docs, how/when to modify the POM, and how to respond to errors.

---

## 2) Scope & Boundaries
- ✅ **Allowed**: add/modify code, tests, scripts, docs; **modify `pom.xml`** (create/adjust profiles as needed,or create new pom-xxx.xml).
- ✅ **Preserve**: keep existing profiles/configs; **do not delete** legacy settings—add new profiles or comment with rationale.
- ✅ **Error handling**: on compile/run failures, **fix immediately** to a buildable/runnable state—no waiting.
- ⛔ **Git**: agents **only** `git add/commit`. All `pull/push/merge/rebase/tag` are manual/external.
- ⛔ No external toolchains beyond Maven/JDK mentioned here (no Make, static analysis, coverage, OpenRewrite, OWASP).

---

## 3) Layout (Single Module)
```

pom.xml
src/
main/
java/
resources/
test/
java/
docs/
scripts/
README.md
CHANGELOG.md

````

---

## 4) Build & Run (JDK 17 • Maven 3.x)
- **Default (skip tests)**  
  Build: `mvn -DskipTests clean package`  
  Run (example): `java -jar target/<app>.jar`

- **Enable tests on demand**  
  Use `mvn test` or activate a testing profile (see §5).

---

## 5) Tests (Optional • JUnit 5)
- Framework: **JUnit 5** (`junit-jupiter`).
- Only run tests when explicitly requested: `mvn test` or `mvn -DskipTests=false verify`.
- Test placement mirrors source; name classes `*Test.java`.

---

## 6) POM Editing Rules
- Agents may change `pom.xml` **as needed** to restore build/run or implement a requested feature.
- **Do not remove** existing profiles/legacy settings. If replacement is required, **add a new profile** or **comment old lines with reasons**.
- If plugin/dep conflicts or outdated versions break the build, **adjust to a working version immediately** and add a `fix:` entry to `CHANGELOG.md`.

**Profile Template (example, adapt as needed):**
```xml
<profiles>
  <profile>
    <id>default-run</id>
    <properties>
      <maven.compiler.release>17</maven.compiler.release>
    </properties>
  </profile>

  <profile>
    <id>tests-on</id>
    <properties>
      <maven.test.skip>false</maven.test.skip>
    </properties>
  </profile>

  <profile>
    <id>legacy-keep</id>
    <!-- Keep historical config here as comments or inactive props for reference.
         Do NOT delete legacy settings; do NOT auto-activate this profile. -->
    <!-- <maven.compiler.source>1.8</maven.compiler.source> -->
    <!-- <maven.compiler.target>1.8</maven.compiler.target> -->
  </profile>
</profiles>
````

---

## 7) Docs Sync (README / CHANGELOG are mandatory)

* Repo **must contain** `README.md` and `CHANGELOG.md`.
* Agents **must sync docs** when any of the following occurs:

  1. A **major feature** is completed/merged.
  2. Any user-visible change to build/run/config/dependencies.
  3. A **fix** that affects build/startup behavior.
* **Minimum content**:

  * `README.md`: project intro, required JDK/Maven, build/run commands, config example.
  * `CHANGELOG.md`: brief Conventional-Commit-style entries (`feat:`, `fix:`, `docs:`). No heavy formatting required.

---

## 8) Failure & Immediate Repair (“Just do it”)

* If any of the following is true, **repair and commit immediately**:

  * `mvn -DskipTests clean package` fails.
  * Runtime command errors (missing deps/plugins/entrypoint).
* Use **Conventional Commits** for messages, e.g.
  `fix(build): align surefire plugin for JDK17`
* When repairs override legacy behavior, add a one-line rationale in `CHANGELOG.md`.

---

## 9) Daily Commands (keep it this simple)

* **Fast build (no tests)**: `mvn -DskipTests clean package`
* **With tests**: `mvn -Ptests-on clean verify`

---

## 10) Risks (Minimal reminders)

* Allowing agents to edit the POM can shift dependency semantics; **first ensure build/run**, then minimize blast radius.
* Keeping legacy profiles increases complexity; choose clear names and avoid auto-activations to prevent config mixing.
* Failing to sync docs = future confusion. Update `README/CHANGELOG` right after major/visible changes.



## 11) response with Chinese
  pls thinking or response  always with Chinese , althought i often use english&pinyin even pali together to ask ,input. 