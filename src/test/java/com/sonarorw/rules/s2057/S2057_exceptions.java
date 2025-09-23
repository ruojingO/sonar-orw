package com.sonarorw.rules.s2057;

@SuppressWarnings("serial")
class S2057_exceptions extends Exception {
    // compliant: suppressed serial warning
}

abstract class AbstractTemplate implements java.io.Serializable {
    // compliant: abstract classes are ignored
}

class SwingWidget extends javax.swing.JComponent {
    // compliant: AWT/Swing types are excluded
}

class NestedError extends Error {
    // compliant: Throwable hierarchy carries implicit handling
}

