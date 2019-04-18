package ch5.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Obtain the offsets of today’s date in all supported time zones for the current
 * time instant, turning ZoneId.getAvailableIds into a stream and using stream
 * operations.
 */
public class Task8 {
    public static void main(String[] args) {
        ZonedDateTime lzdt = ZonedDateTime.now();

        ZoneId.getAvailableZoneIds().stream()
                .sorted()
                .map(id -> id + ": " + lzdt.withZoneSameInstant(ZoneId.of(id)).getOffset())
                .forEach(System.out::println);
    }
}
