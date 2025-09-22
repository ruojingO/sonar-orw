diff --git "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmp3E07.tmp" b/src/test/java/com/sonarorw/rules/s3457/S3457_uncompliant.java
index d1190f9..5234703 100644
--- "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmp3E07.tmp"
+++ b/src/test/java/com/sonarorw/rules/s3457/S3457_uncompliant.java
@@ -27,2 +27,2 @@ class S3457_uncompliant {
-        String.format("Too many arguments %d and %d", 1, 2, 3);
-        String.format("First {0} and then {1}", "foo", "bar");
+        String.format("Too many arguments %d and %d", 1, 2);
+        String.format("First {0} and then {1}");
@@ -32 +32 @@ class S3457_uncompliant {
-}
\ No newline at end of file
+}
