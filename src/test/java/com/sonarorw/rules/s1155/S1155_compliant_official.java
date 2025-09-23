package com.sonarorw.rules.s1155;

import java.util.List;

class S1155_compliant_official {
    boolean hasItems(List<String> values) {
        return !values.isEmpty();
    }

    int countPositive(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (Integer value : values) {
            if (value > 0) {
                count++;
            }
        }
        return count;
    }
}
