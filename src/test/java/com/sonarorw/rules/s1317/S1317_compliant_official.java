package com.sonarorw.rules.s1317;

/*
Sonar rule S1317 官方修复：使用字符串或空构造器再 append。
*/
class S1317_compliant_official {
    String build() {
        return new StringBuilder("a").append('b').toString();
    }
}