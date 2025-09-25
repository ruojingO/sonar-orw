i hope u create a test maven project base jdk8 
to validate the openRewrite 's these recipes referenceed these sonar 's rule
their 's relationship, is recipe just fix the rule's report issue? part or all or only have relative 
i need u read realtime 's them 's official link content, and use their 's code example ,
firstly driven by sonar's rule uncompliant code example, then let the openrewrite 's recipe check ,is the recipe
can fix them ,all or part or can't fix ,  if can't just print a warning ,finally i need a complete report : sonarRule-openrewriterecipe - canFix? -memo

Notes: 请总是用中文markdown格式回复(虽然i often use english&pinyin even pali together )  

this is mapping 
| 您的规则                                                             | 可自动修复？   | 对应 OpenRewrite Recipe（FQN）                                                                                                             | 证据                           |
| ---------------------------------------------------------------- | -------- | -------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------- |
| **S2111** “`new BigDecimal(double)` 不应使用” | 是 | `org.openrewrite.staticanalysis.BigDecimalDoubleConstructorRecipe` (成功修复，将 `new BigDecimal(double)` 转换为 `BigDecimal.valueOf(double)`，符合 SonarQube 推荐的其中一种修复方式) | ([docs.openrewrite.org][1]) |
| **S3457** “Printf/`String.format` 用法正确 & 使用`%n`而非`\n`” | 是 | `org.openrewrite.staticanalysis.FixStringFormatExpressions` (成功修复 `\n` 到 `%n` 的问题); `org.openrewrite.staticanalysis.UsePortableNewlines` (未找到该配方) | ([docs.openrewrite.org][2]) |
| **S3986** “禁止使用 Week Year (`YYYY`) 进行日期格式化” | 是 | `org.openrewrite.staticanalysis.ReplaceWeekYearWithYear` (成功修复) | ([docs.openrewrite.org][3]) |
| **S128** “`switch` 分支应以无条件 `break` 结束（避免穿透）” | 是 | `org.openrewrite.staticanalysis.FallThrough` (成功修复) | ([docs.openrewrite.org][4]) |
| **S2692** “`indexOf` 判定不应使用 `> 0`；应使用 `contains`/正确比较” | 是 | `org.openrewrite.staticanalysis.IndexOfShouldNotCompareGreaterThanZero` (成功修复); `org.openrewrite.staticanalysis.IndexOfReplaceableByContains` (未应用，可能因为当前示例不适用) | ([docs.openrewrite.org][5]) |
| **S1481** “未使用的局部变量应删除” | 是 | `org.openrewrite.staticanalysis.RemoveUnusedLocalVariables` (成功修复) | ([docs.openrewrite.org][6]) |
| **S1068** “未使用的私有字段应删除” | 是 | `org.openrewrite.staticanalysis.RemoveUnusedPrivateFields` (成功修复) | ([docs.openrewrite.org][7]) |
| **S1144** “未使用的私有方法应删除” | 是 | `org.openrewrite.staticanalysis.RemoveUnusedPrivateMethods` (成功修复) | ([docs.openrewrite.org][8]) |
| **（Checkstyle 自定义）`packageNameMustLowercase`** ↔ **S120** “包名小写” | 是 | `org.openrewrite.staticanalysis.LowercasePackage` (成功修复) | ([docs.openrewrite.org][9]) |
| **S1317** “`StringBuilder`/`StringBuffer` 以 `char` 构造（误把容量当内容）” | 是 | `org.openrewrite.staticanalysis.NewStringBuilderBufferWithCharArgument` (成功修复) | ([docs.openrewrite.org][10]) |
| **S1132** “`equals` 应避免空指针（把字面量放左边）” | 是 | `org.openrewrite.staticanalysis.EqualsAvoidsNull` (成功修复) | ([docs.openrewrite.org][11]) |
| **S4973** “`String`/包装类型比较应使用 `equals`（字面量场景）” | 是 | `org.openrewrite.staticanalysis.StringLiteralEquality` (成功修复) | ([docs.openrewrite.org][12]) |
| **S3020** “`Collection.toArray()` 应传入正确类型数组” | 是 | `org.openrewrite.staticanalysis.CollectionToArrayShouldHaveProperType` (未应用，因为示例代码已符合最佳实践) | ([docs.openrewrite.org][13]) |
| **S2057** “`Serializable` 缺少 `serialVersionUID`” | 是 | `org.openrewrite.staticanalysis.AddSerialVersionUidToSerializable` (成功修复) | ([docs.openrewrite.org][14]) |
| **S1161** “缺失 `@Override`” | 是 | `org.openrewrite.staticanalysis.MissingOverrideAnnotation` (成功修复) | ([docs.openrewrite.org][15]) |
| **S1116 / S2959** “多余分号” | 是 | `org.openrewrite.staticanalysis.RemoveExtraSemicolons` (成功修复) | ([docs.openrewrite.org][16]) |
| **S888** “`for` 的循环条件应使用比较而非相等/不等” | 是 | `org.openrewrite.staticanalysis.NoEqualityInForCondition` (成功修复) | ([docs.openrewrite.org][17]) |
| **S5411** “避免装箱 `Boolean` 直接作为条件表达式” | 是 | `org.openrewrite.staticanalysis.AvoidBoxedBooleanExpressions` (成功修复) | ([docs.openrewrite.org][18]) |
| **S1126** “布尔返回不应包一层 `if-else`” | 是 | `org.openrewrite.staticanalysis.SimplifyBooleanReturn` (未应用，可能因为示例代码模式不完全匹配或需要更复杂的分析) | ([docs.openrewrite.org][19]) |
| **S2293** “应使用 diamond `<>` 操作符” | 是 | `org.openrewrite.staticanalysis.UseDiamondOperator` (成功修复) | ([docs.openrewrite.org][20]) |
| **S2112** “`java.net.URL` 的 `equals/hashCode` 可能阻塞，改用 `URI`” | 是 | `org.openrewrite.staticanalysis.URLEqualsHashCodeRecipes` (成功修复) | ([docs.openrewrite.org][21]) |
| **S2162** “协变 `equals` 必须同时覆写 `equals(Object)`” | 是 | `org.openrewrite.staticanalysis.CovariantEquals` (未应用，可能因为示例代码模式不完全匹配或该配方主要用于检测) | ([docs.openrewrite.org][22]) |
| **S106（标准输出直打日志）**                                               | 是（等价修复）  | ① 移除打印：`org.openrewrite.staticanalysis.RemoveSystemOutPrintln`；② 或替换为日志：`org.openrewrite.java.logging.SystemOutToLogging`              | ([docs.openrewrite.org][23]) |
| **S4042**（优先 `Files.delete`）等 Java API 最佳实践 | 常见可自动修复项 | 多数在 “Common static analysis issues / Java API best practices” 目录下（例如 `Use Collection#isEmpty()` (未应用，可能因为兼容性问题)、`Change StringBuilder/Buffer(char)` 等） | ([docs.openrewrite.org][24]) |

[1]: https://docs.openrewrite.org/recipes/staticanalysis/bigdecimalroundingconstantstoenums?utm_source=chatgpt.com "BigDecimal rounding constants to RoundingMode enums"
[2]: https://docs.openrewrite.org/recipes/staticanalysis/fixstringformatexpressions?utm_source=chatgpt.com "Fix String#format and String#formatted expressions"
[3]: https://docs.openrewrite.org/recipes/staticanalysis/replaceweekyearwithyear?utm_source=chatgpt.com "Week Year (YYYY) should not be used for date formatting"
[4]: https://docs.openrewrite.org/recipes/staticanalysis/fallthrough?utm_source=chatgpt.com "Fall through | OpenRewrite Docs"
[5]: https://docs.openrewrite.org/recipes/staticanalysis/indexofreplaceablebycontains?utm_source=chatgpt.com "indexOf() replaceable by contains()"
[6]: https://docs.openrewrite.org/recipes/staticanalysis/removeunusedlocalvariables?utm_source=chatgpt.com "Remove unused local variables | OpenRewrite Docs"
[7]: https://docs.openrewrite.org/recipes/staticanalysis/removeunusedprivatefields?utm_source=chatgpt.com "Remove unused private fields"
[8]: https://docs.openrewrite.org/recipes/staticanalysis/removeunusedprivatemethods?utm_source=chatgpt.com "Remove unused private methods"
[9]: https://docs.openrewrite.org/recipes/staticanalysis/lowercasepackage?utm_source=chatgpt.com "Rename packages to lowercase"
[10]: https://docs.openrewrite.org/recipes/staticanalysis/newstringbuilderbufferwithcharargument?utm_source=chatgpt.com "Change StringBuilder and StringBuffer character ..."
[11]: https://docs.openrewrite.org/recipes/staticanalysis/equalsavoidsnull?utm_source=chatgpt.com "Equals avoids null | OpenRewrite Docs"
[12]: https://docs.openrewrite.org/recipes/staticanalysis/stringliteralequality?utm_source=chatgpt.com "Use String.equals() on String literals"
[13]: https://docs.openrewrite.org/recipes/staticanalysis/collectiontoarrayshouldhavepropertype?utm_source=chatgpt.com "'Collection.toArray()' should be passed an array of the proper type"
[14]: https://docs.openrewrite.org/recipes/staticanalysis/addserialversionuidtoserializable?utm_source=chatgpt.com "Add serialVersionUID to a Serializable class when missing"
[15]: https://docs.openrewrite.org/recipes/staticanalysis/missingoverrideannotation?utm_source=chatgpt.com "Add missing @Override to overriding and implementing ..."
[16]: https://docs.openrewrite.org/recipes/staticanalysis/removeextrasemicolons?utm_source=chatgpt.com "Remove extra semicolons"
[17]: https://docs.openrewrite.org/recipes/staticanalysis/noequalityinforcondition?utm_source=chatgpt.com "Use comparison rather than equality checks in for conditions"
[18]: https://docs.openrewrite.org/recipes/staticanalysis/avoidboxedbooleanexpressions?utm_source=chatgpt.com "Avoid boxed boolean expressions"
[19]: https://docs.openrewrite.org/recipes/staticanalysis/simplifybooleanreturn?utm_source=chatgpt.com "Simplify boolean return"
[20]: https://docs.openrewrite.org/recipes/staticanalysis/usediamondoperator?utm_source=chatgpt.com "Use the diamond operator"
[21]: https://docs.openrewrite.org/recipes/staticanalysis/urlequalshashcoderecipes?utm_source=chatgpt.com "URL Equals and Hash Code"
[22]: https://docs.openrewrite.org/recipes/staticanalysis/covariantequals?utm_source=chatgpt.com "Covariant equals | OpenRewrite Docs"
[23]: https://docs.openrewrite.org/recipes/staticanalysis?utm_source=chatgpt.com "Static analysis and remediation | OpenRewrite Docs"
[24]: https://docs.openrewrite.org/recipes/staticanalysis/commonstaticanalysis?utm_source=chatgpt.com "Common static analysis issues"
