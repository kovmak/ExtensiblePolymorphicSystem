public class GraphicsCard implements ConfigurableItem {
    private String manufacturer;
    private String model;
    private double price;

    public GraphicsCard(String manufacturer, String model, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return manufacturer + " " + model;
    }
}
