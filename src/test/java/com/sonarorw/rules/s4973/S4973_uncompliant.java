package com.sonarorw.rules.s4973;

/*
Sonar rule S4973 官方不合规示例：字面量和引用使用 == 比较。
*/
class S4973_uncompliant {
    boolean same(String input) {
        return input == "yes";
    }
}