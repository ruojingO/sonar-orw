package com.sonarorw.rules.s3457;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
Sonar rule S3457 official noncompliant snippet (https://rules.sonarsource.com/java/RSPEC-3457/):
void logging(org.slf4j.Logger slf4jLog, java.util.logging.Logger logger) {
    String.format("Too many arguments %d and %d", 1, 2, 3); // Noncompliant - the third argument '3' is unused
    String.format("First {0} and then {1}", "foo", "bar");  //Noncompliant - it appears there is confusion with the use of "java.text.MessageFormat" - parameters "foo" and "bar" will be ignored here


    slf4jLog.debug("The number: ", 1); // Noncompliant - String contains no format specifiers.

    logger.log(level, "Can't load library \"{0}\"!", "foo"); // Noncompliant - the single quote ' must be escaped
}
*/
class S3457_uncompliant {
    private final Level level = Level.SEVERE;
    private final Logger julLogger = Logger.getLogger(S3457_uncompliant.class.getName());

    interface Slf4jLogger {
        void debug(String format, Object arg);
    }

    void logging(Slf4jLogger slf4jLog, Logger logger) {
        String.format("Too many arguments %d and %d", 1, 2, 3);
        String.format("First {0} and then {1}", "foo", "bar");
        slf4jLog.debug("The number: ", 1);
        logger.log(level, "Can't load library \"{0}\"!", "foo");
    }
}