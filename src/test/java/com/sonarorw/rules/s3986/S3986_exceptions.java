package com.sonarorw.rules.s3986;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

class S3986_exceptions {
    String formatIsoWeekDate(Date input) {
        SimpleDateFormat weekFormatter = new SimpleDateFormat("YYYY-ww", Locale.ENGLISH);
        return weekFormatter.format(input); // compliant: week year used with week number
    }

    String formatIsoWeekDateModern() throws ParseException {
        Date legacy = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse("2015/12/31");
        return DateTimeFormatter.ofPattern("YYYY-ww", Locale.ENGLISH)
                .format(legacy.toInstant().atZone(java.time.ZoneOffset.UTC).toLocalDate());
    }
}

