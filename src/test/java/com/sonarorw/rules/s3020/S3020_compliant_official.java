package com.sonarorw.rules.s3020;

import java.util.ArrayList;
import java.util.List;

/*
Sonar rule S3020 官方修复：传入目标类型数组。
*/
class S3020_compliant_official {
    String[] copyToArray(List<String> source) {
        return source.toArray(new String[source.size()]);
    }

    String[] copyDefault() {
        List<String> values = new ArrayList<String>();
        values.add("a");
        values.add("b");
        return values.toArray(new String[0]);
    }
}