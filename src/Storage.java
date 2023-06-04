import java.text.NumberFormat;
public class Storage extends PCComponent {
    //The capacity of the storage
    private String capacity;
    //The price per GB of the storage
    private String pricePerGB;
    //The type of the storage
    private String type;
    //The cache of the storage in MB
    private int cache;
    //The form factor of the storage
    private String formFactor;
    //The interface type of the storage
    private String interfaceType;
    //Is the storage NVMe
    private boolean isNVMe;

    /**
     * The default constructor of the Storage Object
     */
    public Storage() {
        super();
        capacity = "No capacity";
        pricePerGB = "No price per GB";
        type = "No type";
        cache = 0;
        formFactor = "No form factor";
        interfaceType = "No interface type";
        isNVMe = false;
    }

    /**
     * The overloaded constructor of the Storage object
     * @param manufacturer
     * @param name
     * @param partNumber
     * @param price
     * @param capacityN
     * @param pricePerGBN
     * @param typeN
     * @param cacheN
     * @param formFactorN
     * @param interfaceTypeN
     * @param isNVMeN
     */
    public Storage(
        String manufacturer,
        String name,
        String partNumber,
        double price,
        String capacityN,
        String pricePerGBN,
        String typeN,
        int cacheN,
        String formFactorN,
        String interfaceTypeN,
        boolean isNVMeN
    ) {
        super(manufacturer, name, partNumber, price);
        capacity = capacityN;
        pricePerGB = pricePerGBN;
        type = typeN;
        cache = cacheN;
        formFactor = formFactorN;
        interfaceType = interfaceTypeN;
        isNVMe = isNVMeN;
    }

    /**
     * The info of the Storage object
     * @return String with the info of the Storage object
     */
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return String.format("""
                        Manufacturer: %s
                        Name: %s
                        Part Number: %s
                        Price: %s
                        Capacity: %s
                        Price/GB: %s
                        Type: %s
                        Cache(MB): %s
                        Form Factor: %s
                        Interface Type: %s
                        NVMe: %s
                        """,
                manufacturer,
                name,
                partNumber,
                money.format(price),
                capacity,
                pricePerGB,
                type,
                cache,
                formFactor,
                interfaceType,
                isNVMe
                );
    }
}
