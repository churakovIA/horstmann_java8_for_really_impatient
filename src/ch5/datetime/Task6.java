package ch5.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * List all Friday the 13th in the twentieth century
 */
public class Task6 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1900, 1, 1);
        date.datesUntil(date.plusYears(99).with(TemporalAdjusters.lastDayOfYear()))
                .filter(d -> d.getDayOfWeek() == DayOfWeek.FRIDAY && d.getDayOfMonth() == 13)
                .forEach(System.out::println);
    }
}
