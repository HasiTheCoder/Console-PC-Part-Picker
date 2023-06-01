/**
 * Motherboard Object. Holds all the possible attributes of a motherboard
 *
 * @Author Hasnain Heryani
 */
public class Motherboard extends PCComponent{
    //AMD vs. Intel Socket and which gen socket
    String socketType;
    //AMD vs. Intel chipset
    String chipSet;
    //Form factor of motherboard, ATX, mATX, ITX, etc.
    String formFactor;
    //The number of memory slots the motherboard has
    int memorySlots;
    //Type of memory
    String memoryType;
    //Total amount of memory the motherboard supports in GB
    int memoryMax;
    //Max memory speed the motherboard supports in MHz
    int maxMemorySpeed;
    int PCIe_x16_Slots;
    //Number of PCIe x8 slots
    int PCIe_x8_Slots;
    //Number of PCIe x4 slots
    int PCIe_x4_Slots;
    //Number of PCIe x1 slots
    int PCIe_x1_Slots;
    //Number of PCI slots
    int PCI_Slots;
    //color of motherboard
    String color;
    //Whether the motherboard support SLI or CrossFire (True if supports one, false if it supports none)
    boolean isSLIOrCrossFire;
    //Number of SATA connectors
    int SATAConnectors;
    //Number of M.2 SSD Slots
    int M2_Slots;
    //Number of mini PCIe Slots
    int miniPCIeSlots;
    //Number of half mini PCIe slots
    int halfMiniPCIeSlots;
    //Number of mSATA slots
    int mSATASlots;
    //What are the details of the onboard ethernet of the motherboard
    String onboardEthernet;
    //Amount of USB 2.0 Headers
    int USB_2_Headers;
    //Amount of single port USB 2.0 Headers
    int USB_2_Headers_Single_Port;
    //Amount of USB 3.2 Gen 1 Headers
    int USB_32_1_Headers;
    //Amount of USB 3.2 Gen 2 Headers
    int USB_32_2_Headers;
    //Amount of USB 3.2 Gen 2x2 Headers
    int USB_32_2x2_Headers;
    //Does the motherboard support ECC (Error Correcting Code)
    boolean isECC;
    //What is the wireless networking on the motherboard
    String wirelessNetworking;
    //does it support RAID (Redundant Array of Independent Disks)
    boolean RAIDSupport;

    /**
     * Motherboard object base constructor
     * no parameters
     */
    public Motherboard() {
        name = "No name";
        price = 0;
        partNumber = "No part number";
        socketType = "No Socket";
        chipSet = "No Chipset";
        formFactor = "No Form Factor";
        memorySlots = 0;
        SATAConnectors = 0;
        manufacturer = "No Manufacturer";
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
    public Motherboard(String nameN, String partNumberN, double priceN, String socketTypeN, String chipSetN, String formFactorN, int memorySlotsN, int SATAConnectorsN, String manufacturerN, String memoryTypeN, int PCI_SlotsN, String colorN, int memoryMaxN, int maxMemorySpeedN, int PCIe_x16_SlotsN, int PCIe_x8_SlotsN, int PCIe_x4_SlotsN, int PCIe_x1_SlotsN, boolean isSLIOrCrossFireN, int M2_SlotsN, int miniPCIeSlotsN, int halfMiniPCIeSlotsN, int mSATASlotsN, String onboardEthernetN, int USB_2_HeadersN, int USB_32_1_HeadersN, int USB_2_Headers_Single_PortN, int USB_32_2_HeadersN, int USB_32_2x2_HeadersN, boolean isECCN, String wirelessNetworkingN, boolean RAIDSupportN) {
        name = nameN;
        partNumber = partNumberN;
        price = priceN;
        socketType = socketTypeN;
        chipSet = chipSetN;
        formFactor = formFactorN;
        memorySlots = memorySlotsN;
        SATAConnectors = SATAConnectorsN;
        manufacturer = manufacturerN;
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
        return String.format("""
                        Manufacturer: %s
                        Name: %s
                        Part Number: %s
                        Price: %s
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
                manufacturer,
                name,
                partNumber,
                price,
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
