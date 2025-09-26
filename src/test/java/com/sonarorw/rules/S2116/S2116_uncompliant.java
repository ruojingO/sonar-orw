package com.sonarorw.rules.S2116;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class S2116_uncompliant {
    List<String> simplified() {
        return new ArrayList<>(Arrays.asList("a", "b"));
    }
}
