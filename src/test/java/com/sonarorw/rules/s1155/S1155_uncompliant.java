package com.sonarorw.rules.s1155;

import java.util.ArrayList;
import java.util.List;

class S1155_uncompliant {
    boolean hasItems(List<String> values) {
        return values.size() > 0;
    }

    int countPositive(List<Integer> values) {
        int count = 0;
        if (values != null && values.size() == 0) {
            return count;
        }
        for (Integer value : values) {
            if (value > 0) {
                count++;
            }
        }
        return count;
    }
}
