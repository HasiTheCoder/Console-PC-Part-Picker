public class CPUCooler extends PCComponent{
    String model;
    String fanRPM;
    String noiseLevel;
    String color;
    String[] CPUSocket;
    String waterCooled;
    String fanless;
    public CPUCooler() {
        model = "no model";
        fanRPM = "no rpm";
        noiseLevel = "no noise";
        color = "no color";
        CPUSocket = new String[0];
        waterCooled = "not water cooled";
        fanless = "not fanless";
    }
    public CPUCooler(String modelN, String fanRPMn, String noiseLevelN) {
        
    }
}
