package AbstactAssestManager;


import java.math.BigDecimal;

// Cash inherits from Asset
public class Cash extends Asset {

    // Constructor
    public Cash(String description, String dateAcquired,
                BigDecimal originalCost) {

        // Call the parent class constructor
        super(description, dateAcquired, originalCost);
    }

    // Implement the abstract method
    @Override
    public BigDecimal getValue() {

        // Cash value stays the same
        return getOriginalCost();
    }
}

