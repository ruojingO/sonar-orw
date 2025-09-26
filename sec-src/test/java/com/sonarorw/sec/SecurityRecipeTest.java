package com.sonarorw.sec;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openrewrite.InMemoryExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.config.Environment;
import org.openrewrite.java.JavaParser;
import org.openrewrite.java.tree.J;
import org.openrewrite.Result;
import org.openrewrite.SourceFile;

class SecurityRecipeTest {

    private static final Environment ENV = Environment.builder()
            .scanRuntimeClasspath()
            .build();

    private static List<Result> runRecipe(String recipeName, String before) {
        Recipe recipe = ENV.activateRecipes(recipeName);
        JavaParser parser = JavaParser.fromJavaVersion().build();
        List<SourceFile> sources = parser.parse(before);
        return recipe.run(sources, new InMemoryExecutionContext()).getResults();
    }

    private static String renderAfter(Result result) {
        return ((J.CompilationUnit) result.getAfter()).printAll();
    }

    @Test
    void secureRandom() {
        String before = "import java.util.Random;\n\nclass A {\n    void test() {\n        Random random = new Random();\n        System.out.println(random.nextInt());\n    }\n}\n";
        List<Result> results = runRecipe("org.openrewrite.java.security.SecureRandom", before);
        Assertions.assertFalse(results.isEmpty(), "Recipe did not produce results");
        String after = renderAfter(results.get(0));
        Assertions.assertTrue(after.contains("java.security.SecureRandom"));
        Assertions.assertFalse(after.contains("java.util.Random"));
    }

    @Test
    void secureTempFileCreation() {
        String before = "import java.io.File;\nimport java.io.IOException;\n\nclass B {\n    File tmp() throws IOException {\n        return File.createTempFile(\"tmp\", \".txt\");\n    }\n}\n";
        List<Result> results = runRecipe("org.openrewrite.java.security.SecureTempFileCreation", before);
        Assertions.assertFalse(results.isEmpty(), "Recipe did not produce results");
        String after = renderAfter(results.get(0));
        Assertions.assertTrue(after.contains("java.nio.file.Files.createTempFile"));
    }

    @Test
    void xmlParserXXE() {
        String before = "import javax.xml.parsers.DocumentBuilderFactory;\n\nclass C {\n    DocumentBuilderFactory factory() {\n        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();\n        f.setNamespaceAware(true);\n        return f;\n    }\n}\n";
        List<Result> results = runRecipe("org.openrewrite.java.security.XmlParserXXEVulnerability", before);
        Assertions.assertFalse(results.isEmpty(), "Recipe did not produce results");
        String after = renderAfter(results.get(0));
        Assertions.assertTrue(after.contains("disallow-doctype-decl"));
        Assertions.assertTrue(after.contains("setExpandEntityReferences(false)"));
    }
}
