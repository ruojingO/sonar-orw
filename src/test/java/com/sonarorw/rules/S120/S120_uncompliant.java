package com.sonarorw.rules.S120;

/*
Sonar rule S120 官方示例：包名应保持全小写。
package com.Example.Utility; // 非法示例
*/
class S120_uncompliant {
    String sayHello() {
        return "hi";
    }
}