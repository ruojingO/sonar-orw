diff --git "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmpEAA6.tmp" b/src/test/java/com/sonarorw/rules/s4973/S4973_uncompliant.java
index 3ec106f..3a1d42f 100644
--- "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmpEAA6.tmp"
+++ b/src/test/java/com/sonarorw/rules/s4973/S4973_uncompliant.java
@@ -8 +8 @@ class S4973_uncompliant {
-        return input == "yes";
+        return "yes".equals(input);
