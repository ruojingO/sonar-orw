package com.sonarorw.rules.s128;

/*
Sonar rule S128 official compliant snippet (https://rules.sonarsource.com/java/RSPEC-128/):
switch (myVariable) {
  case 1:
    foo();
    break;
  case 2:
    doSomething();
    break;
  default:
    doSomethingElse();
    break;
}
*/
class S128_compliant_official {
    void demoSwitch(int myVariable) {
        switch (myVariable) {
            case 1:
                foo();
                break;
            case 2:
                doSomething();
                break;
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
