public class CaseFans extends PCComponent{
    //The model of the case fan
    private String model;
    //The size of the case fan
    private double size;
    //The color of the case fan
    private String color;
    //The quantity of the bundle of case fans in the package
    private int quantity;
    //The RPM of the case fan
    private String RPM;
    private String airFlow;
    private String noiseLevel;
    //If the case fan is PWM (Pulse width modulation)
    private boolean isPWM;
    //The LED of the case fan
    private String LED;
    //The connector of the case fan
    private String connector;
    //The controller of the case fan
    private String controller;
    //The static pressure of the case fan
    private String staticPressure;

    /**
     * The default constructor of the CaseFans object
     */
    public CaseFans() {
        super();
        model = "No model";
        size = 0;
        color = "No color";
        quantity = 0;
        RPM = "No RPM";
        airFlow = "No airflow";
        isPWM = false;
        LED = "No LED";
        connector = "No connector";
        controller = "No controller";
        staticPressure = "No static pressure";
    }

    /**
     * The overloaded constructor of the CaseFans object
     * @param name
     * @param manufacturer
     * @param partNumber
     * @param price
     * @param modelN
     * @param sizeN
     * @param colorN
     * @param QuantityN
     * @param RPMn
     * @param isPWMn
     * @param LEDn
     * @param connectorN
     * @param controllerN
     * @param staticPressureN
     */
    public CaseFans(
            String name,
            String manufacturer,
            String partNumber,
            double price,
            String modelN,
            double sizeN,
            String colorN,
            int QuantityN,
            String RPMn,
            String airFlowN,
            String noiseLevelN,
            boolean isPWMn,
            String LEDn,
            String connectorN,
            String controllerN,
            String staticPressureN,
            String[][] compatibleComponentsN
            ) {
        super(name, manufacturer, partNumber, price, compatibleComponentsN);
        model = modelN;
        size = sizeN;
        color = colorN;
        quantity = QuantityN;
        RPM = RPMn;
        airFlow = airFlowN;
        noiseLevel = noiseLevelN;
        isPWM = isPWMn;
        LED = LEDn;
        connector = connectorN;
        controller = controllerN;
        staticPressure = staticPressureN;
    }

    /**
     * The info of the CaseFans object
     * @return
     * String with the info of the CaseFans object
     */
    public String toString() {
        return super.toString() + String.format("""
                        
                        Model: %s
                        Size: %s
                        Color: %s
                        Quantity: %s
                        RPM: %s
                        PWM: %s
                        LED: %s
                        Connector: %s
                        Controller: %s
                        Static Pressure: %s
                        """,
                model,
                size,
                color,
                quantity,
                RPM,
                isPWM,
                LED,
                connector,
                controller,
                staticPressure
        );

    }

}
