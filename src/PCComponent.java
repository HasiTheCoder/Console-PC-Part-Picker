import java.text.NumberFormat;

public class PCComponent {
    //The part number of the component
    String partNumber;
    //The name of the component
    String name;
    //The price of the component
    double price;
    //The manufacturer of the component
    String manufacturer;

    /**
     * The default constructor of the PCComponent object
     */
    public PCComponent() {
        manufacturer = "No manufacturer";
        partNumber = "No Part number";
        name = "No name";
        price = 0;
    }

    /**
     * The overloaded constructor of the PCComponent object
     * @param manufacturerN
     * @param partNumberN
     * @param nameN
     * @param priceN
     */
    public PCComponent(String manufacturerN, String partNumberN, String nameN, double priceN) {
        manufacturer = manufacturerN;
        partNumber = partNumberN;
        name = nameN;
        price = priceN;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    /**
     * The info of the PCComponent object
     * @return
     * String of the info of the PCComponent object
     */
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return String.format("""
                Manufacturer: %s
                Name: %s
                Part Number: %s
                Price: %s
                """, manufacturer,
                name,
                partNumber,
                price);
    }

    public String getType() {
        if (this instanceof Motherboard) {
            return "Motherboard";
        }
        else if (this instanceof CPU) {
            return "CPU";
        }
        else if (this instanceof CPUCooler) {
            return "CPU Cooler";
        }
        else if (this instanceof GPU) {
            return "GPU";
        }
        else if (this instanceof MemoryKits) {
            return "Memory Kit";
        }
        else if (this instanceof Storage) {
            return "Storage";
        }
        else if (this instanceof Case) {
            return "Case";
        }
        else if (this instanceof CaseFans) {
            return "Case Fan";
        }
        else if (this instanceof PowerSupply) {
            return "Power Supply";
        }
        else {
            return "No type";
        }
    }
}
