package com.sonarorw.rules.s1481;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Sonar rule S1481 官方不合规示例（节选，保持 Java 8 可编译）：
*/
class S1481_uncompliant {
    int numberOfMinutes(int hours) {
        int seconds = 0; // unused on purpose
        return hours * 60;
    }

    int count(int[] elements) {
        int count = 0;
        for (int el : elements) {
            count++;
        }
        return count;
    }

    Path createTempFile(Path directory) throws IOException {
        Path file = Files.createTempFile(directory, "temp", ".txt");
        System.out.println("file created");
        return file;
    }
}