import java.text.NumberFormat;

import static java.lang.String.format;

public class CPU extends PCComponent{
    int coreCount;
    double performanceCoreClock;
    double performanceBoostClock;
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
        efficiencyL1Cache = "No cache";
        performanceL2Cache = "No cache";
        efficiencyL2Cache = "no cache";
        L3Cache = "No cache";
        lithography = "No lithography";
        includesCPUCooler = false;
        isSimultaneousMultiThreading = false;
    }
    public CPU(
            String manufacturerN,
            String nameN,
            String partNumberN,
            double priceN,
            int coreCountN,
            int performanceCoreClockN,
            int performanceBoostClockN,
            int TDPn,
            String seriesN,
            String microarchitectureN,
            String coreFamilyN,
            String socketTypeN,
            String integratedGraphicsN,
            boolean isECCn,
            boolean includesCoolerN,
            String packagingN,
            String performanceL1CacheN,
            String L3CacheN,
            String lithographyN,
            boolean includesCPUCoolerN,
            boolean isSimultaneousMultiThreadingN,
            String efficiencyL1CacheN,
            String performanceL2CacheN,
            String efficiencyL2CacheN) {
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
        efficiencyL1Cache = efficiencyL1CacheN;
        performanceL2Cache = performanceL2CacheN;
        efficiencyL2Cache = efficiencyL2CacheN;
        L3Cache = L3CacheN;
        lithography = lithographyN;
        includesCPUCooler = includesCPUCoolerN;
        isSimultaneousMultiThreading = isSimultaneousMultiThreadingN;
    }
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return String.format("""
                        Manufacturer: %s
                        Name: %s
                        Part Number: %s
                        Price: %s
                        Core Count: %s
                        Performance Core Clock(GHz): %s
                        Performance Boost Clock(GHz): %s
                        TDP(Watts): %s
                        Series: %s
                        Microarchitecture: %s
                        Core Family: %s
                        Socket Type: %s
                        Integrated Graphics: %s
                        ECC Support: %s
                        Includes Cooler: %s
                        Packaging: %s
                        Performance L1 Cache: %s
                        L3 Cache: %s
                        Lithography: %s
                        includes CPU Cooler: %s
                        Simultaneous Multithreading: %s""",
                manufacturer, name, partNumber, price, coreCount, performanceCoreClock, performanceBoostClock, TDP, series, microarchitecture, coreFamily, socketType, integratedGraphics, isECC, includesCooler, packaging, performanceL1Cache, L3Cache, lithography, includesCPUCooler, isSimultaneousMultiThreading);
    }
}
