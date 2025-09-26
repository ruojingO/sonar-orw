package com.sonarorw.rules;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains code that is non-compliant with Sonar rule S3599.
 * It uses double-brace initialization, which should be replaced.
 */
public class S3599Uncompliant {

    public void initializeSet() {
        // Noncompliant: Double-brace initialization
        Set<String> mySet = new HashSet<String>();
        mySet.add("apple");
        mySet.add("banana");
        mySet.add("cherry");

        System.out.println("Set created with double-brace initialization: " + mySet);
    }
}
