/**
 * This class is used to store all the reference data for the program.
 * @author Hasnain Heryani
 */
public class ReferenceData {
    //The array of all the cases
    private Case[] Cases;
    //The array of all the case fans
    private CaseFans[] CaseFans;
    //The array of all the CPUs
    private CPU[] CPUs;
    //The array of all the CPU coolers
    private CPUCooler[] CPUCoolers;
    //The array of all the GPUs
    private GPU[] GPUs;
    //The array of all the motherboards
    private Motherboard[] Motherboards;
    //The array of all the power supplies
    private PowerSupply[] PowerSupplies;
    //The array of all the memory kits
    private MemoryKits[] MemoryKits;
    //The array of all the storages
    private Storage[] Storages;

    /**
     * toString to display all the reference data
     * @return String of all the reference data
     */
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

    /**
     * Sorts the pccomponent array using merge sort
     */
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

    /**
     * The merging function for merge sort
     * @param arr the array to be sorted
     * @param l the left index
     * @param m the middle index
     * @param r the right index
     */
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
    /**
     * actually sorts the arrays using the merge algorithm above
     * @param arr the array to be sorted
     * @param l the left index
     * @param r the right index
     */
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

    /**
     * Getter for the motherboards array
     * @return the motherboards array
     */
    public Motherboard[] getMotherboards() {
        return Motherboards;
    }

    /**
     * Getter for the CPUs array
     * @return the CPUs array
     */
    public CPU[] getCPUs() {
        return CPUs;
    }

    /**
     * Getter for the GPUs array
     * @return the GPUs array
     */
    public GPU[] getGPUs() {
        return GPUs;
    }

    /**
     * Getter for the memory kits array
     * @return the memory kits array
     */
    public MemoryKits[] getMemoryKits() {
        return MemoryKits;
    }

    /**
     * Getter for the storages array
     * @return the storages array
     */
    public Storage[] getStorages() {
        return Storages;
    }

    /**
     * Getter for the cases array
     * @return the cases array
     */
    public Case[] getCases() {
        return Cases;
    }

    /**
     * Getter for the case fans array
     * @return the case fans array
     */
    public CaseFans[] getCaseFans() {
        return CaseFans;
    }

    /**
     * Getter for the cpu coolers array
     * @return the cpu coolers array
     */
    public CPUCooler[] getCPUCoolers() {
        return CPUCoolers;
    }

    /**
     * Getter for the power supplies array
     * @return the power supplies array
     */
    public PowerSupply[] getPowerSupplies() {
        return PowerSupplies;
    }

    /**
     * Converts an array to a string
     * @param array the array to be converted
     * @return the string representation of the array
     */
    private String convertArrayToString(PCComponent[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += (i+1) + ". " +array[i].getName() + " - $" + array[i].getPrice();
            result += "\n";
        }
        return result;
    }

    /**
     * gets the pc component from the arrays that has the matching part number
     * @param keyIdentifier the part number of the pc component
     * @return the pc component with the matching part number
     */
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
}
