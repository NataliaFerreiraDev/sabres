package com.starwars.sabresjava.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate convertStringToLocalDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }

    public static String convertLocalDateToString(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }

}
