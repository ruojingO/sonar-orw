package com.sonarorw.rules.s3986;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
Sonar rule S3986 official noncompliant snippet (https://rules.sonarsource.com/java/RSPEC-3986/):
Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2015/12/31");
String result = new SimpleDateFormat("YYYY/MM/dd").format(date);   //Noncompliant; yields '2016/12/31'
result = DateTimeFormatter.ofPattern("YYYY/MM/dd").format(date); //Noncompliant; yields '2016/12/31'
*/
class S3986_uncompliant {
    String formatWithWeekYear() throws ParseException {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2015/12/31");
        String result = new SimpleDateFormat("YYYY/MM/dd").format(date);
        String modern = DateTimeFormatter.ofPattern("YYYY/MM/dd")
                .format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return result + modern;
    }
}