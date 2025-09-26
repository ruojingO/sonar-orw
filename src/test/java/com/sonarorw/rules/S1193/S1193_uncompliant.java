package com.sonarorw.rules.S1193;

class S1193_uncompliant {
    void handle() {
        try {
            throw new IllegalStateException("fail");
        } catch (IllegalStateException ex) {
            throw ex;
        }
    }
}
