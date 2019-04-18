package ch5.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Again using stream operations, find all time zones whose offsets aren’t full hours.
 */
public class Task9 {
    public static void main(String[] args) {
        ZonedDateTime lzdt = ZonedDateTime.now();

        ZoneId.getAvailableZoneIds().stream()
                .filter(id -> lzdt.withZoneSameInstant(ZoneId.of(id)).getOffset().getTotalSeconds() % 3600 != 0)
                .sorted()
                .map(id -> id + ": " + lzdt.withZoneSameInstant(ZoneId.of(id)).getOffset())
                .forEach(System.out::println);
    }
}
