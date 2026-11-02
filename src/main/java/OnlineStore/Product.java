package OnlineStore;

public class Product {

    String sku;
    String name;
    double price;
    String department;

    // Constructor
    public Product(String sku, String name,
                   double price, String department) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }

    // Display product information
    public void displayProduct() {
        System.out.println(sku + " | " + name +
                " | $" + price + " | " + department);
    }
}

