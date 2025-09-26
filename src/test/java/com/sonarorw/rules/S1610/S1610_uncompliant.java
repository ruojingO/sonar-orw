package com.sonarorw.rules.S1610;

import java.util.function.Function;

class S1610_uncompliant {
    Function<String, Integer> converter = s -> {
        return Integer.parseInt(s);
    };
}
