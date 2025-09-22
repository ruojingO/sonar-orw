package com.sonarorw.rules.s2692;

/*
Sonar rule S2692 official description excerpt (https://rules.sonarsource.com/java/RSPEC-2692/):
Most checks against an indexOf value compare it with -1 because 0 is a valid index. Checking against > 0 ignores the first element, which is likely a bug.
String name = "ishmael";
if (name.indexOf("ish") > 0) { // Noncompliant
  // ...
}
Moreover, if the intent is merely to check the inclusion of a value in a String or a List, consider using the contains method instead.
String name = "ishmael";
if (name.contains("ish")) {
  // ...
}
If the intent is really to skip the first element, comparing it with >=1 will make it more straightforward.
String name = "ishmael";
if (name.indexOf("ish") >= 1) {
  // ...
}
This rule raises an issue when an indexOf value retrieved from a String or a List is tested against > 0.
*/
class S2692_uncompliant {
    boolean containsAtPositiveIndex(String name) {
        return name.indexOf("ish") > 0;
    }
}