public class Motherboard extends PCComponent{
    //All motherboards have power switch, power led, and drive led headers for the front panel
    //AMD vs. Intel Socket and which gen socket
    String socketType;
    //AMD vs. Intel chipset and which gen chipset
    String chipSet;
    //Number of memory slots
    String formFactor;
    int memorySlots;
    int PCIeSlots;
    int PCISlots;
    int SATAConnectors;
    int M_2Slots;
    boolean is24PinPowerConnectors;
    boolean is4Pin;
    int fanHeaders;
    //USB 3.1 Gen 1 Headers
    int USB3Headers;
    //USB 2.0 Headers
    int USB2Headers;
    //USB 3.1 Gen 2 Headers
    int USB3G2Headers;
    //USB-C Headers
    int USB_CHeaders;
    //Audio Headers for Mic and Headphones
    int frontAudioHeaders;
    int RGBHeaders;
    public Motherboard() {
        socketType = "LGA ";
        chipSet = "No Chipset";
        formFactor = "No Form Factor";
        memorySlots = 0;
        PCIeSlots = 0;
        PCISlots = 0;
        SATAConnectors = 0;
        M_2Slots = 0;
        is24PinPowerConnectors = true;
        is4Pin = true;
    }
}
