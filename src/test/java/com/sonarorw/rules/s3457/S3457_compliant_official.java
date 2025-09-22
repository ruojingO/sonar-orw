package com.sonarorw.rules.s3457;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
Sonar rule S3457 official compliant snippet (https://rules.sonarsource.com/java/RSPEC-3457/):
void logging(org.slf4j.Logger slf4jLog, java.util.logging.Logger logger) {
    String.format("Too many arguments %d and %d", 1, 2);
    String.format("First %s and then %s", "foo", "bar");

    slf4jLog.debug("The number: {}", 1);

    logger.log(level, "Can''t load library \"{0}\"!", "foo");
}
*/
class S3457_compliant_official {
    private final Level level = Level.SEVERE;

    interface Slf4jLogger {
        void debug(String format, Object arg);
    }

    void logging(Slf4jLogger slf4jLog, Logger logger) {
        String.format("Too many arguments %d and %d", 1, 2);
        String.format("First %s and then %s", "foo", "bar");
        slf4jLog.debug("The number: {}", 1);
        logger.log(level, "Can''t load library \"{0}\"!", "foo");
    }
}
