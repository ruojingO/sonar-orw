package com.sonarorw.rules.s2057;

import java.io.Serializable;

/*
Sonar rule S2057 官方不合规示例：可序列化类缺少 serialVersionUID。
*/
class S2057_uncompliant implements Serializable {
    private String name;

    S2057_uncompliant(String name) {
        this.name = name;
    }
}