package com.sonarorw.rules.S2037;

class S2037_uncompliant {
    String home() {
        return System.getenv("user.home");
    }
}
