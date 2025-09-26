package com.sonarorw.rules;

import java.util.HashSet;
import java.util.Set;

/**
 * This class contains code that is compliant with Sonar rule S3599.
 */
public class S3599_compliant_official {

    public void initializeSet() {
        Set<String> mySet = new HashSet<String>();
        mySet.add("apple");
        mySet.add("banana");
        mySet.add("cherry");

        System.out.println("Set created with standard initialization: " + mySet);
    }
}
