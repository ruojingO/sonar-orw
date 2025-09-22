package com.sonarorw.rules.s2112;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/*
Sonar rule S2112 官方合规示例：优先使用 URI。
*/
class S2112_compliant_official {
    boolean checkUrl(URL url) throws MalformedURLException, URISyntaxException {
        Set<URI> sites = new HashSet<URI>();
        URI homepage = new URI("http://sonarsource.com");
        sites.add(homepage);
        URI uri = url.toURI();
        return homepage.equals(uri) || sites.contains(uri);
    }
}