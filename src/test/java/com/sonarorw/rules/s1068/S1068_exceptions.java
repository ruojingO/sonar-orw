package com.sonarorw.rules.s1068;

class S1068_exceptions implements java.io.Serializable {
    private static final long serialVersionUID = 42L; // compliant: serialization id fields are ignored

    @SomeAnnotation
    private int annotatedField; // compliant: custom annotation keeps the field out of scope

    private int nativeBackedField = 42; // compliant: native code may rely on this field

    private native void doSomethingNative();

    @interface SomeAnnotation {}
}

