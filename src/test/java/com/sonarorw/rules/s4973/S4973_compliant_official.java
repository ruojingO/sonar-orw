package com.sonarorw.rules.s4973;

/*
Sonar rule S4973 官方修复：使用 equals 比较字面量。
*/
class S4973_compliant_official {
    boolean same(String input) {
        return "yes".equals(input);
    }
}