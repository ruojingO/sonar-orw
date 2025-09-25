| Rule | Recipe | Can Fix | Memo | Exception Guard | Exception Memo |
| --- | --- | --- | --- | --- | --- |
| S2111 | org.openrewrite.staticanalysis.BigDecimalDoubleConstructorRecipe | YES | 自动将 `new BigDecimal(double)` 替换为 `BigDecimal.valueOf(double)`；已改写官方示例说明以 ASCII 保持描述 | PASS | 官方未提供例外段落，免守护 |
| S3457 | org.openrewrite.staticanalysis.FixStringFormatExpressions + UsePortableNewlines | PARTIAL | 移除多余实参但未替换 `{0}` 样式占位符，需人工补充；详见 S3457-diff.md | PASS | 官方未提供例外段落，免守护 |
| S3986 | org.openrewrite.staticanalysis.ReplaceWeekYearWithYear | YES | `YYYY` 模式全部替换为 `yyyy`，详见 S3986-diff.md | PASS | 保留周基日期格式（YYYY-ww）例外，守护通过 |
| S128 | org.openrewrite.staticanalysis.FallThrough | YES | 自动补齐 case 2 的 `break`，详见 S128-diff.md | PASS | 允许空 case、fallthrough 注释、return/throw/continue；例外样例守护通过 |
| S2692 | org.openrewrite.staticanalysis.IndexOfShouldNotCompareGreaterThanZero + IndexOfReplaceableByContains | PARTIAL | 将 `> 0` 改为 `>= 1`，但未自动改用 `contains`，详见 S2692-diff.md | PASS | 官方未提供例外段落，免守护 |
| S1481 | org.openrewrite.staticanalysis.RemoveUnusedLocalVariables | YES | 删除未使用的局部变量 `seconds`，详见 S1481-diff.md | PASS | 官方未提供例外段落，免守护 |
| S1068 | org.openrewrite.staticanalysis.RemoveUnusedPrivateFields | YES | 删除未使用的私有字段 `foo`，详见 S1068-diff.md | PASS | 已解析官方例外（serialVersionUID、注解字段、native 场景），_exceptions.java 守护通过 |
| S1144 | org.openrewrite.staticanalysis.RemoveUnusedPrivateMethods | YES | 移除了未使用的 private 方法，详见 S1144-diff.md | PASS | 已覆盖注解方法与 @Observes 参数等例外，守护校验未改动 |
| S120 | org.openrewrite.staticanalysis.LowercasePackage | YES | 将包名从 `com.sonarorw.rules.S120` 改为全小写，详见 S120-diff.md | PASS | 官方未提供例外段落，免守护 |
| S1317 | org.openrewrite.staticanalysis.NewStringBuilderBufferWithCharArgument | YES | 将 `new StringBuilder('a')` 改为字符串构造，详见 S1317-diff.md | PASS | 官方未提供例外段落，免守护 |
| S1132 | org.openrewrite.staticanalysis.EqualsAvoidsNull | YES | 调整为 ``"foo".equals(value)`` 模式，详见 S1132-diff.md | PASS | 官方未提供例外段落，免守护 |
| S4973 | org.openrewrite.staticanalysis.StringLiteralEquality | YES | 将字面量比较从 `==` 改为 `equals`，详见 S4973-diff.md | PASS | 官方未提供例外段落，免守护 |
| S3020 | org.openrewrite.staticanalysis.CollectionToArrayShouldHaveProperType | YES | 自动改为传入正确类型数组，详见 S3020-diff.md | PASS | 官方未提供例外段落，免守护 |
| S2057 | org.openrewrite.staticanalysis.AddSerialVersionUidToSerializable | YES | 自动补充 `serialVersionUID` 字段，详见 S2057-diff.md | PASS | 记录类、Swing/AWT、Throwable、@SuppressWarnings("serial") 例外，守护通过 |
| S1161 | org.openrewrite.staticanalysis.MissingOverrideAnnotation | YES | 自动为重写方法添加 `@Override`，详见 S1161-diff.md | PASS | 仅针对 Object 方法例外，示例守护通过 |
| S1116 | org.openrewrite.staticanalysis.RemoveExtraSemicolons | YES | 移除了多余的分号与空语句，详见 S1116-diff.md | PASS | 官方未提供例外段落，免守护 |
| S5411 | org.openrewrite.staticanalysis.AvoidBoxedBooleanExpressions | YES | 将 `if (Boolean)` 改为显式 `Boolean.TRUE.equals(...)` 检查，详见 S5411-diff.md | PASS | NonNull 注解场景守护通过 |
| S1126 | org.openrewrite.staticanalysis.SimplifyBooleanReturn | YES | 合并 `if-else` 布尔返回为表达式，详见 S1126-diff.md | PASS | 官方未提供例外段落，免守护 |
| S2293 | org.openrewrite.staticanalysis.UseDiamondOperator | YES | 自动应用菱形操作符，详见 S2293-diff.md | PASS | 官方未提供例外段落，免守护 |
| S2112 | org.openrewrite.staticanalysis.URLEqualsHashCodeRecipes | YES | 改用 `URI` 参与集合/比较，详见 S2112-diff.md | PASS | 官方未提供例外段落，免守护 |
| S2162 | org.openrewrite.staticanalysis.CovariantEquals | NO | 配方未对示例进行改动，需手动验证 equals 实现；本次运行无 diff | PASS | 官方未提供例外段落，免守护 |
| S888 | org.openrewrite.staticanalysis.NoEqualityInForCondition | NO | `i != limit` 模式未被改写，需补充手工调整；无生成 diff | PASS | null 哨兵循环例外守护通过 |
| S106 | org.openrewrite.staticanalysis.RemoveSystemOutPrintln | YES | 移除 `System.out.println` 调用，详见 S106-diff.md | PASS | 官方未提供例外段落，免守护 |
| S1118 | org.openrewrite.staticanalysis.HideUtilityClassConstructor | YES | 隐藏工具类构造器，参考 RSPEC-1118 官方示例 | PASS | main 方法的工具类例外守护通过（rewrite 未改动 _exceptions） |
| S121 | org.openrewrite.staticanalysis.NeedBraces | YES | 控制语句补齐花括号 | WARN | NeedBraces 会改写 _exceptions，dry-run 持续新增花括号 |
| S1155 | org.openrewrite.staticanalysis.IsEmptyCallOnCollections | YES | 使用 isEmpty() 判空 | PASS | 无例外说明，dry-run 仅修改 uncompliant 样例 |
| S1612 | org.openrewrite.staticanalysis.ReplaceLambdaWithMethodReference | YES | Lambda 替换为方法引用 | PASS | 无例外说明，dry-run 仅修改 uncompliant 样例 |
| S1125 | org.openrewrite.staticanalysis.SimplifyBooleanExpression | YES | 布尔字面量直接返回 | PASS | 无例外说明，dry-run 仅修改 uncompliant 样例 |
