package com.sonarorw.rules.s1161;

/*
Sonar rule S1161 官方不合规示例：重写方法缺少 @Override。
*/
class S1161_uncompliant {
    class Base {
        String greet() {
            return "hi";
        }
    }

    class Child extends Base {
        String greet() {
            return "hello";
        }
    }
}