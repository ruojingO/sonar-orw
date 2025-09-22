package com.sonarorw.rules.s888;

/*
Sonar rule S888 官方不合规示例 (https://rules.sonarsource.com/java/RSPEC-888/):
for (int i = 1; i != 10; i += 2)  // Noncompliant. Infinite; i goes from 9 straight to 11.
{
  //...
}
*/
class S888_uncompliant {
    int sumOdd() {
        int total = 0;
        for (int i = 1; i != 10; i += 2) {
            total += i;
        }
        return total;
    }
}