package ch5.datetime;

import java.time.LocalDate;

/**
 * What happens when you add one year to LocalDate.of(2000, 2, 29)? Four years?
 * Four times one year?
 */
public class Task2 {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2000, 2, 29);
        System.out.println(String.format("One year: %s", startDate.plusYears(1)));
        System.out.println(String.format("Four year: %s", startDate.plusYears(4)));
        for (int i = 0; i < 4; i++) {
            startDate = startDate.plusYears(1);
        }
        System.out.println(String.format("Four year by loop: %s", startDate));
    }
}
