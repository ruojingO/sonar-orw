package com.sonarorw.rules.s2737;

class S2737_compliant_official {
    void copy() throws Exception {
        doSomething();
    }

    void doSomething() throws Exception {
        throw new Exception("boom");
    }
}
