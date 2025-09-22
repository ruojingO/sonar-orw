package com.sonarorw.rules.s2111;

import java.math.BigDecimal;

/*
Sonar rule S2111 official snippet (https://rules.sonarsource.com/java/RSPEC-2111/)
Noncompliant:
  double doubleValue = 0.1d;
  BigDecimal bd1 = new BigDecimal(doubleValue);
  BigDecimal bd2 = new BigDecimal(0.1d);
Explanation: passing a double directly inherits IEEE-754 precision loss and the BigDecimal cannot exactly represent 0.1.
*/
class S2111_uncompliant {
    double cachedValue = 0.1d;

    BigDecimal fromLiteral() {
        return BigDecimal.valueOf(0.1d);
    }

    BigDecimal fromVariable() {
        double value = cachedValue;
        return BigDecimal.valueOf(value);
    }
}
