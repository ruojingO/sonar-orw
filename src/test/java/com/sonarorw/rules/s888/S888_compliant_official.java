package com.sonarorw.rules.s888;

/*
Sonar rule S888 官方合规示例：
for (int i = 1; i <= 10; i += 2)  // Compliant
{
  //...
}
*/
class S888_compliant_official {
    int sumOdd() {
        int total = 0;
        for (int i = 1; i <= 10; i += 2) {
            total += i;
        }
        return total;
    }
}