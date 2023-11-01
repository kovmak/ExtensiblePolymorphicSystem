public class Motherboard implements ConfigurableItem {
    private String model;
    private String brand;
    private double price;

    public Motherboard(String model, String brand, double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return brand + " " + model;
    }
}
