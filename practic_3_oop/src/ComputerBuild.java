import java.util.ArrayList;
import java.util.List;

public class ComputerBuild {
    private List<ConfigurableItem> components = new ArrayList<>();

    public void addComponent(ConfigurableItem component) {
        components.add(component);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (ConfigurableItem component : components) {
            totalPrice += component.getPrice();
        }
        return totalPrice;
    }

    public void displayConfiguration() {
        System.out.println("Конфігурація ПК:");
        for (int i = 0; i < components.size(); i++) {
            System.out.println((i + 1) + ". " + components.get(i).getDescription() + " - Ціна: $" + components.get(i).getPrice());
        }
    }
}
