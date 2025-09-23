package com.sonarorw.rules.s128;

class S128_exceptions {
    String aggregate(int flag) {
        switch (flag) {
            case 0:
            case 1:
                doSomething();
                break; // normal break
            case 2:
                // fallthrough
            case 3:
                return "handled";
            case 4:
                throw new IllegalStateException("delegate");
            case 5:
                for (int i = 0; i < 3; i++) {
                    switch (i) {
                        case 0:
                            // fallthrough group for looped switch
                        case 1:
                            continue; // allowed continue sample
                        default:
                            break;
                    }
                }
                break;
            default:
                doSomethingElse(); // default may omit break
        }
        return "done";
    }

    private void doSomething() {}

    private void doSomethingElse() {}
}

