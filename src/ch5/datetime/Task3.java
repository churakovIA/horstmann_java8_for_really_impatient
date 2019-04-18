package ch5.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;
import java.util.stream.LongStream;

/**
 * Implement a method next that takes a Predicate<LocalDate> and returns an
 * adjuster yielding the next date fulfilling the predicate. For example,
 * today.with(next(w -> getDayOfWeek().getValue() < 6))
 * computes the next workday.
 */
public class Task3 {

    private static LocalDate EMPTY_DATE = LocalDate.of(1, 1, 1);
    private static LocalDate MAX_DATE = LocalDate.of(2999, 12, 31);

    public static void main(String[] args) {
        final LocalDate now = LocalDate.now();
        LocalDate date = now.with(next(w -> w.getDayOfWeek().getValue() < 6));
        System.out.printf("Now: %21s%n", now);
        System.out.printf("Next: %20s%n", date);

        //date not found
        LocalDate emptyDate = now.with(nextJava8(w -> w.getYear() < 2019));
        System.out.printf("Next not found: %s%n", emptyDate);
    }

    private static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return w -> {
            LocalDate next = (LocalDate) w.plus(1, ChronoUnit.DAYS);
            return next.datesUntil(MAX_DATE).filter(predicate).findFirst().orElse(EMPTY_DATE);
        };
    }

    private static TemporalAdjuster nextJava8(Predicate<LocalDate> predicate) {
        return w -> {
            LocalDate startDate = (LocalDate) w;
            long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, MAX_DATE);
            return LongStream.range(1, numOfDaysBetween)
                    .mapToObj(startDate::plusDays)
                    .filter(predicate)
                    .findFirst().orElse(EMPTY_DATE);
        };
    }
}
