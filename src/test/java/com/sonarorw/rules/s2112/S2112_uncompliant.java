package com.sonarorw.rules.s2112;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/*
Sonar rule S2112 官方不合规示例：在集合及 equals 中使用 URL。
*/
class S2112_uncompliant {
    boolean checkUrl(URL url) throws MalformedURLException {
        Set<URL> sites = new HashSet<URL>();
        sites.add(url);
        URL homepage = new URL("http://sonarsource.com");
        return homepage.equals(url) || sites.contains(homepage);
    }
}