package com.sonarorw.rules.s2959;

/*
Sonar rule S2959 官方不合规示例：
for (int i = 0; i < 10; i++);     // Noncompliant
  doSomething();
*/
class S2959_uncompliant {
    void printAll() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Item" + i);
            ;
        }
    }
}
