package ch5.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Your flight from Los Angeles to Frankfurt leaves at 3:05 pm local time and
 * takes 10 hours and 50 minutes. When does it arrive? Write a program that
 * can handle calculations like this.
 */
public class Task10 {
    public static void main(String[] args) {
        ZonedDateTime leave = ZonedDateTime.of(
                LocalDateTime.of(2019, 4, 9, 15, 5),
                ZoneId.of("America/Los_Angeles"));
        ZonedDateTime arrive = getArrival(leave, Duration.ofHours(10).plusMinutes(50), "Europe/Berlin");
        System.out.println(leave);
        System.out.println(arrive);
    }

    private static ZonedDateTime getArrival(ZonedDateTime departure, Duration duration, String zoneId) {
        return departure.plus(duration).withZoneSameInstant(ZoneId.of(zoneId));
    }
}
