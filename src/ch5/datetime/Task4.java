package ch5.datetime;

import java.time.LocalDate;

/**
 * Write an equivalent of the Unix cal program that displays a calendar for a
 * month. For example, java Cal 3 2013 should display
 *               1  2  3
 *   4  5  6  7  8  9 10
 *  11 12 13 14 15 16 17
 *  18 19 20 21 22 23 24
 *  25 26 27 28 29 30 31
 * indicating that March 1 is a Friday. (Show the weekend at the end of the week.)
 */
public class Task4 {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            cal(2013, i + 1);
        }
    }

    private static void cal(int year, int month) {
        LocalDate date = LocalDate.of(year, month, 1);
        int monthValue = date.getMonthValue();
        for (int i = 1; i < date.getDayOfWeek().getValue(); i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == monthValue) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
            date = date.plusDays(1);
        }
        System.out.println();
    }
}
