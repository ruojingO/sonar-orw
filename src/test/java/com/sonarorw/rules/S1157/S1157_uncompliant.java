package com.sonarorw.rules.S1157;

import java.util.Locale;

class S1157_uncompliant {
    boolean matches(String input) {
        return input.toLowerCase(Locale.ROOT).equals("admin");
    }
}
