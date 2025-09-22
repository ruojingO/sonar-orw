package com.sonarorw.rules.s5411;

/*
Sonar rule S5411 官方合规示例：
Boolean b = getBoolean();
if (Boolean.TRUE.equals(b)) {
  foo();
} else {
  bar();  // will be invoked for both b == false and b == null
}
*/
class S5411_compliant_official {
    Boolean getBoolean() {
        return null;
    }

    String foo() {
        return "foo";
    }

    String bar() {
        return "bar";
    }

    String pick() {
        Boolean b = getBoolean();
        if (Boolean.TRUE.equals(b)) {
            return foo();
        }
        return bar();
    }
}