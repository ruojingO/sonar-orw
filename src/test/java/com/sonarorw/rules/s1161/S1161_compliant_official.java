package com.sonarorw.rules.s1161;

/*
Sonar rule S1161 官方修复：重写方法添加 @Override。
*/
class S1161_compliant_official {
    class Base {
        String greet() {
            return "hi";
        }
    }

    class Child extends Base {
        @Override
        String greet() {
            return "hello";
        }
    }
}