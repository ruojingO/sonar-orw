package com.sonarorw.rules.s5411;

import java.util.ArrayList;
import java.util.List;

class S5411_exceptions {
    void iterate() {
        List<Boolean> values = new ArrayList<>();
        values.add(Boolean.TRUE);
        values.add(Boolean.FALSE);
        values.forEach((@NonNull Boolean value) -> {
            if (value) {
                System.out.println("yes");
            }
        });
    }

    @NonNull
    Boolean boxedSupplier() {
        return Boolean.TRUE;
    }

    void useSupplier() {
        if (boxedSupplier()) {
            System.out.println("guarded");
        }
    }

    @interface NonNull {}
}

