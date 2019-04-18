package ch5.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Your return flight leaves Frankfurt at 14:05 and arrives in Los Angeles at
 * 16:40. How long is the flight? Write a program that can handle calculations
 * like this.
 */
public class Task11 {
    public static void main(String[] args) {
        ZonedDateTime departure = ZonedDateTime.of(
                LocalDateTime.of(2019, 4, 9, 15, 5),
                ZoneId.of("Europe/Berlin"));
        ZonedDateTime arrival = ZonedDateTime.of(
                LocalDateTime.of(2019, 4, 9, 15, 5),
                ZoneId.of("America/Los_Angeles"));
        Duration btw = Duration.between(departure, arrival);
        System.out.printf("%d:%02d%n", btw.toHoursPart(), btw.toMinutesPart());
    }
}
