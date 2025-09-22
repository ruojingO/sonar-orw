diff --git "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmp9A01.tmp" b/src/test/java/com/sonarorw/rules/s2112/S2112_uncompliant.java
index 74a674c..1dd7d1b 100644
--- "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmp9A01.tmp"
+++ b/src/test/java/com/sonarorw/rules/s2112/S2112_uncompliant.java
@@ -3,0 +4 @@ import java.net.MalformedURLException;
+import java.net.URI;
@@ -16 +17 @@ class S2112_uncompliant {
-        return homepage.equals(url) || sites.contains(homepage);
+        return URI.create(homepage.toString()).equals(URI.create(url.toString())) || sites.contains(homepage);
