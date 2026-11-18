package AbstactAssestManager;

import java.math.BigDecimal;

// Abstract parent class
public abstract class Asset {

    // Properties
    private String description;
    private String dateAcquired;
    private BigDecimal originalCost;

    // Constructor
    public Asset(String description, String dateAcquired,
                 BigDecimal originalCost) {

        this.description = description;
        this.dateAcquired = dateAcquired;
        this.originalCost = originalCost;
    }

    // Getters and setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    // Abstract method - no method body
    // Child classes must provide their own implementation
    public abstract BigDecimal getValue();
}

