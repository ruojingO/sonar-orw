package com.sonarorw.rules.s1144;

import java.lang.reflect.Method;

class S1144_exceptions {
    @Qualifier
    private void annotatedHelper() {
        // compliant: annotated private method
    }

    private void handle(@javax.enterprise.event.Observes String event) {
        // compliant: observes parameter qualifies as an exception
    }

    @Qualifier
    private void invokedReflectively() {
        // still counted because reflection is not analysed; keep sample for manual guard
    }

    private void useReflection() throws Exception {
        Method method = S1144_exceptions.class.getDeclaredMethod("invokedReflectively");
        method.setAccessible(true);
        method.invoke(this);
    }

    @interface Qualifier {}
}

