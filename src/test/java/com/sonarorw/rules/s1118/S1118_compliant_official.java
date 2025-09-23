package com.sonarorw.rules.s1118;

public class S1118_compliant_official {
    private S1118_compliant_official() {
        throw new IllegalStateException("No instances");
    }

    public static void helper() {
        System.out.println("utility");
    }
}

class S1118_exception_main {
    public static void main(String[] args) {
        helper();
    }

    static void helper() {
        System.out.println("entry point");
    }
}
