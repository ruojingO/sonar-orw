package com.sonarorw.rules.s2737;

/*
Sonar rule S2737 官方不合规示例：
try {
  doSomething();
} catch (Exception e) {   // Noncompliant
  throw e;
}
*/
class S2737_uncompliant {
    void copy() throws Exception {
        try {
            doSomething();
        } catch (Exception exception) {
            throw exception;
        }
    }

    void doSomething() throws Exception {
        throw new Exception("boom");
    }
}
