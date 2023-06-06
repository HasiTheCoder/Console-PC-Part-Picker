public class CPU extends PCComponent{
    private String[][] compatibleComponents;
    //Amount of cores in the CPU
    private int coreCount;
    //Performance Cores' Clock Speed in Ghz
    private double performanceCoreClock;
    //Performance Cores' Boost Clock Speed in GHZ
    private double performanceBoostClock;
    //The max TDP(Thermal Design Power) of the CPU in watts
    private int TDP;
    //The series of the CPU (Ryzen, Core, Celeron, Pentium, Athlon, etc.)
    private String series;
    //The microarchitecture the CPU is built upon
    private String microarchitecture;
    //The name of the core family that the CPU belongs to
    private String coreFamily;
    //The type of socket that the CPU supports
    private String socketType;
    //The type of integrated graphics supported if any at all
    private String integratedGraphics;
    //The max memory supported by the CPU in GB (might be N/A)
    private String maxMemorySupported;
    //Whether the CPU supports ECC or not (Error Correcting Code)
    private boolean isECC;
    //Does it include a cooler
    private boolean includesCooler;
    //How is the CPU packaged
    private String packaging;
    //The Performance L1 Cache of the CPU
    private String performanceL1Cache;
    //The Efficiency L1 Cache of the CPU
    private String efficiencyL1Cache;
    //The Performance L2 Cache of the CPU
    private String performanceL2Cache;
    //The efficiency L2 Cache of the CPU
    private String efficiencyL2Cache;
    //The L3 Cache of the CPU
    private String L3Cache;
    //The lithography used to build the CPU in nm
    private int lithography;
    //Does it include a CPU Cooler
    private boolean includesCPUCooler;
    //Does it support simultaneous multithreading
    private String isSimultaneousMultiThreading;

    /**
     * Base Constructor of the CPU object
     */
    public CPU() {
        super();
        compatibleComponents = new String[0][0];
        coreCount = 0;
        performanceCoreClock = 0;
        performanceBoostClock = 0;
        TDP = 0;
        series = "No series";
        microarchitecture = "No microarchitecture";
        coreFamily = "No core family";
        socketType = "No socket type";
        integratedGraphics = "No integrated graphics";
        maxMemorySupported = "0";
        isECC = false;
        includesCooler = false;
        packaging = "No packaging";
        performanceL1Cache = "No Cache";
        efficiencyL1Cache = "No cache";
        performanceL2Cache = "No cache";
        efficiencyL2Cache = "no cache";
        L3Cache = "No cache";
        lithography = 0;
        includesCPUCooler = false;
        isSimultaneousMultiThreading = "No";
    }

    /**
     * The overloaded constructor of the CPU object
     * @param compatibleComponentsN
     * @param manufacturerN
     * @param nameN
     * @param partNumberN
     * @param priceN
     * @param coreCountN
     * @param performanceCoreClockN
     * @param performanceBoostClockN
     * @param TDPn
     * @param seriesN
     * @param microarchitectureN
     * @param coreFamilyN
     * @param socketTypeN
     * @param integratedGraphicsN
     * @param maxMemorySupportedN
     * @param isECCn
     * @param includesCoolerN
     * @param packagingN
     * @param performanceL1CacheN
     * @param L3CacheN
     * @param lithographyN
     * @param includesCPUCoolerN
     * @param isSimultaneousMultiThreadingN
     * @param efficiencyL1CacheN
     * @param performanceL2CacheN
     * @param efficiencyL2CacheN
     */
    public CPU(
            String[][] compatibleComponentsN,
            String manufacturerN,
            String nameN,
            String partNumberN,
            double priceN,
            int coreCountN,
            double performanceCoreClockN,
            double performanceBoostClockN,
            int TDPn,
            String seriesN,
            String microarchitectureN,
            String coreFamilyN,
            String socketTypeN,
            String integratedGraphicsN,
            String maxMemorySupportedN,
            boolean isECCn,
            boolean includesCoolerN,
            String packagingN,
            String performanceL1CacheN,
            String L3CacheN,
            int lithographyN,
            boolean includesCPUCoolerN,
            String isSimultaneousMultiThreadingN,
            String efficiencyL1CacheN,
            String performanceL2CacheN,
            String efficiencyL2CacheN) {
        super(manufacturerN, partNumberN, nameN, priceN);
        compatibleComponents = compatibleComponentsN;
        coreCount = coreCountN;
        performanceCoreClock = performanceCoreClockN;
        performanceBoostClock = performanceBoostClockN;
        TDP = TDPn;
        series = seriesN;
        microarchitecture = microarchitectureN;
        coreFamily = coreFamilyN;
        socketType = socketTypeN;
        integratedGraphics = integratedGraphicsN;
        maxMemorySupported = maxMemorySupportedN;
        isECC = isECCn;
        includesCooler = includesCoolerN;
        packaging = packagingN;
        performanceL1Cache = performanceL1CacheN;
        efficiencyL1Cache = efficiencyL1CacheN;
        performanceL2Cache = performanceL2CacheN;
        efficiencyL2Cache = efficiencyL2CacheN;
        L3Cache = L3CacheN;
        lithography = lithographyN;
        includesCPUCooler = includesCPUCoolerN;
        isSimultaneousMultiThreading = isSimultaneousMultiThreadingN;
    }

    /**
     * The info of the CPU object
     * @return
     * String with the info of the CPU object
     */
    public String toString() {
        return super.toString() + String.format("""
                        
                        Core Count: %s
                        Performance Core Clock(GHz): %s
                        Performance Boost Clock(GHz): %s
                        TDP(Watts): %s
                        Series: %s
                        Microarchitecture: %s
                        Core Family: %s
                        Socket Type: %s
                        Integrated Graphics: %s
                        Max Memory Supported(GB): %s
                        ECC Support: %s
                        Includes Cooler: %s
                        Packaging: %s
                        Performance L1 Cache: %s
                        L3 Cache: %s
                        Lithography: %s
                        includes CPU Cooler: %s
                        Simultaneous Multithreading: %s""",
                coreCount,
                performanceCoreClock,
                performanceBoostClock,
                TDP,
                series,
                microarchitecture,
                coreFamily,
                socketType,
                integratedGraphics,
                maxMemorySupported,
                isECC,
                includesCooler,
                packaging,
                performanceL1Cache,
                L3Cache,
                lithography,
                includesCPUCooler,
                isSimultaneousMultiThreading);
    }
}
