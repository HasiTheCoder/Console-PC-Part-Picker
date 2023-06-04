public class CPUCooler extends PCComponent{
    //The model of the CPU cooler
    String model;
    //The fan RPM of the CPU cooler
    String fanRPM;
    //The noise level of the CPU cooler
    String noiseLevel;
    //The color of the CPU cooler
    String color;
    //The CPU socket of the CPU cooler
    String[] CPUSocket;
    //If the CPU cooler is water cooled and the size of the radiator
    String waterCooled;
    //If the CPU cooler is fan-less
    String fanless;

    /**
     * The default constructor of the CPUCooler object
     */
    public CPUCooler() {
        super();
        model = "no model";
        fanRPM = "no rpm";
        noiseLevel = "no noise";
        color = "no color";
        CPUSocket = new String[0];
        waterCooled = "not water cooled";
        fanless = "not fan-less";
    }

    /**
     * The overloaded constructor of the CPUCooler object
     * @param manufacturerN
     * @param nameN
     * @param partNumberN
     * @param priceN
     * @param modelN
     * @param fanRPMn
     * @param noiseLevelN
     * @param colorN
     * @param CPUSocketN
     * @param waterCooledN
     * @param fanlessN
     */
    public CPUCooler(String manufacturerN, String nameN, String partNumberN, double priceN, String modelN, String fanRPMn, String noiseLevelN, String colorN, String[] CPUSocketN, String waterCooledN, String fanlessN) {
        super(manufacturerN, partNumberN, nameN, priceN);
        model = modelN;
        fanRPM = fanRPMn;
        noiseLevel = noiseLevelN;
        color = colorN;
        CPUSocket = CPUSocketN;
        waterCooled = waterCooledN;
        fanless = fanlessN;

    }

    /**
     * The info of the CPUCooler object
     * @return
     * String of the info of the CPUCooler object
     */
    public String toString() {
        return super.toString() + String.format("""
                
                Model: %s
                Fan RPM: %s
                Noise Level: %s
                Color: %s
                CPU Socket: %s
                Water Cooled: %s
                Fan-less: %s
                """,
                model,
                fanRPM,
                noiseLevel,
                color,
                convertArrayToString(CPUSocket),
                waterCooled,
                fanless);
    }

    /**
     * Convert the array of strings to one string
     * @param array
     * @return
     * String of the array of strings
     */
    private String convertArrayToString(String[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            result += "\n";
        }
        return result;
    }
}
