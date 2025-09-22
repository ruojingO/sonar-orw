package com.sonarorw.rules.s2162;

/*
Sonar rule S2162 官方修复：使用 getClass() 并避免与无关类型比较。
*/
class S2162_compliant_official {
    private final String ripe = "summer";

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        S2162_compliant_official other = (S2162_compliant_official) obj;
        return ripe.equals(other.ripe);
    }

    @Override
    public int hashCode() {
        return ripe.hashCode();
    }
}