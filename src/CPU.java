public class CPU extends PCComponent{
    int coreCount;
    int performanceCoreClock;
    int performanceBoostClock;
    int TDP;
    String series;
    String microarchitecture;
    String coreFamily;
    String socketType;
    String integratedGraphics;
    boolean isECC;
    boolean includesCooler;
    String packaging;
    String performanceL1Cache;
    String efficiencyL1Cache;
    String performanceL2Cache;
    String efficiencyL2Cache;
    String L3Cache;
    String lithography;
    boolean includesCPUCooler;
    boolean isSimultaneousMultiThreading;
    public CPU() {
        manufacturer = "No manufacturer";
        name = "No name";
        partNumber = "No part number";
        price = 0;
        coreCount = 0;
        performanceCoreClock = 0;
        performanceBoostClock = 0;
        TDP = 0;
        series = "No series";
        microarchitecture = "No microarchitecture";
        coreFamily = "No core family";
        socketType = "No socket type";
        integratedGraphics = "No integrated graphics";
        isECC = false;
        includesCooler = false;
        packaging = "No packaging";
        performanceL1Cache = "No Cache";
        L3Cache = "No cache";
        lithography = "No lithography";
        includesCPUCooler = false;
        isSimultaneousMultiThreading = false;
    }
    public CPU(String manufacturerN, String nameN, String partNumberN, double priceN, int coreCountN, int performanceCoreClockN, int performanceBoostClockN, int TDPn, String seriesN, String microarchitectureN, String coreFamilyN, String socketTypeN, String integratedGraphicsN, boolean isECCn, boolean includesCoolerN, String packagingN, String performanceL1CacheN, String L3CacheN, String lithographyN, boolean includesCPUCoolerN, boolean isSimultaneousMultiThreadingN) {
        manufacturer = manufacturerN;
        name = nameN;
        partNumber = partNumberN;
        price = priceN;
        coreCount = coreCountN;
        performanceCoreClock = performanceCoreClockN;
        performanceBoostClock = performanceBoostClockN;
        TDP = TDPn;
        series = seriesN;
        microarchitecture = microarchitectureN;
        coreFamily = coreFamilyN;
        socketType = socketTypeN;
        integratedGraphics = integratedGraphicsN;
        isECC = isECCn;
        includesCooler = includesCoolerN;
        packaging = packagingN;
        performanceL1Cache = performanceL1CacheN;
        L3Cache = L3CacheN;
        lithography = lithographyN;
        includesCPUCooler = includesCPUCoolerN;
        isSimultaneousMultiThreading = isSimultaneousMultiThreadingN;
    }
    public String toString() {
        return "Manufacturer: " + manufacturer + "\nName: " + name + "\nPart Number: " + partNumber + "\nPrice: " + price + "\nCore Count: " + coreCount
                + "\nPerformance Core Clock: " + performanceCoreClock + "\nPerformance Boost Clock: " + performanceBoostClock + "\nTDP: " + TDP + "\nSeries: " + series
                + "\nMicroarchitecture: " + microarchitecture + "\nCore Family: " + coreFamily + "\nSocket Type: " + socketType + "\nIntegrated Graphics: " + integratedGraphics
                + "\nECC Support: " + isECC + "\nIncludes Cooler: " + includesCooler + "\nPackaging: " + packaging + "\nPerformance L1 Cache: " + performanceL1Cache
                + "\nL3 Cache: " + L3Cache + "\nLithography: " + lithography + "\nincludesCPUCooler: " + includesCPUCooler + "\nSimultaneous Multithreading: " + isSimultaneousMultiThreading;
    }
}
