package com.sonarorw.rules.s2692;

/*
Sonar rule S2692 official recommendations (https://rules.sonarsource.com/java/RSPEC-2692/):
Use String.contains when only membership is needed, or compare indexOf against >= 1 when intentionally skipping the first element.
String name = "ishmael";
if (name.contains("ish")) {
  // ...
}
String name = "ishmael";
if (name.indexOf("ish") >= 1) {
  // ...
}
*/
class S2692_compliant_official {
    boolean containsUsingApi(String name) {
        return name.contains("ish");
    }

    boolean skipsFirstElement(String name) {
        return name.indexOf("ish") >= 1;
    }
}
