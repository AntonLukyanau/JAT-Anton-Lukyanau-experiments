package org.example.java8;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DateTimeAPITask {

    public static void main(String[] args) {
        int year = 2023;
        for (int month = 1; month <= 12; month++) {
            LocalDate date = LocalDate.of(year, month, 13);
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                System.out.println(date);
            }
        }

        LocalDate localDate = LocalDate.of(year, 2, 1);
        System.out.println(localDate.isLeapYear());

    }

}
