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
    public void sortReferenceData() {
        sort(Cases, 0, Cases.length - 1);
        sort(CaseFans, 0, CaseFans.length - 1);
        sort(CPUs, 0, CPUs.length - 1);
        sort(CPUCoolers, 0, CPUCoolers.length - 1);
        sort(GPUs, 0, GPUs.length - 1);
        sort(Motherboards, 0, Motherboards.length - 1);
        sort(PowerSupplies, 0, PowerSupplies.length - 1);
        sort(MemoryKits, 0, MemoryKits.length - 1);
        sort(Storages, 0, Storages.length - 1);
    }

    public void merge(PCComponent arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        PCComponent L[] = new PCComponent[n1];
        PCComponent R[] = new PCComponent[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getPrice() <= R[j].getPrice()) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public void sort(PCComponent arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
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
    public Motherboard[] getMotherboards() {
        return Motherboards;
    }
    public CPU[] getCPUs() {
        return CPUs;
    }
    public GPU[] getGPUs() {
        return GPUs;
    }
    public MemoryKits[] getMemoryKits() {
        return MemoryKits;
    }
    public Storage[] getStorages() {
        return Storages;
    }
    public Case[] getCases() {
        return Cases;
    }
    public CaseFans[] getCaseFans() {
        return CaseFans;
    }
    public CPUCooler[] getCPUCoolers() {
        return CPUCoolers;
    }
    public PowerSupply[] getPowerSupplies() {
        return PowerSupplies;
    }
    private String convertArrayToString(PCComponent[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += (i+1) + ". " +array[i].getName() + " - $" + array[i].getPrice();
            result += "\n";
        }
        return result;
    }
    public PCComponent getPCComponent(String keyIdentifier) {
        for (int i = 0; i < Motherboards.length; i++) {
            if (Motherboards[i].getPartNumber().equals(keyIdentifier)) {
                return Motherboards[i];
            }
        }
        for (int i = 0; i < CPUs.length; i++) {
            if (CPUs[i].getPartNumber().equals(keyIdentifier)) {
                return CPUs[i];
            }
        }
        for (int i = 0; i < CPUCoolers.length; i++) {
            if (CPUCoolers[i].getPartNumber().equals(keyIdentifier)) {
                return CPUCoolers[i];
            }
        }
        for (int i = 0; i < GPUs.length; i++) {
            if (GPUs[i].getPartNumber().equals(keyIdentifier)) {
                return GPUs[i];
            }
        }
        for (int i = 0; i < MemoryKits.length; i++) {
            if (MemoryKits[i].getPartNumber().equals(keyIdentifier)) {
                return MemoryKits[i];
            }
        }
        for (int i = 0; i < Storages.length; i++) {
            if (Storages[i].getPartNumber().equals(keyIdentifier)) {
                return Storages[i];
            }
        }
        for (int i = 0; i < Cases.length; i++) {
            if (Cases[i].getPartNumber().equals(keyIdentifier)) {
                return Cases[i];
            }
        }
        for (int i = 0; i < CaseFans.length; i++) {
            if (CaseFans[i].getPartNumber().equals(keyIdentifier)) {
                return CaseFans[i];
            }
        }
        for (int i = 0; i < PowerSupplies.length; i++) {
            if (PowerSupplies[i].getPartNumber().equals(keyIdentifier)) {
                return PowerSupplies[i];
            }
        }
        return null;
    }
    //TODO:
    //Create one method to read one json file with all the reference data split into sections by type
}
