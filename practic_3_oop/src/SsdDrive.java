public class SsdDrive implements ConfigurableItem {
    private String capacity;
    private String brand;
    private double price;

    public SsdDrive(String capacity, String brand, double price) {
        this.capacity = capacity;
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return capacity + " " + brand;
    }
}
