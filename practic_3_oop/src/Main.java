import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public enum ComponentType {
        PROCESSOR,
        MOTHERBOARD,
        GRAPHICS_CARD,
        POWER_SUPPLY,
        SSD_DRIVE,
        SOUND_CARD
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Виберіть тип збірки (1 - Default або 2 - Full): ");
        String buildType = scanner.nextLine();

        if (buildType.equals("1")) {
            createBasicBuild();
        } else if (buildType.equals("2")) {
            createFullBuild();
        } else {
            System.out.println("Неправильний вибір. Завершення програми.");
        }
    }

    private static void createFullBuild() {
        List<Processor> processors = new ArrayList<>();
        List<Motherboard> motherboards = new ArrayList<>();
        List<GraphicsCard> graphicsCards = new ArrayList<>();
        List<PowerSupply> powerSupplies = new ArrayList<>();
        List<SsdDrive> ssdDrives = new ArrayList<>();
        List<SoundCard> soundCards = new ArrayList<>();

        // Додавання доступних компонентів для повної збірки
        processors.add(new Processor(ProcessorType.AMD, "Ryzen 7", 3.5, 300.0));
        processors.add(new Processor(ProcessorType.Intel, "Core i7", 4.0, 350.0));
        processors.add(new Processor(ProcessorType.AMD, "Ryzen 5", 3.0, 200.0));

        motherboards.add(new Motherboard("ATX", "ASUS", 150.0));
        motherboards.add(new Motherboard("Micro ATX", "Gigabyte", 120.0));
        motherboards.add(new Motherboard("Mini ITX", "MSI", 100.0));

        graphicsCards.add(new GraphicsCard("NVIDIA", "GTX 1660", 300.0));
        graphicsCards.add(new GraphicsCard("AMD", "RX 5700", 350.0));
        graphicsCards.add(new GraphicsCard("NVIDIA", "RTX 3060", 400.0));

        powerSupplies.add(new PowerSupply("550W", "EVGA", 60.0));
        powerSupplies.add(new PowerSupply("650W", "Corsair", 80.0));
        powerSupplies.add(new PowerSupply("750W", "Seasonic", 100.0));

        ssdDrives.add(new SsdDrive("500GB", "Samsung", 80.0));
        ssdDrives.add(new SsdDrive("1TB", "Crucial", 100.0));
        ssdDrives.add(new SsdDrive("2TB", "Western Digital", 180.0));

        soundCards.add(new SoundCard("5.1", "Creative", 50.0));
        soundCards.add(new SoundCard("7.1", "ASUS", 70.0));
        soundCards.add(new SoundCard("2.1", "Logitech", 40.0));

        createBuild(processors, motherboards, graphicsCards, powerSupplies, ssdDrives, soundCards);
    }

    private static void createBasicBuild() {
        List<Processor> processors = new ArrayList<>();
        List<Motherboard> motherboards = new ArrayList<>();
        List<GraphicsCard> graphicsCards = new ArrayList<>();

        // Додавання доступних компонентів для 100% збірки
        processors.add(new Processor(ProcessorType.AMD, "Ryzen 7", 3.5, 300.0));
        processors.add(new Processor(ProcessorType.Intel, "Core i7", 4.0, 350.0));
        processors.add(new Processor(ProcessorType.AMD, "Ryzen 5", 3.0, 200.0));

        motherboards.add(new Motherboard("ATX", "ASUS", 150.0));
        motherboards.add(new Motherboard("Micro ATX", "Gigabyte", 120.0));
        motherboards.add(new Motherboard("Mini ITX", "MSI", 100.0));

        graphicsCards.add(new GraphicsCard("NVIDIA", "GTX 1660", 300.0));
        graphicsCards.add(new GraphicsCard("AMD", "RX 5700", 350.0));
        graphicsCards.add(new GraphicsCard("NVIDIA", "RTX 3060", 400.0));

        createBuildDefault(processors, motherboards, graphicsCards, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    private static void createBuild(List<Processor> processors, List<Motherboard> motherboards, List<GraphicsCard> graphicsCards,
                                    List<PowerSupply> powerSupplies, List<SsdDrive> ssdDrives, List<SoundCard> soundCards) {
        ComputerBuild build = new ComputerBuild();

        for (ComponentType type : ComponentType.values()) {
            displayComponents(type, processors, motherboards, graphicsCards, powerSupplies, ssdDrives, soundCards);
            int choice = getUserChoice(type);

            if (choice >= 0) {
                switch (type) {
                    case PROCESSOR:
                        build.addComponent(processors.get(choice - 1));
                        break;
                    case MOTHERBOARD:
                        build.addComponent(motherboards.get(choice - 1));
                        break;
                    case GRAPHICS_CARD:
                        build.addComponent(graphicsCards.get(choice - 1));
                        break;
                    case POWER_SUPPLY:
                        build.addComponent(powerSupplies.get(choice - 1));
                        break;
                    case SSD_DRIVE:
                        build.addComponent(ssdDrives.get(choice - 1));
                        break;
                    case SOUND_CARD:
                        build.addComponent(soundCards.get(choice - 1));
                        break;
                }
            }
        }

        double totalBuildPrice = build.calculateTotalPrice();

        System.out.println("\nВаша обрана конфігурація ПК:");
        build.displayConfiguration();
        System.out.println("Загальна сума: $" + totalBuildPrice);
    }

    private static void createBuildDefault(List<Processor> processors, List<Motherboard> motherboards, List<GraphicsCard> graphicsCards,
                                           List<PowerSupply> powerSupplies, List<SsdDrive> ssdDrives, List<SoundCard> soundCards) {
        ComputerBuild build = new ComputerBuild();

        for (ComponentType type : ComponentType.values()) {
            if (type == ComponentType.PROCESSOR || type == ComponentType.MOTHERBOARD || type == ComponentType.GRAPHICS_CARD) {
                displayComponents(type, processors, motherboards, graphicsCards, powerSupplies, ssdDrives, soundCards);
                int choice = getUserChoice(type);
                switch (type) {
                    case PROCESSOR:
                        build.addComponent(processors.get(choice - 1));
                        break;
                    case MOTHERBOARD:
                        build.addComponent(motherboards.get(choice - 1));
                        break;
                    case GRAPHICS_CARD:
                        build.addComponent(graphicsCards.get(choice - 1));
                        break;
                }
            }
        }

        double totalBuildPrice = build.calculateTotalPrice();

        System.out.println("\nВаша обрана конфігурація ПК:");
        build.displayConfiguration();
        System.out.println("Загальна сума: $" + totalBuildPrice);
    }

    private static void displayComponents(ComponentType type, List<Processor> processors, List<Motherboard> motherboards, List<GraphicsCard> graphicsCards,
                                          List<PowerSupply> powerSupplies, List<SsdDrive> ssdDrives, List<SoundCard> soundCards) {
        System.out.println("Доступні " + type.toString() + " компоненти:");
        List<? extends ConfigurableItem> components = getComponentsByType(type, processors, motherboards, graphicsCards, powerSupplies, ssdDrives, soundCards);

        for (int i = 0; i < components.size(); i++) {
            System.out.println((i + 1) + ". " + components.get(i).getDescription() + " - Ціна: $" + components.get(i).getPrice());
        }
    }

    private static List<? extends ConfigurableItem> getComponentsByType(ComponentType type, List<Processor> processors, List<Motherboard> motherboards, List<GraphicsCard> graphicsCards,
                                                                        List<PowerSupply> powerSupplies, List<SsdDrive> ssdDrives, List<SoundCard> soundCards) {
        switch (type) {
            case PROCESSOR:
                return processors;
            case MOTHERBOARD:
                return motherboards;
            case GRAPHICS_CARD:
                return graphicsCards;
            case POWER_SUPPLY:
                return powerSupplies;
            case SSD_DRIVE:
                return ssdDrives;
            case SOUND_CARD:
                return soundCards;
            default:
                return new ArrayList<>();
        }
    }

    private static int getUserChoice(ComponentType type) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Оберіть компонент " + type.toString() + " або введіть '0' для завершення: ");
        int choice = scanner.nextInt();
        if (choice == 0) {
            return -1; // Skip this component type
        } else if (choice >= 1 && choice <= 3) {
            return choice;
        } else {
            System.out.println("Неправильний вибір. Спробуйте ще раз.");
            return getUserChoice(type);
        }
    }
}
