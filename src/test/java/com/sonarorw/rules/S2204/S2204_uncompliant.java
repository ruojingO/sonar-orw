package com.sonarorw.rules.S2204;

import java.util.concurrent.atomic.AtomicBoolean;

class S2204_uncompliant {
    boolean isTrue(AtomicBoolean flag) {
        return flag.equals(true);
    }
}
