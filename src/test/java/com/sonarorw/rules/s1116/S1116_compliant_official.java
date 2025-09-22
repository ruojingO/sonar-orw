package com.sonarorw.rules.s1116;

/*
Sonar rule S1116 官方修复：删除多余的分号。
*/
class S1116_compliant_official {
    void run() {
        int i = 0;
        if (i == 0) {
            System.out.println("no extra semicolon");
        }
    }
}