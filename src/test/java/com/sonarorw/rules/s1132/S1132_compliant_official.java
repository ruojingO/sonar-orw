package com.sonarorw.rules.s1132;

/*
Sonar rule S1132 官方修复：应使用常量在左侧如 "foo".equals(value)。
*/
class S1132_compliant_official {
    boolean isFoo(String text) {
        return "foo".equals(text);
    }
}