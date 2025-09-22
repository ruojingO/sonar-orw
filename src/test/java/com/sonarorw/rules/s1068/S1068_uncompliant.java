package com.sonarorw.rules.s1068;

/*
Sonar rule S1068 官方片段 (https://rules.sonarsource.com/java/RSPEC-1068/):
public class MyClass {
  private int foo = 42; // Noncompliant: foo is unused and should be removed

  public int compute(int a) {
    return a * 42;
  }
}
*/
class S1068_uncompliant {
    private int foo = 42;

    int compute(int a) {
        return a * 42;
    }
}