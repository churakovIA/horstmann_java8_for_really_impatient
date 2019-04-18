package ch5.datetime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Write a program that solves the problem described at the beginning of
 * Section 5.5, “Zoned Time,” on page 109. Read a set of appointments in different
 * time zones and alert the user which ones are due within the next hour in
 * local time.
 */
public class Task12 {
    public static void main(String[] args) {
        Set<ZonedDateTime> events = new HashSet<>() {
            {
                add(
                        ZonedDateTime.of(
                                LocalDateTime.now().plusHours(-2),
                                ZoneId.of("Europe/Berlin"))
                );
                add(
                        ZonedDateTime.of(
                                LocalDateTime.now().plusHours(-10),
                                ZoneId.of("America/Los_Angeles"))
                );
            }

        };
        System.out.println("All:\n" + events);
        System.out.println("filtered:\n" + getEvent(events));
    }

    private static Set<ZonedDateTime> getEvent(Set<ZonedDateTime> events) {
        ZonedDateTime now = ZonedDateTime.now();
        return events.stream()
                .filter(zdt -> Duration.between(zdt, now).toMinutes() <= 60 && Duration.between(zdt, now).toMinutes() > 0)
                .collect(Collectors.toSet());
    }
}
