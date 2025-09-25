package com.sonarorw.sec;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.xml.parsers.DocumentBuilderFactory;

public class SecuritySamples_uncompliant {

    public void insecureRandom() {
        // 未使用安全随机数
        Random random = new Random();
        System.out.println(random.nextInt());
    }

    public File insecureTempFile() throws IOException {
        // 使用 File.createTempFile 可能产生不安全权限
        return File.createTempFile("tmp", ".txt");
    }

    public DocumentBuilderFactory insecureXmlParser() {
        // 未关闭 XXE 的 DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory;
    }
}
