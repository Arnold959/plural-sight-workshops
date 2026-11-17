package StaticClasses;


public class Main {

    public static void main(String[] args) {

        // Test 1: First name and last name
        String name1 = NameFormatter.format(
                "Mel", "Johnson");

        System.out.println(name1);

        // Test 2: All five name parts
        String name2 = NameFormatter.format(
                "Dr.", "Mel", "B",
                "Johnson", "PhD");

        System.out.println(name2);

        // Test 3: Without prefix
        String name3 = NameFormatter.format(
                "", "Mel", "B",
                "Johnson", "PhD");

        System.out.println(name3);

        // Test 4: Full name as one String
        String name4 = NameFormatter.format(
                "Mel Johnson");

        System.out.println(name4);

        // Test 5: Full name with all parts
        String name5 = NameFormatter.format(
                "Dr. Mel B Johnson PhD");

        System.out.println(name5);
    }
}

