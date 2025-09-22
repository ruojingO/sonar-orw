package com.sonarorw.rules.s1116;

/*
Sonar rule S1116 官方不合规示例：存在多余的分号。
*/
class S1116_uncompliant {
    void run() {
        int i = 0;;
        if (i == 0);
        {
            System.out.println("extra semicolon");
        }
    }
}