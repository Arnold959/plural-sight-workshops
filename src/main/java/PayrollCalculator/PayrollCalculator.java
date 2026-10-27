package PayrollCalculator;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Ask for the input file
        System.out.print("Enter the name of the file to process:");
        String inputFile=scanner.nextLine();

        System.out.print("Enter the name of the payroll file to create:");
        String outputFile=scanner.nextLine();


        try {
            // Read the existing CSV file
            FileReader file = new FileReader(inputFile);;
            BufferedReader reader = new BufferedReader(file);
            //Create the payroll CSV file
            FileWriter writer = new FileWriter(outputFile);
            //Write the header
            writer.write("id|name|gross pay\n");
            //Skip the header row
            reader.readLine();

            String line;

            // Read each employee
            while ((line = reader.readLine()) != null) {

                // Separate the employee data
                String[] data = line.split("\\|");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double hours = Double.parseDouble(data[2]);
                double rate = Double.parseDouble(data[3]);

                // Create employee object
                Employee employee = new Employee(id, name, hours, rate);
                //Calculate gross pay
                double grossPay = employee.getGrossPay();

                // write employee payroll to csv
                writer.write(employee.getEmployeeId()
                        +"|"+employee.getName()+"|"+String.format("%.2f",grossPay)+"\n");
            }
            //Close files
            reader.close();
            writer.close();
            System.out.println("Payroll file created successfully!");

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        scanner.close();
    }
}

