import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
    public static void main(String[] args) {
        serializeRefData();
    }

    public static void serializeRefData()
    {
        String[][] compatibleMotherboard = new String[][] {{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF"}, {"CPU Coolers", "", "", ""}, {"Memory Kits", "", "", ""}, {"GPUs", "", "", ""}, {"Power Supplies", "", "", ""}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", ""}, {"Storages", "", "", ""}};
        Motherboard motherboard = new Motherboard("Gigabyte Z790 AORUS ELITE AX ATX LGA1700 Motherboard", "Z790 AORUS ELITE AX", 254.99, "LGA1700", "ATX", "Intel Z790", 4, 6, "Gigabyte", "DDR5", 0, "Black", 128, 7600, 3, 0, 0, 0, true, 4, 0, 0, 0, "1 x 2.5 Gb/s (Realtek)", 2, 1, 0, 1, 0, false, "Wi-Fi 6E", true);
        Motherboard motherboard2 = new Motherboard();
        Motherboard motherboard3 = new Motherboard();
        CaseFans caseFan1 = new CaseFans("Corsair iCUE SP120 RGB ELITE 47.7 CFM 120 mm Fans 3-Pack", "Corsair", "CO-9050109-WW", 71.98, "iCUE SP120 RGB ELITE", 120, "Black/White", 3, "400 - 1500 RPM", true, "Addressable RGB", "4-pin PWM + proprietary RGB", "USB", "1.46 mmH2O");
        CaseFans caseFan2 = new CaseFans("Corsair iCUE SP120 RGB ELITE 47.7 CFM 120 mm Fans 3-Pack", "Corsair", "CO-9050109-WW", 71.98, "iCUE SP120 RGB ELITE", 120, "Black/White", 3, "400 - 1500 RPM", true, "Addressable RGB", "4-pin PWM + proprietary RGB", "USB", "1.46 mmH2O");
        Case case1 = new Case("Lian Li O11 Dynamic EVO ATX Mid Tower Case", "Lian Li", "PC-O11DEW", 157.99, "ATX Mid Tower", "White/Gray", false, "Tempered Glass", true, "USB 3.2 Gen 2 Type C, USB 3.2 Gen 1 Type A", new String[]{"ATX", "EATX", "Micro ATX", "Mini ITX"}, 422, 16.614, new String[]{"6 x internal 3.5\"", "3 x Internal 2.5\""}, new String[]{"8 x Full Height"}, "272 x 446 x 445", "10.7 x 17.6 x 17.5", 53.98, 1.91);
        CPU cpu = new CPU("Intel", "Intel Core i9-13900K 3 GHz 24-Core Processor", "BX8071513900K", 559.99, 24, 3, 5.8, 125, "Intel Core i9", "Raptor Lake", "Raptor Lake", "LGA 1700", "Intel UHD Graphics 770", "128 GB", true, false, "Boxed", "8 x 32 kB Instruction, 8 x 48 kB Data", "1 x 36 MB", 10, false, "Yes", "16 x 32 kB Instruction, 16 x 64 kB Data", "8 x 2 MB", "4 x 4 MB");
        CPUCooler cpuCooler = new CPUCooler("Cooler Master", "Cooler Master MASTERLIQUID ML240L RGB V2 65.59 CFM Liquid CPU Cooler", "MLW-D24M-A18PC-R2", 89.99, "MASTERLIQUID ML240L RGB V2", "650 - 1800", "6-27", "Black", new String[]{"AM2", "AM2+", "AM3", "AM3+", "AM4", "AM5", "FM1", "FM2", "FM2+", "LGA1150", "LGA 1151", "LGA 1155", "LGA 1156", "LGA 1200", "LGA 1366", "LGA 1700", "LGA 2011", "LGA 2011", "LGA 2011-3", "LGA 2066"}, "Yes - 240mm", "No");
        GPU gpu = new GPU("MSI", "RTX3060Ventus2X12GOC", "MSI GeForce RTX 3060 Ventus 2X 12G GeForce RTX 3060 12GB 12 GB Video Card", 289.99, "GeForce RTX 3060 12GB", 12, "GDDR6", 1320, 1777, 15000, "PCIe x 16", "Black", "G-Sync", 235, 170, 2, 2, "2 Fans", "1 PCIe 8-pin", "1", "3");
        MemoryKits memoryKit = new MemoryKits("Corsair", "CMK32GX5M2B5000C36", "Corsair Vengeance 32 GB (2 x 16 GB) DDR5-5600 CL36 Memory", 92.99, "DDR5-5600", "288-pin DIMM(DDR5)", "2 x 16GB", 2.906, "Black", 12.857, 36, 1.25, "36- 36 - 36 - 76", "Non-ECC/ Unbuffered", true);
        PowerSupply powerSupply = new PowerSupply("Corsair", "CP-9020200-NA", "Corsair RM850x (2021) 850 W 80+ Gold Certified Fully Modular ATX Power Supply", 149.99, "ATX", "80+ Gold", 850, 160, "Full", "Black", false, 0, 3, 0, 0, 0, 4, 0, 14, 4);
        Storage storage = new Storage("Samsung", "Samsung 970 Evo Plus 1 TB M.2-2280 PCIe 3.0 X4 NVME Solid State Drive", "MZ-V7S1T0B/AM", 69.98, "1 TB", 0.070, "SSD", 1024, "m.2-2280", "M.2 PCIe 3.0 x 4", true);
        ReferenceData refData = new ReferenceData();
        refData.CaseFans = new CaseFans[]{caseFan1, caseFan2};
        refData.Cases = new Case[]{case1};
        refData.CPUs = new CPU[]{cpu};
        refData.CPUCoolers = new CPUCooler[]{cpuCooler};
        refData.GPUs = new GPU[]{gpu};
        refData.MemoryKits = new MemoryKits[]{memoryKit};
        refData.Motherboards = new Motherboard[]{motherboard};
        refData.PowerSupplies = new PowerSupply[]{powerSupply};
        refData.Storages = new Storage[]{storage};

        try (Writer writer = new FileWriter("referenceData.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(refData, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}