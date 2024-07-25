package com.starwars.sabresjava.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class DataUtilsTest {

    @Test
    void testConvertStringToLocalDate() {
        String dateString = "25/12/2023";
        LocalDate expectedDate = LocalDate.of(2023, 12, 25);

        LocalDate result = DataUtils.convertStringToLocalDate(dateString);

        assertEquals(expectedDate, result);
    }

    @Test
    void testConvertLocalDateToString() {
        LocalDate localDate = LocalDate.of(2023, 12, 25);
        String expectedDateString = "25/12/2023";

        String result = DataUtils.convertLocalDateToString(localDate);

        assertEquals(expectedDateString, result);
    }

    @Test
    void testConvertStringToLocalDate_invalidFormat() {
        String invalidDateString = "2023-12-25";

        assertThrows(DateTimeParseException.class, () -> {
            DataUtils.convertStringToLocalDate(invalidDateString);
        });
    }
}