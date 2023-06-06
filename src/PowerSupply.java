public class PowerSupply extends PCComponent{
    private PCComponent[][] compatibleComponents;
    //The type of the power supply (form factor)
    private String type;
    //The efficiency rating of the power supply
    private String efficiencyRating;
    //The wattage of the power supply in watts
    private int wattage;
    //The length of the power supply in mm
    private int length;
    //The modularity of the power supply
    private String modularity;
    //The color of the power supply
    private String color;
    //Is the power supply fanless
    private boolean fanless;
    //How many ATX 4 pin connectors does the power supply have
    private int ATX4PinConnectors;
    //How many EPS 8 pin connectors does the power supply have
    private int EPS8PinConnectors;
    //How many PCIe 12+4 pin 12V HPWR connectors does the power supply have
    private int PCIe_12_4_Pin12VHPWRConnectors;
    //How many PCIe 12 pin connectors does the power supply have
    private int PCIe12PinConnectors;
    //How many PCIe 8 pin connectors does the power supply have
    private int PCIe8PinConnectors;
    //How many PCIe 6+2 pin connectors does the power supply have
    private int PCIe_6_2_PinConnectors;
    //How many PCIe 6 pin connectors does the power supply have
    private int PCIe6PinConnectors;
    //How many SATA connectors does the power supply have
    private int SATAConnectors;
    //How many molex 4 pin connectors does the power supply have
    private int molex4PinConnectors;

    /**
     * The default constructor of the PowerSupply object
     */
    public PowerSupply() {
        super();
        compatibleComponents = new PCComponent[0][0];
        type = "No type";
        efficiencyRating = "No efficiency rating";
        wattage = 0;
        length = 0;
        modularity = "No modularity";
        color = "No color";
        fanless = false;
        ATX4PinConnectors = 0;
        EPS8PinConnectors = 0;
        PCIe_12_4_Pin12VHPWRConnectors = 0;
        PCIe12PinConnectors = 0;
        PCIe8PinConnectors = 0;
        PCIe_6_2_PinConnectors = 0;
        PCIe6PinConnectors = 0;
        SATAConnectors = 0;
        molex4PinConnectors = 0;
    }

    /**
     * The overloaded constructor of the PowerSupply object
     * @param manufacturer
     * @param partNumber
     * @param name
     * @param price
     * @param typeN
     * @param efficiencyRatingN
     * @param wattageN
     * @param lengthN
     * @param modularityN
     * @param colorN
     * @param fanlessN
     * @param ATX4PinConnectorsN
     * @param EPS8PinConnectorsN
     * @param PCIe_12_4_Pin12VHPWRConnectorsN
     * @param PCIe12PinConnectorsN
     * @param PCIe8PinConnectorsN
     * @param PCIe_6_2_PinConnectorsN
     * @param PCIe6PinConnectorsN
     * @param SATAConnectorsN
     * @param molex4PinConnectorsN
     */
    public PowerSupply(
            PCComponent[][] compatibleComponentsN,
            String manufacturer,
            String partNumber,
            String name,
            double price,
            String typeN,
            String efficiencyRatingN,
            int wattageN,
            int lengthN,
            String modularityN,
            String colorN,
            boolean fanlessN,
            int ATX4PinConnectorsN,
            int EPS8PinConnectorsN,
            int PCIe_12_4_Pin12VHPWRConnectorsN,
            int PCIe12PinConnectorsN,
            int PCIe8PinConnectorsN,
            int PCIe_6_2_PinConnectorsN,
            int PCIe6PinConnectorsN,
            int SATAConnectorsN,
            int molex4PinConnectorsN) {
        super(manufacturer, partNumber, name, price);
        compatibleComponents = compatibleComponentsN;
        type = typeN;
        efficiencyRating = efficiencyRatingN;
        wattage = wattageN;
        length = lengthN;
        modularity = modularityN;
        color = colorN;
        fanless = fanlessN;
        ATX4PinConnectors = ATX4PinConnectorsN;
        EPS8PinConnectors = EPS8PinConnectorsN;
        PCIe_12_4_Pin12VHPWRConnectors = PCIe_12_4_Pin12VHPWRConnectorsN;
        PCIe12PinConnectors = PCIe12PinConnectorsN;
        PCIe8PinConnectors = PCIe8PinConnectorsN;
        PCIe_6_2_PinConnectors = PCIe_6_2_PinConnectorsN;
        PCIe6PinConnectors = PCIe6PinConnectorsN;
        SATAConnectors = SATAConnectorsN;
        molex4PinConnectors = molex4PinConnectorsN;
    }

    /**
     * The info of the PowerSupply object
     * @return
     * String with the info of the PowerSupply object
     */
    public String toString() {
        return super.toString() + String.format("""
                        
                        Type: %s
                        Efficiency Rating: %s
                        Wattage: %dW
                        Length: %dmm
                        Modularity: %s
                        Color: %s
                        Fanless: %b
                        ATX 4 Pin Connectors: %d
                        EPS 8 Pin Connectors: %d
                        PCIe 12+4 Pin 12V HPWR Connectors: %d
                        PCIe 12 Pin Connectors: %d
                        PCIe 8 Pin Connectors: %d
                        PCIe 6+2 Pin Connectors: %d
                        PCIe 6 Pin Connectors: %d
                        SATA Connectors: %d
                        Molex 4 Pin Connectors: %d
                        """,
                type,
                efficiencyRating,
                wattage,
                length,
                modularity,
                color,
                fanless,
                ATX4PinConnectors,
                EPS8PinConnectors,
                PCIe_12_4_Pin12VHPWRConnectors,
                PCIe12PinConnectors,
                PCIe8PinConnectors,
                PCIe_6_2_PinConnectors,
                PCIe6PinConnectors,
                SATAConnectors,
                molex4PinConnectors
        );
    }
}
