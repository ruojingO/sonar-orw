package com.sonarorw.rules.s3020;

import java.util.ArrayList;
import java.util.List;

/*
Sonar rule S3020 官方不合规示例：Collection.toArray() 未传入正确类型数组。
*/
class S3020_uncompliant {
    String[] copyToArray(List<String> source) {
        return (String[]) source.toArray(new Object[source.size()]);
    }

    String[] copyDefault() {
        List<String> values = new ArrayList<String>();
        values.add("a");
        values.add("b");
        return (String[]) values.toArray();
    }
}