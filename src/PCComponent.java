import java.text.NumberFormat;

public abstract class PCComponent {
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
}
