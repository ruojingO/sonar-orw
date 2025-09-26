package com.sonarorw.rules.s1301;

class S1301_compliant_official {
    enum Status { OPEN, CLOSED }

    int toValue(Status status) {
        if (status == Status.CLOSED) {
            return 0;
        }
        return -1;
    }
}
