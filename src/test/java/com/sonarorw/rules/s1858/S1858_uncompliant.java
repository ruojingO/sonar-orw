package com.sonarorw.rules.s1858;

/*
Sonar rule S1858 官方不合规示例：
if (country.toString().equals("FR")) {  // Noncompliant
  // ...
}
*/
class S1858_uncompliant {
    boolean isFrance(String country) {
        return country.toString().equals("FR");
    }
}
