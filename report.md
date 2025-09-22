| Rule | Recipe | Can Fix | Memo |
| S2111 | org.openrewrite.staticanalysis.BigDecimalDoubleConstructorRecipe | YES | 自动将 `new BigDecimal(double)` 替换为 `BigDecimal.valueOf(double)`；已改写官方示例说明以 ASCII 保持描述 |
| S3457 | org.openrewrite.staticanalysis.FixStringFormatExpressions + UsePortableNewlines | PARTIAL | 移除多余实参但未替换 `{0}` 样式占位符，需人工补充；详见 S3457-diff.md |
| S3986 | org.openrewrite.staticanalysis.ReplaceWeekYearWithYear | YES | `YYYY` 模式全部替换为 `yyyy`，详见 S3986-diff.md |
| S128 | org.openrewrite.staticanalysis.FallThrough | YES | 自动补齐 case 2 的 `break`，详见 S128-diff.md |
| S2692 | org.openrewrite.staticanalysis.IndexOfShouldNotCompareGreaterThanZero + IndexOfReplaceableByContains | PARTIAL | 将 `> 0` 改为 `>= 1`，但未自动改用 `contains`，详见 S2692-diff.md |
| S1481 | org.openrewrite.staticanalysis.RemoveUnusedLocalVariables | YES | 删除未使用的局部变量 `seconds`，详见 S1481-diff.md |
| S1068 | org.openrewrite.staticanalysis.RemoveUnusedPrivateFields | YES | 删除未使用的私有字段 `foo`，详见 S1068-diff.md |
| S1144 | org.openrewrite.staticanalysis.RemoveUnusedPrivateMethods | YES | 移除了未使用的 private 方法，详见 S1144-diff.md |
| S120 | org.openrewrite.staticanalysis.LowercasePackage | YES | 将包名从 `com.sonarorw.rules.S120` 改为全小写，详见 S120-diff.md |
| S1317 | org.openrewrite.staticanalysis.NewStringBuilderBufferWithCharArgument | YES | 将 `new StringBuilder('a')` 改为字符串构造，详见 S1317-diff.md |
| S1132 | org.openrewrite.staticanalysis.EqualsAvoidsNull | YES | 调整为 ``"foo".equals(value)`` 模式，详见 S1132-diff.md |
| S4973 | org.openrewrite.staticanalysis.StringLiteralEquality | YES | 将字面量比较从 `==` 改为 `equals`，详见 S4973-diff.md |
| S3020 | org.openrewrite.staticanalysis.CollectionToArrayShouldHaveProperType | YES | 自动改为传入正确类型数组，详见 S3020-diff.md |
| S2057 | org.openrewrite.staticanalysis.AddSerialVersionUidToSerializable | YES | 自动补充 `serialVersionUID` 字段，详见 S2057-diff.md |
| S1161 | org.openrewrite.staticanalysis.MissingOverrideAnnotation | YES | 自动为重写方法添加 `@Override`，详见 S1161-diff.md |
| S1116 | org.openrewrite.staticanalysis.RemoveExtraSemicolons | YES | 移除了多余的分号与空语句，详见 S1116-diff.md |
| S5411 | org.openrewrite.staticanalysis.AvoidBoxedBooleanExpressions | YES | 将 `if (Boolean)` 改为显式 `Boolean.TRUE.equals(...)` 检查，详见 S5411-diff.md |
| S1126 | org.openrewrite.staticanalysis.SimplifyBooleanReturn | YES | 合并 `if-else` 布尔返回为表达式，详见 S1126-diff.md |
| S2293 | org.openrewrite.staticanalysis.UseDiamondOperator | YES | 自动应用菱形操作符，详见 S2293-diff.md |
| S2112 | org.openrewrite.staticanalysis.URLEqualsHashCodeRecipes | YES | 改用 `URI` 参与集合/比较，详见 S2112-diff.md |
| S2162 | org.openrewrite.staticanalysis.CovariantEquals | NO | 配方未对示例进行改动，需手动验证 equals 实现；本次运行无 diff |
| S888 | org.openrewrite.staticanalysis.NoEqualityInForCondition | NO | `i != limit` 模式未被改写，需补充手工调整；无生成 diff |
| S106 | org.openrewrite.staticanalysis.RemoveSystemOutPrintln | YES | 移除 `System.out.println` 调用，详见 S106-diff.md |
