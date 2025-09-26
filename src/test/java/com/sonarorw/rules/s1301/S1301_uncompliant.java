package com.sonarorw.rules.s1301;

/*
Sonar rule S1301 官方不合规示例：
switch (status) {           // Noncompliant
  case CLOSED:
    doSomething();
    break;
  default:
    handleDefault();
}
*/
class S1301_uncompliant {
    enum Status { OPEN, CLOSED }

    int toValue(Status status) {
        switch (status) {
            case CLOSED:
                return 0;
            default:
                return -1;
        }
    }
}
