package com.sonarorw.rules.S2129;

import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * Compliant solution for S2129
 */
public class S2129_compliant_official {
    public void compliantMethod() {
        // Compliant: Using literals or valueOf()
        String empty = "";
        String nonempty = "Hello world";
        Double myDouble = 1.1;
        Integer integer = 1;
        Boolean bool = true;
        BigInteger bigInteger1 = BigInteger.valueOf(3);
        BigInteger bigInteger2 = BigInteger.valueOf(9223372036854775807L);
        BigInteger bigInteger3 = new BigInteger("111222333444555666777888999");
        BigDecimal bigDecimal = new BigDecimal("42.0");
    }
}
