package com.sonarorw.rules.s2057;

import java.io.Serializable;

/*
Sonar rule S2057 官方修复：显式声明 serialVersionUID。
*/
class S2057_compliant_official implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    S2057_compliant_official(String name) {
        this.name = name;
    }
}