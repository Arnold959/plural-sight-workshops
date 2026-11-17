package StaticClasses;


public class NameFormatter {

    // Private constructor
    // Prevents creating objects of this class
    private NameFormatter() {
    }

    // Method 1: First name and last name
    public static String format(String firstName,
                                String lastName) {

        return lastName + ", " + firstName;
    }

    // Method 2: Full name with all five parts
    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {

        String name = lastName + ", ";

        // Add prefix if it is provided
        if (!prefix.isEmpty()) {
            name += prefix + " ";
        }

        // Add first name
        name += firstName;

        // Add middle name if provided
        if (!middleName.isEmpty()) {
            name += " " + middleName;
        }

        // Add suffix if provided
        if (!suffix.isEmpty()) {
            name += ", " + suffix;
        }

        return name;
    }

    // Method 3: Format a name entered as one String
    public static String format(String fullName) {

        // Split the name into parts
        String[] parts = fullName.trim().split("\\s+");

        // First name and last name only
        if (parts.length == 2) {
            return format(parts[0], parts[1]);
        }

        // First name, middle name and last name
        if (parts.length == 3) {
            return format("", parts[0], parts[1],
                    parts[2], "");
        }

        // Prefix, first name, middle name,
        // last name and suffix
        if (parts.length == 5) {
            return format(parts[0], parts[1],
                    parts[2], parts[3],
                    parts[4]);
        }

        // Return original name for other cases
        return fullName;
    }
}
