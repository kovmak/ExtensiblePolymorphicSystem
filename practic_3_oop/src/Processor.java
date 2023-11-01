public class Processor implements ConfigurableItem {
    private ProcessorType type;
    private String model;
    private double speed;
    private double price;

    public Processor(ProcessorType type, String model, double speed, double price) {
        this.type = type;
        this.model = model;
        this.speed = speed;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return type + " " + model + " - Speed: " + speed + " GHz";
    }
}


