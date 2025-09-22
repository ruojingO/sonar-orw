package com.sonarorw.rules.s1144;

/*
Sonar rule S1144 官方提示：未被调用的 private 方法应删除。
private class Example {
  private void unused() { // Noncompliant
    // ...
  }
}
*/
class S1144_uncompliant {
    private void unusedHelper() {
        System.out.println("unused");
    }

    int compute(int a, int b) {
        return a + b;
    }
}