package com.sonarorw.rules.s1144;

/*
Sonar rule S1144 官方指导：删除未使用的 private 方法或改为被调用。
*/
class S1144_compliant_official {
    int compute(int a, int b) {
        return a + b;
    }
}