public class Motherboard extends PCComponent{
    //All motherboards have power switch, power led, and drive led headers for the front panel
    //AMD vs. Intel Socket and which gen socket
    String socketType;
    //AMD vs. Intel chipset and which gen chipset
    String architecture;
    String chipSet;
    //Number of memory slots
    String formFactor;
    boolean isAAFPConnector;
    int memorySlots;
    //PCIe Gen 4.0 x16 slots
    int totalMemoryAmount;
    int memorySpeed;
    boolean isMultiGPU;
    boolean isMemoryOC;
    boolean isCPU_OC;
    int PCIe_x16_5_Slots;
    int PCIe_x8_5_Slots;
    int PCIe_x4_5_Slots;
    int PCIe_x1_5_Slots;
    int PCIe_x16_4_Slots;
    int PCIe_x8_4_Slots;
    int PCIe_x4_4_Slots;
    int PCIe_x1_4_Slots;
    int PCIe_x16_3_Slots;
    int PCIe_x8_3_Slots;
    int PCIe_x4_3_Slots;
    int PCIe_x1_3_Slots;
    int SATAConnectors;
    int M2_5_Slots;
    int M2_4_Slots;
    int M2_3_Slots;
    boolean is24PinPowerConnectors;
    //For CPU Power one 4 pin or a 4+4 pin
    boolean is4Pin;
    String rearIO;
    int fanHeaders;
    //USB 3.1 Gen 1 Headers
    int USB31_1_Headers;
    //USB 2.0 Headers
    int USB2Headers;
    //USB 3.1 Gen 2 Headers
    int USB31_2_Headers;
    //USB-C Headers
    int USB_CHeaders;
    int thunderBoltHeaders;
    //Addressable RGB headers;
    int ARGBHeaders;
    int RGBHeaders;
    boolean AIOPumpConnector;
    int caseFanConnectors;
    int CPU_OPT_FanConnectors;
    int CPUFanConnectors;
    String other;
    public Motherboard() {
        socketType = "LGA 1700";
        chipSet = "B760";
        formFactor = "ATX";
        memorySlots = 4;
        SATAConnectors = 0;
        is24PinPowerConnectors = true;
        is4Pin = true;
    }
}
