package com.sonarorw.rules.s1132;

/*
Sonar rule S1132 官方不合规示例：value.equals("foo") 可能导致 NullPointerException。
*/
class S1132_uncompliant {
    boolean isFoo(String text) {
        return text.equals("foo");
    }
}