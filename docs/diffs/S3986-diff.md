diff --git "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmpF905.tmp" b/src/test/java/com/sonarorw/rules/s3986/S3986_uncompliant.java
index 98c56e5..db80384 100644
--- "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmpF905.tmp"
+++ b/src/test/java/com/sonarorw/rules/s3986/S3986_uncompliant.java
@@ -18,2 +18,2 @@ class S3986_uncompliant {
-        String result = new SimpleDateFormat("YYYY/MM/dd").format(date);
-        String modern = DateTimeFormatter.ofPattern("YYYY/MM/dd")
+        String result = new SimpleDateFormat("yyyy/MM/dd").format(date);
+        String modern = DateTimeFormatter.ofPattern("yyyy/MM/dd")
