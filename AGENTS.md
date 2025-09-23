# Repository Guidelines

Use this guide to keep contributions aligned while the codebase is being assembled.

## Project Structure & Module Organization
Organize application code under `src/`, grouped by domain modules, with shared helpers in `src/common/`.
Mirror that layout in `tests/` so every module ships with unit and integration coverage.
Keep environment definitions or IaC artifacts in `infra/`, documentation drafts in `docs/`, and sample datasets or fixtures in `assets/seed/`.
Add a `scripts/` folder for repeatable CLI utilities. A healthy tree should resemble:

~~~
src/
  ingest/
  analytics/
  common/
tests/
  ingest/
  analytics/
docs/
infra/
assets/seed/
scripts/
~~~

## Build, Test, and Development Commands
Centralize workflows in a root `Makefile`; create it if it is missing.
Maintain these targets:
- `make setup`: create a virtualenv, install dependencies, and install `pre-commit` hooks.
- `make lint`: run `ruff check .` then `black --check src tests`.
- `make test`: execute `pytest --maxfail=1 --disable-warnings`.
- `make serve`: start the local API once defined (`uvicorn src.app:app --reload`).
Document any new command in the Makefile `help` target.

## Coding Style & Naming Conventions
Target Python 3.11+, 4-space indentation, and UTF-8 text.
Modules stay in `snake_case.py`, classes use `PascalCase`, functions and variables use `snake_case`, and CLI entry points prefer `kebab-case`.
Keep imports sorted with `ruff --select I`.
YAML, JSON, and TOML configs use 2-space indents.
Run `pre-commit run --all-files` before pushing to catch lint or formatting drift.

## Testing Guidelines
Write tests with `pytest` and mirror package names under `tests/`.
Prefix files with `test_` and mark long-running suites with `@pytest.mark.slow`.
Aim for >=90% line coverage via `pytest --cov=src --cov-report=term`.
Store shared fixtures in `tests/fixtures` and keep sample assets in `assets/seed/` to maintain deterministic runs.

## Commit & Pull Request Guidelines
Use Conventional Commit prefixes (`feat`, `fix`, `docs`, `chore`, `refactor`, `test`, `ci`).
Keep the subject <=72 characters and expand on multi-part changes in the body.
Each pull request should link an issue or ticket, list validation steps, and supply evidence (logs, screenshots) for user-facing changes.
Keep scope focused; open a draft PR when coordinating migrations or infra updates.

## Security & Configuration Tips
Never commit secrets; keep local values in `.env` and document required keys in `.env.example`.
Review dependency updates with `make lint` and `pip-audit` (expose as `make audit`) before merging.
Store deployment credentials in the CI vault and rotate them whenever integration tests touch external systems.
