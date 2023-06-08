/**
 * Description: The computer object, where all the PCComponents are stored
 *
 * @Author Hasnain Heryani
 */
public class Computer {
    //The array where the computer is stored
    /**
     * computer[0] = Motherboard
     * computer[1] = CPU
     * computer[2] = CPU Cooler
     * computer[3] = GPU
     * computer[4] = Memory Kit
     * computer[5] = Storage
     * computer[6] = Case
     * computer[7] = Case Fan
     * computer[8] = Power Supply
     */
    private int computerIndex = 0;
    private PCComponent[] computer;
    //The purpose of the computer
    String purpose;

    /**
     * Default constructor that initializes the Computer object with default values
     */
    public Computer() {
        computer = new PCComponent[9];
        initializeComputer();
        purpose = "Personal Computer";

    }

    private void initializeComputer() {
        for (int i = 0; i < computer.length; i++) {
            computer[i] = new PCComponent();
        }
    }

    /**
     * Overloaded constructor that initializes the Computer object with values provided by the user
     * @param amountOfComponents
     * The amount of components in the computer
     * @param purposeN
     * the purpose of the computer
     */
    public Computer(int amountOfComponents, String purposeN) {
        computer = new PCComponent[amountOfComponents];
        purpose = purposeN;
    }
    public double computerCost() {
        double totalCost = 0;
        for (int i = 0; i < computer.length; i++) {
            totalCost += computer[i].getPrice();
        }
        return totalCost;
    }
    public int getComputerIndex() {
        return computerIndex;
    }
    public String toString() {
        return String.format(
                """
                       Motherboard: %s
                       CPU: %s
                       CPU Cooler: %s
                       GPU: %s
                       Memory Kit: %s
                       Storage: %s
                       Case: %s
                       Case Fan: %s
                       Power Supply: %s""",
                computer[0].getName(),
                computer[1].getName(),
                computer[2].getName(),
                computer[3].getName(),
                computer[4].getName(),
                computer[5].getName(),
                computer[6].getName(),
                computer[7].getName(),
                computer[8].getName()
        );
    }

    public void addComponent(PCComponent component) {
        computer[computerIndex] = component;
        computerIndex++;
    }
}
