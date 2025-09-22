package com.sonarorw.rules.s106;

import java.util.logging.Logger;

/*
Sonar rule S106 官方合规示例：使用 logger。
*/
class S106_compliant_official {
    private static final Logger LOGGER = Logger.getLogger(S106_compliant_official.class.getName());

    void doSomething() {
        LOGGER.info("My Message");
    }
}