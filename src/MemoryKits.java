public class MemoryKits extends PCComponent{
    //The speed of the memory
    private String memorySpeed;
    //The form factor of the memory (Number of pins)
    private String formFactor;
    //How many modules of memory and the GB amount of each mondule
    private String modules;
    //The price of the memory per GB
    private double pricePerGB;
    //The color of the module
    private String color;
    //The first word latency in ns
    private int firstWordLatency;
    //The CAS latency
    private int CASLatency;
    //The voltage of the memory
    private double voltage;
    //The timing of the memory
    private String timing;
    //How is the ECC registered if it is there at all
    private String ECC_Registered;
    //Does the Memory have a heat spreader
    private boolean isHeatSpreader;

    /**
     * The default constructor of the MemoryKits Object
     */
    public MemoryKits() {
        super();
        memorySpeed = "No Speed";
        formFactor = "No form factor";
        modules = "No modules";
        pricePerGB = 0;
        color = "No color";
        firstWordLatency = 0;
        CASLatency = 0;
        voltage = 0;
        timing = "No timing";
        ECC_Registered = "Non-ECC/Unbuffered";
        isHeatSpreader = false;
    }

    /**
     * the overloaded constructor of the MemoryKits object
     * @param manufacturer
     * @param partNumber
     * @param name
     * @param price
     * @param memorySpeedN
     * @param formFactorN
     * @param modulesN
     * @param pricePerGBn
     * @param colorN
     * @param firstWordLatencyN
     * @param CASLatencyN
     * @param voltageN
     * @param timingN
     * @param ECC_RegisteredN
     * @param isHeatSpreaderN
     */
    public MemoryKits(
            String manufacturer,
            String partNumber,
            String name,
            double price,
            String memorySpeedN,
            String formFactorN,
            String modulesN,
            int pricePerGBn,
            String colorN,
            int firstWordLatencyN,
            int CASLatencyN,
            double voltageN,
            String timingN,
            String ECC_RegisteredN,
            boolean isHeatSpreaderN)
    {
        super(manufacturer, partNumber, name, price);
        memorySpeed = memorySpeedN;
        formFactor = formFactorN;
        modules = modulesN;
        pricePerGB = pricePerGBn;
        color = colorN;
        firstWordLatency = firstWordLatencyN;
        CASLatency = CASLatencyN;
        voltage = voltageN;
        timing = timingN;
        ECC_Registered = ECC_RegisteredN;
        isHeatSpreader = isHeatSpreaderN;
    }
}
