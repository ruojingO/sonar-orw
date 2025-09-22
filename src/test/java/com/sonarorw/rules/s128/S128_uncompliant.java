package com.sonarorw.rules.s128;

/*
Sonar rule S128 official noncompliant snippet (https://rules.sonarsource.com/java/RSPEC-128/):
switch (myVariable) {
  case 1:
    foo();
    break;
  case 2:  // Both 'doSomething()' and 'doSomethingElse()' will be executed. Is it on purpose ?
    doSomething();
  default:
    doSomethingElse();
    break;
}
*/
class S128_uncompliant {
    void demoSwitch(int myVariable) {
        switch (myVariable) {
            case 1:
                foo();
                break;
            case 2:
                doSomething();
            default:
                doSomethingElse();
                break;
        }
    }

    void foo() {
        // placeholder for original foo()
    }

    void doSomething() {
        // placeholder for original doSomething()
    }

    void doSomethingElse() {
        // placeholder for original doSomethingElse()
    }
}