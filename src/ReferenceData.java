import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReferenceData {
    private Case[] Cases;
    private CaseFans[] CaseFans;
    private CPU[] CPUs;
    private CPUCooler[] CPUCoolers;
    private GPU[] GPUs;
    private Motherboard[] Motherboards;
    private PowerSupply[] PowerSupplies;
    private MemoryKits[] MemoryKits;
    private Storage[] Storages;

    public String toString() {
        return String.format("""
                Cases:
                %s
                Case Fans:
                %s
                CPUs:
                %s
                CPU Coolers:
                %s
                GPUs:
                %s
                Motherboards:
                %s
                Power Supplies:
                %s
                Memory Kits:
                %s
                Storages:
                %s
                """,
                convertArrayToString(Cases),
                convertArrayToString(CaseFans),
                convertArrayToString(CPUs),
                convertArrayToString(CPUCoolers),
                convertArrayToString(GPUs),
                convertArrayToString(Motherboards),
                convertArrayToString(PowerSupplies),
                convertArrayToString(MemoryKits),
                convertArrayToString(Storages)
                );
    }
    public void setMotherboards(Motherboard[] motherboardsN) {
        Motherboards = motherboardsN;
    }
    public void setCPUs(CPU[] CPUsN) {
        CPUs = CPUsN;
    }
    public void setGPUs(GPU[] GPUsN) {
        GPUs = GPUsN;
    }
    public void setMemoryKits(MemoryKits[] memoryKitsN) {
        MemoryKits = memoryKitsN;
    }
    public void setStorages(Storage[] storagesN) {
        Storages = storagesN;
    }
    public void setCases(Case[] casesN) {
        Cases = casesN;
    }
    public void setCaseFans(CaseFans[] caseFansN) {
        CaseFans = caseFansN;
    }
    public void setCPUCoolers(CPUCooler[] CPUCoolersN) {
        CPUCoolers = CPUCoolersN;
    }
    public void setPowerSupplies(PowerSupply[] powerSuppliesN) {
        PowerSupplies = powerSuppliesN;
    }
    public PCComponent[] getMotherboards() {
        return Motherboards;
    }
    public PCComponent[] getCPUs() {
        return CPUs;
    }
    public PCComponent[] getGPUs() {
        return GPUs;
    }
    public PCComponent[] getMemoryKits() {
        return MemoryKits;
    }
    public PCComponent[] getStorages() {
        return Storages;
    }
    public PCComponent[] getCases() {
        return Cases;
    }
    public PCComponent[] getCaseFans() {
        return CaseFans;
    }
    public PCComponent[] getCPUCoolers() {
        return CPUCoolers;
    }
    public PCComponent[] getPowerSupplies() {
        return PowerSupplies;
    }
    public String printComponentList(int componentType) {
        if (componentType == 7) {
            return convertArrayToString(Cases);
        }
        else if (componentType == 8) {
            return convertArrayToString(CaseFans);
        }
        else if (componentType == 2) {
            return convertArrayToString(CPUs);
        }
        else if (componentType == 3) {
            return convertArrayToString(CPUCoolers);
        }
        else if (componentType == 4) {
            return convertArrayToString(GPUs);
        }
        else if (componentType == 1) {
            return convertArrayToString(Motherboards);
        }
        else if (componentType == 9) {
            return convertArrayToString(PowerSupplies);
        }
        else if (componentType == 5) {
            return convertArrayToString(MemoryKits);
        }
        else if (componentType == 6) {
            return convertArrayToString(Storages);
        }
        return "Error: Invalid component type.";
    }
    private String convertArrayToString(PCComponent[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += (i+1) + ". " +array[i].getName() + " - $" + array[i].getPrice();
            result += "\n";
        }
        return result;
    }

    public PCComponent getComponent(int partChoice, int menuChoice) {
        PCComponent component = null;
        if (menuChoice == 1) {
            for (int i = 1; i <= Motherboards.length; i++) {
                if (partChoice == i) {
                    component = Motherboards[i-1];
                }
            }
        }
        else if (menuChoice == 2) {
            for (int i = 1; i <= CPUs.length; i++) {
                if (partChoice == i) {
                    component = CPUs[i-1];
                }
            }
        }
        else if (menuChoice == 3) {
            for (int i = 1; i <= CPUCoolers.length; i++) {
                if (partChoice == i) {
                    component = CPUCoolers[i-1];
                }
            }
        }
        else if (menuChoice == 4) {
            for (int i = 1; i <= GPUs.length; i++) {
                if (partChoice == i) {
                    component = GPUs[i-1];
                }
            }
        }
        else if (menuChoice == 5) {
            for (int i = 1; i <= MemoryKits.length; i++) {
                if (partChoice == i) {
                    component = MemoryKits[i-1];
                }
            }
        }
        else if (menuChoice == 6) {
            for (int i = 1; i <= Storages.length; i++) {
                if (partChoice == i) {
                    component = Storages[i-1];
                }
            }
        }
        else if (menuChoice == 7) {
            for (int i = 1; i <= Cases.length; i++) {
                if (partChoice == i) {
                    component = Cases[i-1];
                }
            }
        }
        else if (menuChoice == 8) {
            for (int i = 1; i <= CaseFans.length; i++) {
                if (partChoice == i) {
                    component = CaseFans[i-1];
                }
            }
        }
        else if (menuChoice == 9) {
            for (int i = 1; i <= PowerSupplies.length; i++) {
                if (partChoice == i) {
                    component = PowerSupplies[i-1];
                }
            }
        }
        return component;
    }

    public int getComponentList(int i) {
        if (i == 1) {
            return Motherboards.length;
        }
        else if (i == 2) {
            return CPUs.length;
        }
        else if (i == 3) {
            return CPUCoolers.length;
        }
        else if (i == 4) {
            return GPUs.length;
        }
        else if (i == 5) {
            return MemoryKits.length;
        }
        else if (i == 6) {
            return Storages.length;
        }
        else if (i == 7) {
            return Cases.length;
        }
        else if (i == 8) {
            return CaseFans.length;
        }
        else if (i == 9) {
            return PowerSupplies.length;
        }
        else {
            return 0;
        }
    }
    //TODO:
    //Create one method to read one json file with all the reference data split into sections by type
}
