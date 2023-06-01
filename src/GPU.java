import java.text.NumberFormat;

public class GPU extends PCComponent{
    private String chipSet;
    private int vMemory;
    private String vMemoryType;
    private int coreClock;
    private int boostClock;
    private String GPUInterface;
    private String color;
    private String frameSync;
    private int length;
    private int TDP;
    private int caseExpansionSlotWidth;
    private int totalSlotWidth;
    private String cooling;
    private String externalPower;
    private int HDMI_21a_Outputs;
    private int displayPort_14a_Outputs;
    public GPU() {
        super();
        chipSet = "No chipset";
        vMemory = 0;
        vMemoryType = "No memory type";
        coreClock = 0;
        boostClock = 0;
        GPUInterface = "No interface";
        color = "No color";
        frameSync = "No frame sync";
        length = 0;
        TDP = 0;
        caseExpansionSlotWidth = 0;
        totalSlotWidth = 0;
        cooling = "No cooling";
        externalPower = "No external power";
        HDMI_21a_Outputs = 0;
        displayPort_14a_Outputs = 0;
    }
    public GPU(
            String manufacturerN,
            String partNumberN,
            String nameN,
            double priceN,
            String chipSetN,
            int vMemoryN,
            String vMemoryTypeN,
            int coreClockN,
            int boostClockN,
            String GPUInterfaceN,
            String colorN,
            String frameSyncN,
            int lengthN,
            int TDPn,
            int caseExpansionSlotWidthN,
            int totalSlotWidthN,
            String coolingN,
            String externalPowerN,
            int HDMI_21a_OutputsN,
            int displayPort_14a_OutputsN) {
        super(manufacturerN, partNumberN, nameN, priceN);
        chipSet = chipSetN;
        vMemory = vMemoryN;
        vMemoryType = vMemoryTypeN;
        coreClock = coreClockN;
        boostClock = boostClockN;
        GPUInterface = GPUInterfaceN;
        color = colorN;
        frameSync = frameSyncN;
        length = lengthN;
        TDP = TDPn;
        caseExpansionSlotWidth = caseExpansionSlotWidthN;
        totalSlotWidth = totalSlotWidthN;
        cooling = coolingN;
        externalPower = externalPowerN;
        HDMI_21a_Outputs = HDMI_21a_OutputsN;
        displayPort_14a_Outputs = displayPort_14a_OutputsN;
    }
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return String.format("""
                        Manufacturer: %s
                        Name: %s
                        Part Number: %s
                        Price: %s
                        chipSet: %s
                        Video Memory: %s
                        Video Memory Type: %s
                        Core Clock(GHz): %s
                        Boost Clock(GHz): %s
                        Interface: %s
                        Color: %s
                        Frame Sync: %s
                        Length: %s
                        TDP(Watts): %s
                        Case Expansion Slot Width: %s
                        Total Slot Width: %s
                        Cooling: %s
                        External Power: %s
                        HDMI 2.1a Outputs: %s
                        DisplayPort 1.4a Outputs: %s""",
                manufacturer,
                name,
                partNumber,
                money.format(price),
                chipSet,
                vMemory,
                vMemoryType,
                coreClock,
                boostClock,
                GPUInterface,
                color,
                frameSync,
                length,
                TDP,
                caseExpansionSlotWidth,
                totalSlotWidth,
                cooling,
                externalPower,
                HDMI_21a_Outputs,
                displayPort_14a_Outputs);
    }

}
