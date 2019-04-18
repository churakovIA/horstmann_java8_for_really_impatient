package ch5.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalTime.of;

/**
 * Implement a TimeInterval class that represents an interval of time, suitable for
 * calendar events (such as a meeting on a given date from 10:00 to 11:00).
 * Provide a method to check whether two intervals overlap.
 */
public class Task7 {
    public static void main(String[] args) {
        TimeInterval fst = new TimeInterval(of(10, 0), of(12, 0));
        TimeInterval snd = new TimeInterval(of(12, 1), of(14, 0));
        System.out.printf("%s and %s %s", fst, snd, fst.isOverloop(snd) ? "is overloop" : "is not overloop");
    }

    private static class TimeInterval {

        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

        private LocalTime start;
        private LocalTime end;

        public TimeInterval() {
            this.start = LocalTime.MIN;
            this.end = LocalTime.MAX;
        }

        TimeInterval(LocalTime start, LocalTime end) {
            this.start = start;
            this.end = end;
        }

        boolean isOverloop(TimeInterval interval) {
            return !(start.isBefore(interval.start) && end.isBefore(interval.start)
                    || start.isAfter(interval.end) && end.isAfter(interval.end));
        }

        @Override
        public String toString() {
            return "TimeInterval{" +
                    FORMATTER.format(start) +
                    "-" + FORMATTER.format(end) +
                    '}';
        }
    }
}
