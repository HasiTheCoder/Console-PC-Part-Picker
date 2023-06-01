public class CPUCooler extends PCComponent{
    String model;
    String fanRPM;
    String noiseLevel;
    String color;
    String[] CPUSocket;
    String waterCooled;
    String fanless;
    public CPUCooler() {
        manufacturer = "No manufacturer";
        name = "No name";
        partNumber = "No part number";
        price = 0;
        model = "no model";
        fanRPM = "no rpm";
        noiseLevel = "no noise";
        color = "no color";
        CPUSocket = new String[0];
        waterCooled = "not water cooled";
        fanless = "not fan-less";
    }
    public CPUCooler(String manufacturerN, String nameN, String partNumberN, double priceN, String modelN, String fanRPMn, String noiseLevelN, String colorN, String[] CPUSocketN, String waterCooledN, String fanlessN) {
        manufacturer = manufacturerN;
        name = nameN;
        partNumber = partNumberN;
        price = priceN;
        model = modelN;
        fanRPM = fanRPMn;
        noiseLevel = noiseLevelN;
        color = colorN;
        CPUSocket = CPUSocketN;
        waterCooled = waterCooledN;
        fanless = fanlessN;

    }
    public String toString() {
        String CPUSockets = "";
        for (int i = 0; i < CPUSocket.length; i++) {
            CPUSockets += "\n" + CPUSocket[i];
        }
        return String.format("""
                Manufacturer: %s
                Name: %s
                Part Number: %s
                Price: %s
                Model: %s
                Fan RPM: %s
                Noise Level: %s
                Color: %s
                CPU Socket: %s
                Water Cooled: %s
                Fan-less: %s
                """, manufacturer,
                name,
                partNumber,
                price,
                model,
                fanRPM,
                noiseLevel,
                color,
                CPUSockets,
                waterCooled,
                fanless);
    }
}
