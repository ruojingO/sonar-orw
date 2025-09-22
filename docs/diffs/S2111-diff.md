diff --git "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmpBCF5.tmp" "b/src\\test\\java\\com\\sonarorw\\rules\\s2111\\S2111_uncompliant.java"
index f6cd9d2..b60e0ab 100644
--- "a/C:\\Users\\ruoji\\AppData\\Local\\Temp\\tmpBCF5.tmp"
+++ "b/src\\test\\java\\com\\sonarorw\\rules\\s2111\\S2111_uncompliant.java"
@@ -17 +17 @@ class S2111_uncompliant {
-        return new BigDecimal(0.1d);
+        return BigDecimal.valueOf(0.1d);
@@ -22 +22 @@ class S2111_uncompliant {
-        return new BigDecimal(value);
+        return BigDecimal.valueOf(value);
