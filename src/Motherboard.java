/**
 * Motherboard Object. Holds all the possible attributes of a motherboard
 *
 * @Author Hasnain Heryani
 */
public class Motherboard extends PCComponent{
    //All motherboards have power switch, power led, and drive led headers for the front panel
    //AMD vs. Intel Socket and which gen socket
    String socketType;
    //AMD vs. Intel chipset
    String chipSet;
    //Form factor of motherboard, ATX, mATX, ITX, etc.
    String formFactor;
    //Does the motherboard have front audio connectors
    boolean isAAFPConnector;
    //The number of memory slots the motherboard has
    int memorySlots;
    //Total amount of memory the motherboard supports in GB
    int totalMemoryAmount;
    //Max memory speed the motherboard supports in MHz
    int memorySpeed;
    //Is the memory overclock-able within the motherboard bios (Does XMP setting exist for Intel and AMD. DOCP/EXPO for AM5)
    boolean isMemoryOC;
    //Number of PCIe x16 gen 5 slots
    int PCIe_x16_5_Slots;
    //Number of PCIe x8 gen 5 slots
    int PCIe_x8_5_Slots;
    //Number of PCIe x4 gen 5 slots
    int PCIe_x4_5_Slots;
    //Number of PCIe x1 gen 5 slots
    int PCIe_x1_5_Slots;
    //Number of PCIe x16 gen 4 slots
    int PCIe_x16_4_Slots;
    //Number of PCIe x8 gen 4 slots
    int PCIe_x8_4_Slots;
    //Number of PCIe x4 gen 4 slots
    int PCIe_x4_4_Slots;
    //Number of PCIe x1 gen 4 slots
    int PCIe_x1_4_Slots;
    //Number of PCIe x16 gen 3 slots
    int PCIe_x16_3_Slots;
    //Number of PCIe x8 gen 3 slots
    int PCIe_x8_3_Slots;
    //Number of PCIe x4 gen 3 slots
    int PCIe_x4_3_Slots;
    //Number of PCIe x1 gen 3 slots
    int PCIe_x1_3_Slots;
    //Number of SATA connectors
    int SATAConnectors;
    //Number of M.2 SSD Slots Gen 5
    int M2_5_Slots;
    //Number of M.2 SSD Slots Gen 4
    int M2_4_Slots;
    //Number of M.2 SSD Slots Gen 3
    int M2_3_Slots;
    //Does the motherboard have a 24 pin power connector. If false then 20 pin (Some mITX motherboards tend to have 20 pin)
    boolean is24PinPowerConnectors;
    //For CPU Power one 4 pin or an 8 pin (8 pin power connectors are for higher power CPUs. Some motherboards only have 4 pin)
    boolean is4Pin;
    //What the rear io of the motherboard has
    String rearIO;
    //The number of fan headers a motherboard has (power for fans)
    int fanHeaders;
    //The number of addressable RBG headers
    int ARGBHeaders;
    //The number of RGB Headers
    int RGBHeaders;
    //Does the motherboard have an AIO Pump connector to be compatible with AIOs.
    boolean isAIOPumpConnector;
    //Other miscellaneous details about the motherboard not needed for compatibility checks.
    String other;
    //Front IO Headers
    //Amount of USB 3.2 Gen 2x2 (USB Type C, rarely USB Type A) headers
    int USB32_2x2_;
    //Amount of USB 3.1 Gen 2 headers
    int USB31_2_;
    //Amount of USB 3.1 Gen 1 (USB 3.0) headers
    int USB31_1_;
    //Amount of USB 2.0 headers
    int USB2;
    //Amount of thunderbolt headers
    int thunderbolt;

    /**
     * Motherboard object base constructor
     * no parameters
     */
    public Motherboard() {
        socketType = "No Socket";
        chipSet = "No Chipset";
        formFactor = "No Form Factor";
        memorySlots = 0;
        SATAConnectors = 0;
        is24PinPowerConnectors = false;
        is4Pin = false;
        isAAFPConnector = false;
        totalMemoryAmount = 0;
        memorySpeed = 0;
        isMemoryOC = false;
        PCIe_x16_5_Slots = 0;
        PCIe_x16_3_Slots = 0;
        PCIe_x1_3_Slots = 0;
        PCIe_x8_5_Slots = 0;
        PCIe_x4_5_Slots = 0;
        PCIe_x1_5_Slots = 0;
        PCIe_x16_4_Slots = 0;
        PCIe_x8_4_Slots = 0;
        PCIe_x4_4_Slots = 0;
        PCIe_x1_4_Slots = 0;
        PCIe_x8_3_Slots = 0;
        PCIe_x4_3_Slots = 0;
        M2_4_Slots = 0;
        M2_5_Slots = 0;
        M2_3_Slots = 0;
        rearIO = "No Rear IO";
        fanHeaders = 0;
        ARGBHeaders = 0;
        RGBHeaders = 0;
        isAIOPumpConnector = false;
        other = "No Other Specs";
        USB32_2x2_ = 0;
        USB31_1_ = 0;
        USB31_2_ = 0;
        USB2 = 0;
        thunderbolt = 0;
    }

    /**
     * Motherboard overloaded constructor
     *
     * @param socketTypeN
     * motherbaord socket type
     * @param chipSetN
     * motherboard chipset
     * @param formFactorN
     * motherboard form factor
     * @param memorySlotsN
     * motherboard memory slots count
     * @param SATAConnectorsN
     * motherboard sata connectors
     * @param is24PinPowerConnectorsN
     * motherboard either 24 pin or 20 pin (true for 24 false for 20)
     * @param is4PinN
     * motherboard either 4 pin or 8 pin (true for 4 false for 8)
     * @param isAAFPConnectorN
     * motherboard front audio
     * @param totalMemoryAmountN
     * motherboard total memory support
     * @param memorySpeedN
     * motherboard max memory speed support
     * @param isMemoryOCN
     * motherboard allows memory Overclocking
     * Amount of each type of slot:
     * @param PCIe_x16_5_SlotsN
     * @param PCIe_x8_5_SlotsN
     * @param PCIe_x4_5_SlotsN
     * @param PCIe_x1_5_SlotsN
     * @param PCIe_x16_4_SlotsN
     * @param PCIe_x8_4_SlotsN
     * @param PCIe_x4_4_SlotsN
     * @param PCIe_x1_4_SlotsN
     * @param PCIe_x16_3_SlotsN
     * @param PCIe_x8_3_SlotsN
     * @param PCIe_x4_3_SlotsN
     * @param PCIe_x1_3_SlotsN
     * @param M2_5_SlotsN
     * @param M2_4_SlotsN
     * @param M2_3_SlotsN
     * @param rearIO_N
     * Motherboard Rear IO
     * @param fanHeadersN
     * Motherboard fan headers
     * @param ARGBHeadersN
     * motherboard ARGB headers (Addressable RGB)
     * @param RGBHeadersN
     * motherboard RGB headers
     * @param isAIOPumpConnectorN
     * motherboard support for AIO
     * @param otherN
     * miscellaneous info about motherboard
     * amount of each type of usb (Thunderbolt included):
     * @param USB32_2x2_N
     * @param USB31_1_N
     * @param USB31_2_N
     * @param USB2N
     * @param thunderboltN
     */
    public Motherboard(String socketTypeN, String chipSetN, String formFactorN, int memorySlotsN, int SATAConnectorsN, boolean is24PinPowerConnectorsN, boolean is4PinN, boolean isAAFPConnectorN, int totalMemoryAmountN, int memorySpeedN, boolean isMemoryOCN, int PCIe_x16_5_SlotsN, int PCIe_x8_5_SlotsN, int PCIe_x4_5_SlotsN, int PCIe_x1_5_SlotsN, int PCIe_x16_4_SlotsN ,int PCIe_x8_4_SlotsN, int PCIe_x4_4_SlotsN, int PCIe_x1_4_SlotsN, int PCIe_x16_3_SlotsN, int PCIe_x8_3_SlotsN, int PCIe_x4_3_SlotsN, int PCIe_x1_3_SlotsN, int M2_5_SlotsN, int M2_4_SlotsN, int M2_3_SlotsN, String rearIO_N, int fanHeadersN, int ARGBHeadersN, int RGBHeadersN, boolean isAIOPumpConnectorN, String otherN, int USB32_2x2_N, int USB31_1_N, int USB31_2_N, int USB2N, int thunderboltN) {
        socketType = socketTypeN;
        chipSet = chipSetN;
        formFactor = formFactorN;
        memorySlots = memorySlotsN;
        SATAConnectors = SATAConnectorsN;
        is24PinPowerConnectors = is24PinPowerConnectorsN;
        is4Pin = is4PinN;
        isAAFPConnector = isAAFPConnectorN;
        totalMemoryAmount = totalMemoryAmountN;
        memorySpeed = memorySpeedN;
        isMemoryOC = isMemoryOCN;
        PCIe_x16_5_Slots = PCIe_x16_5_SlotsN;
        PCIe_x8_5_Slots = PCIe_x8_5_SlotsN;
        PCIe_x4_5_Slots = PCIe_x4_5_SlotsN;
        PCIe_x1_5_Slots = PCIe_x1_5_SlotsN;
        PCIe_x16_4_Slots = PCIe_x16_4_SlotsN;
        PCIe_x8_4_Slots = PCIe_x8_4_SlotsN;
        PCIe_x4_4_Slots = PCIe_x4_4_SlotsN;
        PCIe_x1_4_Slots = PCIe_x1_4_SlotsN;
        PCIe_x16_3_Slots = PCIe_x16_3_SlotsN;
        PCIe_x8_3_Slots = PCIe_x8_3_SlotsN;
        PCIe_x4_3_Slots = PCIe_x4_3_SlotsN;
        PCIe_x1_3_Slots = PCIe_x1_3_SlotsN;
        M2_4_Slots = M2_4_SlotsN;
        M2_5_Slots = M2_5_SlotsN;
        M2_3_Slots = M2_3_SlotsN;
        rearIO = rearIO_N;
        fanHeaders = fanHeadersN;
        ARGBHeaders = ARGBHeadersN;
        RGBHeaders = RGBHeadersN;
        isAIOPumpConnector = isAIOPumpConnectorN;
        other = otherN;
        USB32_2x2_ = USB32_2x2_N;
        USB31_1_ = USB31_1_N;
        USB31_2_ = USB31_2_N;
        USB2 = USB2N;
        thunderbolt = thunderboltN;
    }
}
