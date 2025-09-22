diff --git "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmpAFAB.tmp" b/src/test/java/com/sonarorw/rules/s3020/S3020_uncompliant.java
index 59702b2..c6c196c 100644
--- "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmpAFAB.tmp"
+++ b/src/test/java/com/sonarorw/rules/s3020/S3020_uncompliant.java
@@ -18 +18 @@ class S3020_uncompliant {
-        return (String[]) values.toArray();
+        return values.toArray(new String[0]);
