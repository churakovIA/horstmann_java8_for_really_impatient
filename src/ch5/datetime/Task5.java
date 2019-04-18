package ch5.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Write a program that prints how many days you have been alive
 */
public class Task5 {
    public static void main(String[] args) {
        long alive = LocalDate.of(1985, 7, 10).until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.printf("Alive days: %s", alive);
    }
}
