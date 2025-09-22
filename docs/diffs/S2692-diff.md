diff --git "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmp294E.tmp" b/src/test/java/com/sonarorw/rules/s2692/S2692_uncompliant.java
index 775acfe..31abf32 100644
--- "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmp294E.tmp"
+++ b/src/test/java/com/sonarorw/rules/s2692/S2692_uncompliant.java
@@ -24 +24 @@ class S2692_uncompliant {
-        return name.indexOf("ish") > 0;
+        return name.indexOf("ish") >= 1;
@@ -26 +26 @@ class S2692_uncompliant {
-}
\ No newline at end of file
+}
