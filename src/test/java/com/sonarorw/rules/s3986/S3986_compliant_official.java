package com.sonarorw.rules.s3986;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
Sonar rule S3986 official compliant snippet (https://rules.sonarsource.com/java/RSPEC-3986/):
Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2015/12/31");
String result = new SimpleDateFormat("yyyy/MM/dd").format(date);   //Yields '2015/12/31' as expected
result = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(date); //Yields '2015/12/31' as expected
*/
class S3986_compliant_official {
    String formatWithCalendarYear() throws ParseException {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse("2015/12/31");
        String legacy = new SimpleDateFormat("yyyy/MM/dd").format(date);
        String modern = DateTimeFormatter.ofPattern("yyyy/MM/dd")
                .format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return legacy + modern;
    }
}