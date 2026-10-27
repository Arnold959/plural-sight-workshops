package DateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class FormatDates {
    public static void main(String[] args) {

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Create the date formats
        DateTimeFormatter format1 =
                DateTimeFormatter.ofPattern("MM/dd/yyyy");

        DateTimeFormatter format2 =
                DateTimeFormatter.ofPattern("yyyy-MM-dd");

        DateTimeFormatter format3 =
                DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");

        // Display the dates
        System.out.println(now.format(format1));
        System.out.println(now.format(format2));
        System.out.println(now.format(format3));

        // Get the current GMT time
        ZonedDateTime gmt = ZonedDateTime.now(
                ZoneId.of("GMT"));

        DateTimeFormatter format4 =
                DateTimeFormatter.ofPattern(
                        "EEEE, MMM dd, yyyy HH:mm");

        System.out.println(gmt.format(format4));

        // Challenge: Display local time
        DateTimeFormatter format5 =
                DateTimeFormatter.ofPattern(
                        "H:mm 'on' dd-MMM-yyyy");

        System.out.println(now.format(format5));
    }
}
