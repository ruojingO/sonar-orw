package com.sonarorw.sec;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.SecureRandom;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SecuritySamples_compliant {

    public void secureRandom() {
        SecureRandom random = new SecureRandom();
        System.out.println(random.nextInt());
    }

    public File secureTempFile() throws IOException {
        return Files.createTempFile("tmp", ".txt").toFile();
    }

    public DocumentBuilderFactory secureXmlParser() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        factory.setXIncludeAware(false);
        factory.setExpandEntityReferences(false);
        return factory;
    }
}
