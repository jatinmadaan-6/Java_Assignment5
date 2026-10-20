import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;

/**
 * Q4. Manage an event using LocalDate and LocalTime.
 * Input formats: date = dd-MM-yyyy, time = HH:mm (24-hour)
 */
public class Q4_EventManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("  Q4: Event Manager ");

        // Input format for the date: dd-MM-yyyy
        DateTimeFormatter inputDateFmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // 1. Accept event name, date, and start time
        System.out.print("Enter event name           : ");
        String name = sc.nextLine().trim();

        LocalDate eventDate = null;
        while (eventDate == null) {
            System.out.print("Enter event date (dd-MM-yyyy): ");
            try {
                eventDate = LocalDate.parse(sc.nextLine().trim(), inputDateFmt);
            } catch (DateTimeParseException e) {
                System.out.println("  Invalid date format. Try again (example: 25-12-2026).");
            }
        }

        LocalTime startTime = null;
        while (startTime == null) {
            System.out.print("Enter start time (HH:mm)   : ");
            try {
                startTime = LocalTime.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("  Invalid time format. Try again (example: 14:30).");
            }
        }

        // 6. Optional venue (blank input = not specified)
        System.out.print("Enter venue (press Enter to skip): ");
        String venueInput = sc.nextLine().trim();
        Optional<String> venue = venueInput.isEmpty() ? Optional.empty() : Optional.of(venueInput);

        // 5. End time (event lasts two hours)
        LocalTime endTime = startTime.plusHours(2);

        // 2. Display event details
        DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("dd-MM-yyyy (EEEE)");
        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("hh:mm a");

        System.out.println("\nEvent Details");
        System.out.println("Event        " + name);
        System.out.println("Date         " + eventDate.format(dateFmt));
        System.out.println("Start Time  " + startTime.format(timeFmt));
        System.out.println("End Time    " + endTime.format(timeFmt) + " (duration: 2 hours)");
        System.out.println("Venue       " + venue.orElse("Venue not specified"));

        // 3. Future / today / past
        LocalDate today = LocalDate.now();
        System.out.println("\nToday's date: " + today.format(inputDateFmt));
        if (eventDate.isAfter(today)) {
            System.out.println("Status      The event is in the FUTURE.");
        } else if (eventDate.isEqual(today)) {
            System.out.println("Status      The event is TODAY.");
        } else {
            System.out.println("Status      The event is in the PAST.");
        }

        // 4. Days remaining
        long daysRemaining = ChronoUnit.DAYS.between(today, eventDate);
        if (daysRemaining > 0) {
            System.out.println("Days remaining until event " + daysRemaining);
        } else if (daysRemaining == 0) {
            System.out.println("Days remaining until event: 0 (it's today!)");
        } else {
            System.out.println("The event ended " + Math.abs(daysRemaining) + " day(s) ago.");
        }

        sc.close();
    }
}