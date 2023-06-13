public class GPU extends PCComponent{
    //The chipset of the GPU
    private String chipSet;
    //The amount of video memory on the GPU
    private int vMemory;
    //The type of video memory on the GPU
    private String vMemoryType;
    //The core clock of the GPU in MHz
    private int coreClock;
    //The boost clock of the GPU in MHz
    private int boostClock;
    //The effective memory clock of the GPU in MHz
    private int effectiveMemoryClock;
    //The interface of the GPU
    private String GPUInterface;
    //The color of the GPU
    private String color;
    //The frame sync of the GPU
    private String frameSync;
    //The length of the GPU in mm
    private int length;
    //The TDP of the GPU in watts
    private int TDP;
    //The case expansion slot width of the GPU in mm
    private int caseExpansionSlotWidth;
    //The total slot width of the GPU in mm
    private int totalSlotWidth;
    //The cooling of the GPU
    private String cooling;
    //The external power of the GPU
    private String externalPower;
    //The number of HDMI outputs on the GPU and type of HDMI if applicable
    private String HDMIOutputs;
    //The number of DisplayPort outputs on the GPU and type of DisplayPort if applicable
    private String displayPortOutputs;

    /**
     * The default constructor of the GPU object
     */

    public GPU() {
        super();
        chipSet = "No chipset";
        vMemory = 0;
        vMemoryType = "No memory type";
        coreClock = 0;
        boostClock = 0;
        effectiveMemoryClock = 0;
        GPUInterface = "No interface";
        color = "No color";
        frameSync = "No frame sync";
        length = 0;
        TDP = 0;
        caseExpansionSlotWidth = 0;
        totalSlotWidth = 0;
        cooling = "No cooling";
        externalPower = "No external power";
        HDMIOutputs = "0";
        displayPortOutputs = "0";
    }

    /**
     * The overloaded constructor of the GPU object
     * @param compatibleComponentsN
     * @param manufacturerN
     * @param partNumberN
     * @param nameN
     * @param priceN
     * @param chipSetN
     * @param vMemoryN
     * @param vMemoryTypeN
     * @param coreClockN
     * @param boostClockN
     * @param effectiveMemoryClockN
     * @param GPUInterfaceN
     * @param colorN
     * @param frameSyncN
     * @param lengthN
     * @param TDPn
     * @param caseExpansionSlotWidthN
     * @param totalSlotWidthN
     * @param coolingN
     * @param externalPowerN
     * @param HDMIOutputsN
     * @param displayPortOutputsN
     */
    public GPU(
            String[][] compatibleComponentsN,
            String manufacturerN,
            String partNumberN,
            String nameN,
            double priceN,
            String chipSetN,
            int vMemoryN,
            String vMemoryTypeN,
            int coreClockN,
            int boostClockN,
            int effectiveMemoryClockN,
            String GPUInterfaceN,
            String colorN,
            String frameSyncN,
            int lengthN,
            int TDPn,
            int caseExpansionSlotWidthN,
            int totalSlotWidthN,
            String coolingN,
            String externalPowerN,
            String HDMIOutputsN,
            String displayPortOutputsN) {
        super(manufacturerN, partNumberN, nameN, priceN,compatibleComponentsN );
        chipSet = chipSetN;
        vMemory = vMemoryN;
        vMemoryType = vMemoryTypeN;
        coreClock = coreClockN;
        boostClock = boostClockN;
        effectiveMemoryClock = effectiveMemoryClockN;
        GPUInterface = GPUInterfaceN;
        color = colorN;
        frameSync = frameSyncN;
        length = lengthN;
        TDP = TDPn;
        caseExpansionSlotWidth = caseExpansionSlotWidthN;
        totalSlotWidth = totalSlotWidthN;
        cooling = coolingN;
        externalPower = externalPowerN;
        HDMIOutputs = HDMIOutputsN;
        displayPortOutputs = displayPortOutputsN;
    }

    /**
     * The info of the GPU object
     * @return
     * String with the info of the GPU object
     */
    public String toString() {
        return super.toString() + String.format("""
                       
                        ChipSet: %s
                        Video Memory: %s
                        Video Memory Type: %s
                        Core Clock(GHz): %s
                        Boost Clock(GHz): %s
                        Effective Memory Clock(MHz): %s
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
                chipSet,
                vMemory,
                vMemoryType,
                coreClock,
                boostClock,
                effectiveMemoryClock,
                GPUInterface,
                color,
                frameSync,
                length,
                TDP,
                caseExpansionSlotWidth,
                totalSlotWidth,
                cooling,
                externalPower,
                HDMIOutputs,
                displayPortOutputs);
    }

}
