public class PowerSupply extends PCComponent{
    private String type;
    private String efficiencyRating;
    private int wattage;
    private int length;
    private String modularity;
    private String color;
    private boolean fanless;
    private int ATX4PinConnectors;
    private int EPS8PinConnectors;
    private int PCIe_12_4_Pin12VHPWRConnectors;
    private int PCIe12PinConnectors;
    private int PCIe8PinConnectors;
    private int PCIe_6_2_PinConnectors;
    private int PCIe6PinConnectors;
    private int SATAConnectors;
    private int molex4PinConnectors;
    public PowerSupply() {
        super();
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
    public PowerSupply(String manufacturer, String partNumber, String name, double price, String typeN, String efficiencyRatingN, int wattageN, int lengthN, String modularityN, String colorN, boolean fanlessN, int ATX4PinConnectorsN, int EPS8PinConnectorsN, int PCIe_12_4_Pin12VHPWRConnectorsN, int PCIe12PinConnectorsN, int PCIe8PinConnectorsN, int PCIe_6_2_PinConnectorsN, int PCIe6PinConnectorsN, int SATAConnectorsN, int molex4PinConnectorsN) {

    }
}
