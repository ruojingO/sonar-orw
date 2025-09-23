package com.sonarorw.rules.s121;

class S121_exceptions {
    boolean containsZero(int[] values) {
        for (int value : values)
            if (value == 0) return true; // single-return on same line is allowed
        return false;
    }

    void skipNegative(int[] values) {
        for (int value : values)
            if (value < 0) continue; // allowed by exception note
    }
}

