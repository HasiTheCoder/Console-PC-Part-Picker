public class Case extends PCComponent{
    private String[][] compatibleComponents;
    //What is the form factor of the case
    private String type;
    //What is the color of the case
    private String color;
    //Does it include a power supply
    private boolean includesPowerSupply;
    //What type of side panel does the case have
    private String sidePanel;
    //Does it include a power supply shroud
    private boolean includePowerSupplyShroud;
    //What type of front panel USB does the case have
    private String frontPanelUSB;
    //What form factors does the case support from motherboards
    private String[] motherboardFormFactor;
    //The longest video card(GPU) will fit inside the case in mm
    private double maximumVideoCardLength_mm;
    //The longest video card(GPU) will fit inside the case in inches
    private double MaximumVideoCardLengthInches;
    //What types of drive bays does the case have and how many of each
    private String[] driveBays;
    //What types of expansion slots does the case have and how many of each
    private String[] expansionSlots;
    //The dimensions of the case in mm
    private String dimensions_mm;
    //The dimensions of the case in inches
    private String dimensionsInches;
    //The volume of the case in L
    private double volumeL;
    //The volume of the case in ft^3
    private double volumeFt3;

    /**
     * The default constructor of the Case object
     */
    public Case() {
        super();
        compatibleComponents = new String[0][0];
        type = "No type";
        color = "No color";
        includesPowerSupply = false;
        sidePanel = "No side panel";
        includePowerSupplyShroud = false;
        frontPanelUSB = "No front panel USB";
        motherboardFormFactor = new String[0];
        maximumVideoCardLength_mm = 0;
        MaximumVideoCardLengthInches = 0;
        driveBays = new String[0];
        expansionSlots = new String[0];
        dimensions_mm = "No dimensions";
        dimensionsInches = "No dimensions";
        volumeL = 0;
        volumeFt3 = 0;
    }

    /**
     * The overloaded constructor of the Case object
     * @param name
     * @param manufacturer
     * @param partNumber
     * @param price
     * @param typeN
     * @param colorN
     * @param includesPowerSupplyN
     * @param sidePanelN
     * @param includePowerSupplyShroudN
     * @param frontPanelUSBN
     * @param motherboardFormFactorN
     * @param maximumVideoCardLength_mmN
     * @param MaximumVideoCardLengthInchesN
     * @param driveBaysN
     * @param expansionSlotsN
     * @param dimensions_mmN
     * @param dimensionsInchesN
     * @param volumeLN
     * @param volumeFt3N
     */
    public Case(
            String[][] compatibleComponentsN,
            String name,
            String manufacturer,
            String partNumber,
            double price,
            String typeN,
            String colorN,
            boolean includesPowerSupplyN,
            String sidePanelN,
            boolean includePowerSupplyShroudN,
            String frontPanelUSBN,
            String[] motherboardFormFactorN,
            double maximumVideoCardLength_mmN,
            double MaximumVideoCardLengthInchesN,
            String[] driveBaysN,
            String[] expansionSlotsN,
            String dimensions_mmN,
            String dimensionsInchesN,
            double volumeLN,
            double volumeFt3N
            ) {
        super(name, manufacturer, partNumber, price);
        compatibleComponents = compatibleComponentsN;
        type = typeN;
        color = colorN;
        includesPowerSupply = includesPowerSupplyN;
        sidePanel = sidePanelN;
        includePowerSupplyShroud = includePowerSupplyShroudN;
        frontPanelUSB = frontPanelUSBN;
        motherboardFormFactor = motherboardFormFactorN;
        maximumVideoCardLength_mm = maximumVideoCardLength_mmN;
        MaximumVideoCardLengthInches = MaximumVideoCardLengthInchesN;
        driveBays = driveBaysN;
        expansionSlots = expansionSlotsN;
        dimensions_mm = dimensions_mmN;
        dimensionsInches = dimensionsInchesN;
        volumeL = volumeLN;
        volumeFt3 = volumeFt3N;
    }

    /**
     * The info of the Case object
     * @return
     * String with the info of the Case object
     */
    public String toString() {
        return super.toString() + String.format("""                
                        
                        Type: %s
                        Color: %s
                        Includes Power Supply: %s
                        Side Panel: %s
                        Includes Power Supply Shroud: %s
                        Front Panel USB: %s
                        Motherboard Form Factor: %s
                        Maximum Video Card Length (mm): %s
                        Maximum Video Card Length (inches): %s
                        Drive Bays: %s
                        Expansion Slots: %s
                        Dimensions (mm): %s
                        Dimensions (inches): %s
                        Volume (L): %s
                        Volume (ft^3): %s
                        """,
                type,
                color,
                includesPowerSupply,
                sidePanel,
                includePowerSupplyShroud,
                frontPanelUSB,
                convertArrayToString(motherboardFormFactor),
                maximumVideoCardLength_mm,
                MaximumVideoCardLengthInches,
                convertArrayToString(driveBays),
                convertArrayToString(expansionSlots),
                dimensions_mm,
                dimensionsInches,
                volumeL,
                volumeFt3
            );
    }
    private String convertArrayToString(String[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            result += "\n";
        }
        return result;
    }
}
