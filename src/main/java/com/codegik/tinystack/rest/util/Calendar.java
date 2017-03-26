package com.codegik.tinystack.rest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public final class Calendar {

    public static Date toDate(LocalDate localDate) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().minusYears(19).toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
