package AbstactAssestManager;


import java.math.BigDecimal;

public class House extends Asset {

    // Properties specific to a house
    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    // Constructor
    public House(String description, String dateAcquired,
                 BigDecimal originalCost, String address,
                 int condition, int squareFoot, int lotSize) {

        // Call the parent class constructor
        super(description, dateAcquired, originalCost);

        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    // Getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    // Override the parent's getValue() method
    @Override
    public BigDecimal getValue() {

        int pricePerFoot = 0;

        // Determine price based on house condition
        if (condition == 1) {
            pricePerFoot = 180;
        } else if (condition == 2) {
            pricePerFoot = 130;
        } else if (condition == 3) {
            pricePerFoot = 90;
        } else if (condition == 4) {
            pricePerFoot = 80;
        }

        // Calculate the house value
        BigDecimal houseValue = BigDecimal.valueOf(
                squareFoot * pricePerFoot);

        // Calculate the lot value
        BigDecimal lotValue = BigDecimal.valueOf(lotSize)
                .multiply(new BigDecimal("0.25"));

        // Add house value and lot value
        return houseValue.add(lotValue);
    }
}
