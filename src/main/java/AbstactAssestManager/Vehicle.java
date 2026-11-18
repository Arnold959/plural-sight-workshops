package AbstactAssestManager;



import java.math.BigDecimal;
import java.time.Year;

public class Vehicle extends Asset {

    // Properties specific to vehicles
    private String makeModel;
    private int year;
    private int odometer;

    // Constructor
    public Vehicle(String description, String dateAcquired,
                   BigDecimal originalCost, String makeModel,
                   int year, int odometer) {

        // Call the parent constructor
        super(description, dateAcquired, originalCost);

        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // Getters and setters
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // Override the parent's getValue() method
    @Override
    public BigDecimal getValue() {

        // Calculate the age of the vehicle
        int currentYear = Year.now().getValue();
        int age = currentYear - year;

        BigDecimal value = getOriginalCost();
        double depreciation = 0;

        // Determine depreciation rate
        if (age <= 3) {
            depreciation = 0.03;
        } else if (age <= 6) {
            depreciation = 0.06;
        } else if (age <= 10) {
            depreciation = 0.08;
        } else {
            value = new BigDecimal("1000.00");
        }

        // Calculate depreciation for vehicles up to 10 years
        if (age <= 10) {
            double reduction = depreciation * age;

            value = value.multiply(
                    BigDecimal.valueOf(1 - reduction));
        }

        // Check if vehicle is Honda or Toyota
        boolean isHonda = makeModel.toLowerCase()
                .contains("honda");

        boolean isToyota = makeModel.toLowerCase()
                .contains("toyota");

        // Reduce value by 25% for high mileage
        // Honda and Toyota are excluded
        if (odometer > 100000 && !isHonda && !isToyota) {
            value = value.multiply(
                    new BigDecimal("0.75"));
        }

        return value;
    }
}

