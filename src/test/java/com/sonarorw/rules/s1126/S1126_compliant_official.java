package com.sonarorw.rules.s1126;

/*
Sonar rule S1126 官方合规示例：
boolean foo(Object param) {
  bar(param, expression, "qix");
  return expression;
}
*/
class S1126_compliant_official {
    boolean expression;

    void bar(Object param, boolean flag, String text) {
        // placeholder
    }

    boolean foo(Object param) {
        bar(param, expression, "qix");
        return expression;
    }
}