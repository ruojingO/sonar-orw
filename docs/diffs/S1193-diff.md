-        try {
-            throw new IllegalStateException("fail");
-        } catch (IllegalStateException ex) {
-            throw ex;
-        }
+        throw new IllegalStateException("fail");
