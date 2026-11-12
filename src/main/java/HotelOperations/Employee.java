package HotelOperations;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    //Private variables
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    //New variables
    private int startTime;
    private boolean working;
    private LocalDateTime clockInTime;
    //Constructor
    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;

        startTime = 0;
        working = false;
    }
    //Get employee ID
    public int getEmployeeId() {
        return employeeId;
    }
    //Get employee name
    public String getName() {
        return name;
    }
    //Get department
    public String getDepartment() {
        return department;
    }
    //Get hourly pay rate
    public double getPayRate() {
        return payRate;
    }
    //Get hours worked
    public double getHoursWorked() {
        return hoursWorked;
    }
    //Get regular hours
    public double getRegularHours(){
        if(hoursWorked > 40){
            return 40;
        }else{
            return hoursWorked;
        }
    }
    //Get overtime hours
    public double getOvertimeHours() {
        if(hoursWorked > 40){
            return hoursWorked - 40;
        } else{
            return 0;
        }
    }
    //Calculate total pay
    public double getTotalPay(){
        double regularPay = getRegularHours()*payRate;
        double overtimePay = getOvertimeHours()*payRate*1.5;
        return regularPay+overtimePay;
    }
    //Employee punches in
    public void punchIn(int time){
        if(!working && time >=0 && time <=23){
            startTime = time;
            working = true;
            System.out.println(name +"punched in at "+time);
        }else{
            System.out.println("Cannot punch in.");
        }
    }
    //Employee punches out
    public void punchOut(int time){
        if(working && time >= startTime && time <=23){
            int hours = time - startTime;
            hoursWorked = hoursWorked + hours;
            working = false;
            System.out.println(name +"punched out at "+time);
            System.out.println("Hours Worked: " + hours);
        }else{
            System.out.println("Cannot punch out.");
        }
    }
    //Overloaded methods
    //Punch in using the current time
    public void punchIn(){
        if(!working){
            clockInTime= LocalDateTime.now();
            working = true;
            System.out.println(name +"punched in at "+ ":"+clockInTime.getHour()+clockInTime.getMinute());
        } else{
            System.out.println("Employee is already working.");
        }
    }
    //Punch out using the current time
    public void punchOut(){
        if(working && clockInTime != null){
            LocalDateTime clockOutTime = LocalDateTime.now();
            //Calculate the time worked in minutes
            long minutes = java.time.Duration.between(clockInTime,clockOutTime).toMinutes();
            //Convert minutes into hours
            double hours = minutes/60;
            //Add hours to the employee's total
            hoursWorked = hoursWorked + hours;
            working = false;
            clockInTime = null;

            System.out.println(name +"punched out at "+clockOutTime.getHour()+clockOutTime.getMinute());
            System.out.println("Hours Worked: " + hours);
        } else {
            System.out.println("Employee has not punched in.");
        }
    }

    //Bonus Method
    public void punchTimeCard(int start, int end){
        punchIn(start);
        punchOut(end);
    }
}
