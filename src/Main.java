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
        String[][] compatibleMotherboard = new String[][] {{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73"}, {"Memory Kits", "CMK32GX5M2B5600C36", "F5-6000J363F16GX2-TZ5RK", "F5-6400J3239G32GX2-TX5RK"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        String[][] compatibleMotherboard2 = new String[][] {{"CPUs", "100-100000593WOF", "100-1000001015BOX", "100-100000910WOF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73"}, {"Memory Kits", "CMK32GX5M2B5600C36", "F5-6000J363F16GX2-TZ5RK", "F5-6400J3239G32GX2-TX5RK"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        String[][] compatibleMotherboard3 = new String[][] {{"CPUs", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73"}, {"Memory Kits", "CMK16GX4M2B3200C16", "SP016GXLZU320BDAJ5", "F4-3200C16D-32GVK"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        Motherboard motherboard = new Motherboard(compatibleMotherboard, "Gigabyte Z790 AORUS ELITE AX ATX LGA1700 Motherboard", "Z790 AORUS ELITE AX", 254.99, "LGA1700", "Intel Z790", "ATX", 4, 6, "Gigabyte", "DDR5", 0, "Black", 128, 7600, 3, 0, 0, 0, true, 4, 0, 0, 0, "1 x 2.5 Gb/s (Realtek)", 2, 1, 0, 1, 0, false, "Wi-Fi 6E", true);
        Motherboard motherboard3 = new Motherboard(compatibleMotherboard3, "Asus TUF GAMING X570-PLUS (Wi-Fi) ATX AM4 Motherboard", "TUF GAMING X570-PLUS (Wi-Fi)", 209.99, "AM4", "AMD X570", "ATX", 4, 8, "Asus", "DDR4", 0, "Black/Gold", 128, 4400, 2, 0, 0, 2, true, 2, 0, 0, 0, "1 x 1Gb/s (Realtek L8200A)", 2, 1, 0, 0, 0, false, "Wi-Fi 5", true);
        Motherboard motherboard2 = new Motherboard(compatibleMotherboard2, "Giabyte B650 GAMING X AX ATX AM5 Motherboard", "B650 GAMING X AX", 179.99, "AM5", "AMD B650", "ATX", 4, 4, "Gigabyte", "DDR5", 0, "Black/Gray", 128, 6400, 3, 0, 0, 0, false, 3, 0, 0, 0, "1 x 2.5 Gb/s (Realtek)", 2, 1, 0, 0, 1, false, "Wi-Fi 6E", true);
        Motherboard motherboard4 = new Motherboard(); //MAG B660 TOMAHAWK WIFI DDR4
        Motherboard motherboard5 = new Motherboard(); //ROG MAXIMUS Z790 HERO
        String[][] compatibleCPU1 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO"}};
        String[][] compatibleCPU2 = new String[][]{{}, {}};
        String[][] compatibleCPU3 = new String[][]{{}, {}};
        String[][] compatibleCPU4 = new String[][]{{}, {}};
        String[][] compatibleCPU5 = new String[][]{{}, {}};
        String[][] compatibleCPU6 = new String[][]{{}, {}};
        String[][] compatibleCPU7 = new String[][]{{}, {}};
        String[][] compatibleCPU8 = new String[][]{{}, {}};
        String[][] compatibleCPU9 = new String[][]{{}, {}};
        CPU CPU1 = new CPU(compatibleCPU1, "Intel", "Intel Core i9-13900K 3 GHz 24-Core Processor", "BX8071513900K", 559.99, 24, 3, 5.8, 125, "Intel Core i9", "Raptor Lake", "Raptor Lake", "LGA1700", "Intel UHD Graphics 770", "128", true, false, "Boxed", "8 x 32 kB Instruction, 8 x 48 kB Data", "16 x 32 kB Instruction, 16 x 64 kB Data", "8 x 2 MB", "4 x 4 MB", "1 x 36 MB", 10, false, "Yes: Hyper-Threading");
        CPU CPU2 = new CPU();
        CPU CPU3 = new CPU();
        CPU CPU4 = new CPU();
        CPU CPU5 = new CPU();
        CPU CPU6 = new CPU();
        CPU CPU7 = new CPU();
        CPU CPU8 = new CPU();
        CPU CPU9 = new CPU();
        CaseFans casefan1 = new CaseFans();
        CaseFans casefan2 = new CaseFans();
        CaseFans casefan3 = new CaseFans();
        String[][] compatibleCase1 = new String[][]{{}, {}, {}, {}, {}};
        String[][] compatibleCase2 = new String[][]{{}, {}, {}, {}, {}};
        String[][] compatibleCase3 = new String[][]{{}, {}, {}, {}, {}};
        Case case1 = new Case("Lian Li O11 Dynamic EVO ATX Mid Tower Case", "Lian Li", "PC-O11DEW", 157.99, "ATX Mid Tower", "White/Gray", false, "Tempered Glass", true, "USB 3.2 Gen 2 Type C, USB 3.2 Gen 1 Type A", new String[]{"ATX", "EATX", "Micro ATX", "Mini ITX"}, 422, 16.614, new String[]{"6 x internal 3.5\"", "3 x Internal 2.5\""}, new String[]{"8 x Full Height"}, "272 x 446 x 445", "10.7 x 17.6 x 17.5", 53.98, 1.91);
        Case case2 = new Case();
        Case case3 = new Case();
        String[][] compatibleCPUCooler1 = new String[][]{{}, {}, {}};
        String[][] compatibleCPUCooler2 = new String[][]{{}, {}, {}};
        String[][] compatibleCPUCooler3 = new String[][]{{}, {}, {}};
        CPUCooler cpuCooler1 = new CPUCooler();
        CPUCooler cpuCooler2 = new CPUCooler();
        CPUCooler cpuCooler3 = new CPUCooler();
        String[][] compatibleMemoryKit1 = new String[][]{{}};
        String[][] compatibleMemoryKit2 = new String[][]{{}};
        String[][] compatibleMemoryKit3 = new String[][]{{}};
        String[][] compatibleMemoryKit4 = new String[][]{{}};
        String[][] compatibleMemoryKit5 = new String[][]{{}};
        String[][] compatibleMemoryKit6 = new String[][]{{}};
        MemoryKits memoryKit1 = new MemoryKits();
        MemoryKits memoryKit2 = new MemoryKits();
        MemoryKits memoryKit3 = new MemoryKits();
        MemoryKits memoryKit4 = new MemoryKits();
        MemoryKits memoryKit5 = new MemoryKits();
        MemoryKits memoryKit6 = new MemoryKits();
        String[][] compatibleGPU1 = new String[][]{{}, {}, {}};
        String[][] compatibleGPU2 = new String[][]{{}, {}, {}};
        String[][] compatibleGPU3 = new String[][]{{}, {}, {}};
        GPU gpu1 = new GPU();
        GPU gpu2 = new GPU();
        GPU gpu3 = new GPU();
        String[][] compatiblePowerSupply1 = new String[][]{{}, {}, {}};
        String[][] compatiblePowerSupply2 = new String[][]{{}, {}, {}};
        String[][] compatiblePowerSupply3 = new String[][]{{}, {}, {}};
        PowerSupply powerSupply1 = new PowerSupply();
        PowerSupply powerSupply2 = new PowerSupply();
        PowerSupply powerSupply3 = new PowerSupply();
        String[][] compatibleStorage1 = new String[][]{{}, {}};
        String[][] compatibleStorage2 = new String[][]{{}, {}};
        Storage storage1 = new Storage();
        Storage storage2 = new Storage();
        Storage storage3 = new Storage();

        CaseFans caseFan1 = new CaseFans("Corsair iCUE SP120 RGB ELITE 47.7 CFM 120 mm Fans 3-Pack", "Corsair", "CO-9050109-WW", 71.98, "iCUE SP120 RGB ELITE", 120, "Black/White", 3, "400 - 1500 RPM", true, "Addressable RGB", "4-pin PWM + proprietary RGB", "USB", "1.46 mmH2O");
        CaseFans caseFan2 = new CaseFans("Corsair iCUE SP120 RGB ELITE 47.7 CFM 120 mm Fans 3-Pack", "Corsair", "CO-9050109-WW", 71.98, "iCUE SP120 RGB ELITE", 120, "Black/White", 3, "400 - 1500 RPM", true, "Addressable RGB", "4-pin PWM + proprietary RGB", "USB", "1.46 mmH2O");

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