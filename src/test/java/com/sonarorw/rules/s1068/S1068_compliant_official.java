package com.sonarorw.rules.s1068;

/*
Sonar rule S1068 官方修复：移除未使用的私有字段或改为实际使用。
*/
class S1068_compliant_official {
    int compute(int a) {
        return a * 42;
    }
}