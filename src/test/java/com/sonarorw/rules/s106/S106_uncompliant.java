package com.sonarorw.rules.s106;

/*
Sonar rule S106 官方不合规示例：直接使用 System.out。
*/
class S106_uncompliant {
    void doSomething() {
        System.out.println("My Message");
    }
}