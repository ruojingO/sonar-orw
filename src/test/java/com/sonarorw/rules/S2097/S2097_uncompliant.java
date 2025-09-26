package com.sonarorw.rules.S2097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class S2097_uncompliant {
    String readLine() throws IOException {
        try (BufferedReader reader = new BufferedReader(new StringReader("data"))) {
            String line = reader.readLine();
            reader.close();
            return line;
        }
    }
}
