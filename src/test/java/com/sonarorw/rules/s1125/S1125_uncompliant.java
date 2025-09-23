package com.sonarorw.rules.s1125;

class S1125_uncompliant {
    boolean isEnabled(boolean flag) {
        if (flag == true) {
            return true;
        }
        return false;
    }

    boolean isDisabled(boolean flag) {
        if (flag == false) {
            return true;
        }
        return false;
    }
}
