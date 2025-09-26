package com.sonarorw.rules.S1217;

class S1217_uncompliant {
    void startThread() {
        Runnable task = () -> System.out.println("run");
        new Thread(task).run();
    }
}
