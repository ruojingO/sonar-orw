package com.sonarorw.rules.S1217;

/**
 * Compliant solution for S1217
 */
public class S1217_compliant_official {
    public void compliantMethod() {
        Thread t = new Thread(() -> { /* do something */ });
        // Compliant: .start() is called to begin execution in a new thread.
        t.start();
    }
}
