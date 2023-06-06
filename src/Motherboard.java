/**
 * Motherboard Object. Holds all the possible attributes of a motherboard
 *
 * @Author Hasnain Heryani
 */
public class Motherboard extends PCComponent{
    private String[][] compatibleComponents;
    //AMD vs. Intel Socket and which gen socket
    private String socketType;
    //AMD vs. Intel chipset
    private String chipSet;
    //Form factor of motherboard, ATX, mATX, ITX, etc.
    private String formFactor;
    //The number of memory slots the motherboard has
    private int memorySlots;
    //Type of memory
    private String memoryType;
    //Total amount of memory the motherboard supports in GB
    private int memoryMax;
    //Max memory speed the motherboard supports in MHz
    private int maxMemorySpeed;
    private int PCIe_x16_Slots;
    //Number of PCIe x8 slots
    private int PCIe_x8_Slots;
    //Number of PCIe x4 slots
    private int PCIe_x4_Slots;
    //Number of PCIe x1 slots
    private int PCIe_x1_Slots;
    //Number of PCI slots
    private int PCI_Slots;
    //color of motherboard
    private String color;
    //Whether the motherboard support SLI or CrossFire (True if supports one, false if it supports none)
    private boolean isSLIOrCrossFire;
    //Number of SATA connectors
    private int SATAConnectors;
    //Number of M.2 SSD Slots
    private int M2_Slots;
    //Number of mini PCIe Slots
    private int miniPCIeSlots;
    //Number of half mini PCIe slots
    private int halfMiniPCIeSlots;
    //Number of mSATA slots
    private int mSATASlots;
    //What are the details of the onboard ethernet of the motherboard
    private String onboardEthernet;
    //Amount of USB 2.0 Headers
    private int USB_2_Headers;
    //Amount of single port USB 2.0 Headers
    private int USB_2_Headers_Single_Port;
    //Amount of USB 3.2 Gen 1 Headers
    private int USB_32_1_Headers;
    //Amount of USB 3.2 Gen 2 Headers
    private int USB_32_2_Headers;
    //Amount of USB 3.2 Gen 2x2 Headers
    private int USB_32_2x2_Headers;
    //Does the motherboard support ECC (Error Correcting Code)
    private boolean isECC;
    //What is the wireless networking on the motherboard
    private String wirelessNetworking;
    //does it support RAID (Redundant Array of Independent Disks)
    private boolean RAIDSupport;

    /**
     * Motherboard object base constructor
     * no parameters
     */
    public Motherboard() {
        super();
        compatibleComponents = new String[0][0];
        socketType = "No Socket";
        chipSet = "No Chipset";
        formFactor = "No Form Factor";
        memorySlots = 0;
        SATAConnectors = 0;
        memoryType = "No Memory Type";
        memoryMax = 0;
        maxMemorySpeed = 0;
        PCIe_x16_Slots = 0;
        PCIe_x8_Slots = 0;
        PCIe_x4_Slots = 0;
        PCIe_x1_Slots = 0;
        PCI_Slots = 0;
        color = "No color";
        isSLIOrCrossFire = false;
        M2_Slots = 0;
        miniPCIeSlots = 0;
        halfMiniPCIeSlots = 0;
        mSATASlots = 0;
        onboardEthernet = "No ethernet";
        USB_2_Headers = 0;
        USB_32_1_Headers = 0;
        USB_2_Headers_Single_Port = 0;
        USB_32_2_Headers = 0;
        USB_32_2x2_Headers = 0;
        isECC = false;
        wirelessNetworking = "No wireless networking";
        RAIDSupport = false;
    }

    /**
     * Overloaded constructor of the Motherboard class
     * @param compatibleComponentsN
     * @param nameN
     * @param partNumberN
     * @param priceN
     * @param socketTypeN
     * @param chipSetN
     * @param formFactorN
     * @param memorySlotsN
     * @param SATAConnectorsN
     * @param manufacturerN
     * @param memoryTypeN
     * @param PCI_SlotsN
     * @param colorN
     * @param memoryMaxN
     * @param maxMemorySpeedN
     * @param PCIe_x16_SlotsN
     * @param PCIe_x8_SlotsN
     * @param PCIe_x4_SlotsN
     * @param PCIe_x1_SlotsN
     * @param isSLIOrCrossFireN
     * @param M2_SlotsN
     * @param miniPCIeSlotsN
     * @param halfMiniPCIeSlotsN
     * @param mSATASlotsN
     * @param onboardEthernetN
     * @param USB_2_HeadersN
     * @param USB_32_1_HeadersN
     * @param USB_2_Headers_Single_PortN
     * @param USB_32_2_HeadersN
     * @param USB_32_2x2_HeadersN
     * @param isECCN
     * @param wirelessNetworkingN
     * @param RAIDSupportN
     */
    public Motherboard(
            String[][] compatibleComponentsN,
            String nameN,
            String partNumberN,
            double priceN,
            String socketTypeN,
            String chipSetN,
            String formFactorN,
            int memorySlotsN,
            int SATAConnectorsN,
            String manufacturerN,
            String memoryTypeN,
            int PCI_SlotsN,
            String colorN,
            int memoryMaxN,
            int maxMemorySpeedN,
            int PCIe_x16_SlotsN,
            int PCIe_x8_SlotsN,
            int PCIe_x4_SlotsN,
            int PCIe_x1_SlotsN,
            boolean isSLIOrCrossFireN,
            int M2_SlotsN,
            int miniPCIeSlotsN,
            int halfMiniPCIeSlotsN,
            int mSATASlotsN,
            String onboardEthernetN,
            int USB_2_HeadersN,
            int USB_32_1_HeadersN,
            int USB_2_Headers_Single_PortN,
            int USB_32_2_HeadersN,
            int USB_32_2x2_HeadersN,
            boolean isECCN,
            String wirelessNetworkingN,
            boolean RAIDSupportN
    ) {
        super(manufacturerN, partNumberN, nameN, priceN);
        compatibleComponents = compatibleComponentsN;
        socketType = socketTypeN;
        chipSet = chipSetN;
        formFactor = formFactorN;
        memorySlots = memorySlotsN;
        SATAConnectors = SATAConnectorsN;
        memoryType = memoryTypeN;
        memoryMax = memoryMaxN;
        maxMemorySpeed = maxMemorySpeedN;
        PCIe_x16_Slots = PCIe_x16_SlotsN;
        PCIe_x8_Slots = PCIe_x8_SlotsN;
        PCIe_x4_Slots = PCIe_x4_SlotsN;
        PCIe_x1_Slots = PCIe_x1_SlotsN;
        PCI_Slots = PCI_SlotsN;
        color = colorN;
        isSLIOrCrossFire = isSLIOrCrossFireN;
        M2_Slots = M2_SlotsN;
        miniPCIeSlots = miniPCIeSlotsN;
        halfMiniPCIeSlots = halfMiniPCIeSlotsN;
        mSATASlots = mSATASlotsN;
        onboardEthernet = onboardEthernetN;
        USB_2_Headers = USB_2_HeadersN;
        USB_32_1_Headers = USB_32_1_HeadersN;
        USB_2_Headers_Single_Port = USB_2_Headers_Single_PortN;
        USB_32_2_Headers = USB_32_2_HeadersN;
        USB_32_2x2_Headers = USB_32_2x2_HeadersN;
        isECC = isECCN;
        wirelessNetworking = wirelessNetworkingN;
        RAIDSupport = RAIDSupportN;
    }

    /**
     * Details of the specific motherboard
     * @return a string with the details
     */
    public String toString() {
        return super.toString() + String.format("""
                        
                        Color: %s
                        Socket Type: %s
                        Chip Set: %s
                        Form Factor: %s
                        Memory Slots: %s
                        Memory Type: %s
                        Max Memory: %s
                        Max Memory Speed: %s
                        PCIe x16 Slots: %s
                        PCIe x8 Slots: %s
                        PCIe x4 Slots: %s
                        PCIe x1 Slots: %s
                        PCI Slots: %s
                        SLI/CrossFire Support: %s
                        SATA Connectors: %s
                        M.2 Slots: %s
                        Mini PCIe Slots: %s
                        Half Mini PCIe Slots: %s
                        mSATA Slots: %s
                        Onboard Ethernet: %s
                        USB 2.0 Headers: %s
                        USB 2.0 Headers (Single Port): %s
                        USB 3.2 Gen 1 Headers: %s
                        USB 3.2 Gen 2 Headers: %s
                        USB 3.2 Gen 2x2 Headers: %s
                        ECC Support: %s
                        Wireless Networking: %s
                        Raid Support: %s
                        
                        """,
                color,
                socketType,
                chipSet,
                formFactor,
                memorySlots,
                memoryType,
                memoryMax,
                maxMemorySpeed,
                PCIe_x16_Slots,
                PCIe_x8_Slots,
                PCIe_x4_Slots,
                PCIe_x1_Slots,
                PCI_Slots,
                isSLIOrCrossFire,
                SATAConnectors,
                M2_Slots,
                miniPCIeSlots,
                halfMiniPCIeSlots,
                mSATASlots,
                onboardEthernet,
                USB_2_Headers,
                USB_2_Headers_Single_Port,
                USB_32_1_Headers,
                USB_32_2_Headers,
                USB_32_2x2_Headers,
                isECC,
                wirelessNetworking,
                RAIDSupport);
    }
}
