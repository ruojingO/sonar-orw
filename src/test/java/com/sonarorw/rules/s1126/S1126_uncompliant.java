package com.sonarorw.rules.s1126;

/*
Sonar rule S1126 官方不合规示例：
boolean foo(Object param) {
  if (expression) { // Noncompliant
    bar(param, true, "qix");
  } else {
    bar(param, false, "qix");
  }

  if (expression) {
    return true;
  } else {
    return false;
  }
}
*/
class S1126_uncompliant {
    boolean expression;

    void bar(Object param, boolean flag, String text) {
        // placeholder
    }

    boolean foo(Object param) {
        if (expression) {
            bar(param, true, "qix");
        } else {
            bar(param, false, "qix");
        }

        if (expression) {
            return true;
        } else {
            return false;
        }
    }
}