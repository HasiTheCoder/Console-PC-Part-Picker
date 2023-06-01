public abstract class PCComponent {
    String partNumber;
    String name;
    double price;
    String manufacturer;
    public PCComponent() {
        manufacturer = "No manufacturer";
        partNumber = "No Part number";
        name = "No name";
        price = 0;
    }
    public PCComponent(String manufacturerN, String partNumberN, String nameN, double priceN) {
        manufacturer = manufacturerN;
        partNumber = partNumberN;
        name = nameN;
        price = priceN;
    }
}
