package com.sonarorw.rules.s1317;

/*
Sonar rule S1317 官方不合规示例：new StringBuilder('a') 错误地把容量当内容。
*/
class S1317_uncompliant {
    String build() {
        return new StringBuilder('a').append('b').toString();
    }
}