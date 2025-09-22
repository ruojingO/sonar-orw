package com.sonarorw.rules.s5411;

/*
Sonar rule S5411 官方不合规示例 (https://rules.sonarsource.com/java/RSPEC-5411/):
Boolean b = getBoolean();
if (b) {  // Noncompliant, it will throw NPE when b == null
  foo();
} else {
  bar();
}
*/
class S5411_uncompliant {
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
        if (b) {
            return foo();
        } else {
            return bar();
        }
    }
}