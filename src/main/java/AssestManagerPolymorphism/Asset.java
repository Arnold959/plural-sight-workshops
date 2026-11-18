package AssestManagerPolymorphism;


import java.math.BigDecimal;

public class Asset {

    // Properties shared by all assets
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

    // Returns the original cost of the asset
    public BigDecimal getValue() {
        return originalCost;
    }
}
