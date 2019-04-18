package ch5.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Compute Programmer’s Day without using plusDays
 */
public class Task1 {
    public static void main(String[] args) {
        LocalDate start = LocalDate.now().withMonth(1).withDayOfMonth(1);
        LocalDate plusDays = start.plusDays(256);
        LocalDate plusUnit = start.plus(256, ChronoUnit.DAYS);
        System.out.println(String.format("Use plusDays: %s", plusDays));
        System.out.println(String.format("Use plusUnit: %s", plusUnit));
    }
}
