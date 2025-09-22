package com.sonarorw.rules.s2111;

import java.math.BigDecimal;

/*
Sonar rule S2111 official snippet (https://rules.sonarsource.com/java/RSPEC-2111/)
Compliant:
  BigDecimal bd1 = BigDecimal.valueOf(0.1d);
  BigDecimal bd2 = new BigDecimal("0.1");
Explanation: using valueOf or a string constant avoids the precision loss of passing a double directly.
*/
class S2111_compliant_official {
    BigDecimal fromLiteral() {
        return BigDecimal.valueOf(0.1d);
    }

    BigDecimal fromString() {
        return new BigDecimal("0.1");
    }
}
