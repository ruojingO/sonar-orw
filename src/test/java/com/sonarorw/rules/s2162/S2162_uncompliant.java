package com.sonarorw.rules.s2162;

/*
Sonar rule S2162 官方不合规示例：equals 使用 instanceof，破坏对协变子类的对称性。
*/
class S2162_uncompliant {
    private final String ripe = "summer";

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof S2162_uncompliant) { // Noncompliant
            return ripe.equals(((S2162_uncompliant) obj).ripe);
        }
        return false;
    }
}