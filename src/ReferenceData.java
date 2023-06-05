import com.google.gson.Gson;

public class ReferenceData {
    public Case[] Cases;
    public CaseFans[] CaseFans;
    public CPU[] CPUs;
    public CPUCooler[] CPUCoolers;
    public GPU[] GPUs;
    public Motherboard[] Motherboards;
    public PowerSupply[] PowerSupplies;
    public MemoryKits[] MemoryKits;
    public Storage[] Storages;
    public ReferenceData() {
        /*
        Cases = new Case[0];
        CaseFans = new CaseFans[0];
        CPUs = new CPU[0];
        CPUCoolers = new CPUCooler[0];
        GPUs = new GPU[0];
        Motherboards = new Motherboard[0];
        PowerSupplies = new PowerSupply[0];
        MemoryKits = new MemoryKits[0];
        Storages = new Storage[0];
        */
    }

    //TODO:
    //Create one method to read one json file with all the reference data split into sections by type
}
