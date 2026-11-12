package HotelOperations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    // Test employee punching in and out
    @Test
    public void testPunchInAndOut() {

        Employee employee = new Employee(
                101, "John", "Reception", 20.00, 0);

        employee.punchIn(9);
        employee.punchOut(17);

        // 17 - 9 = 8 hours
        assertEquals(8.0, employee.getHoursWorked());
    }

    // Test multiple shifts
    @Test
    public void testMultipleShifts() {

        Employee employee = new Employee(
                102, "Mary", "Housekeeping", 20.00, 0);

        // First shift: 8 hours
        employee.punchIn(8);
        employee.punchOut(16);

        // Second shift: 6 hours
        employee.punchIn(10);
        employee.punchOut(16);

        // Total = 14 hours
        assertEquals(14.0, employee.getHoursWorked());
    }

    // Test employee punching out without punching in
    @Test
    public void testPunchOutWithoutPunchIn() {

        Employee employee = new Employee(
                103, "James", "Security", 20.00, 0);

        employee.punchOut(17);

        // Hours should remain zero
        assertEquals(0.0, employee.getHoursWorked());
    }

    // Test employee punching in twice
    @Test
    public void testPunchInTwice() {

        Employee employee = new Employee(
                104, "Jane", "Reception", 20.00, 0);

        employee.punchIn(9);
        employee.punchIn(12);
        employee.punchOut(17);

        // First punch-in time should remain 9
        assertEquals(8.0, employee.getHoursWorked());
    }

    // Test total pay after working
    @Test
    public void testTotalPay() {

        Employee employee = new Employee(
                105, "Peter", "Reception", 20.00, 0);

        employee.punchIn(9);
        employee.punchOut(17);

        // 8 hours x $20 = $160
        assertEquals(160.0, employee.getTotalPay());
    }
}
