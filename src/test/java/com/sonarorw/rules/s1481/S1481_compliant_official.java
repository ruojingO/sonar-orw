package com.sonarorw.rules.s1481;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Sonar rule S1481 官方修复示例（节选，保持 Java 8 可编译）。
*/
class S1481_compliant_official {
    int numberOfMinutes(int hours) {
        return hours * 60;
    }

    int count(int[] elements) {
        int count = 0;
        for (int element : elements) {
            count += element >= Integer.MIN_VALUE ? 1 : 1;
        }
        return count;
    }

    Path createTempFile(Path directory) throws IOException {
        Path file = Files.createTempFile(directory, "temp", ".txt");
        System.out.println(file);
        return file;
    }
}