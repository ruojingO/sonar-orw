package com.sonarorw.rules.s1612;

import java.util.Arrays;
import java.util.List;

class S1612_uncompliant {
    void printAll(List<String> values) {
        values.forEach(value -> System.out.println(value));
    }

    long countEmpty(List<String> values) {
        return values.stream().filter(s -> s.isEmpty()).count();
    }
}
