package com.sonarorw.rules.s1612;

import java.util.List;

class S1612_compliant_official {
    void printAll(List<String> values) {
        values.forEach(System.out::println);
    }

    long countEmpty(List<String> values) {
        return values.stream().filter(String::isEmpty).count();
    }
}
