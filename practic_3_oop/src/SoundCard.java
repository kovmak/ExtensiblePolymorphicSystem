public class SoundCard implements ConfigurableItem {
    private String channels;
    private String brand;
    private double price;

    public SoundCard(String channels, String brand, double price) {
        this.channels = channels;
        this.brand = brand;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return channels + " " + brand;
    }
}
