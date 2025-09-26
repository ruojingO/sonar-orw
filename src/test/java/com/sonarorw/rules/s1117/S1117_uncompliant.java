package com.sonarorw.rules.s1117;

/*
Sonar rule S1117 官方不合规示例：
class Foo {
  private int value;

  void setValue(int value) {   // Noncompliant
    value = value;
  }
}
*/
class S1117_uncompliant {
    private int value;

    void increment(int value) {
        value += 1;
    }

    int getValue() {
        return value;
    }
}
