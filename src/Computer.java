/**
 * Description: The computer object, where all the PCComponents are stored
 *
 * @Author Hasnain Heryani
 */
public class Computer {
    //The array where the computer is stored
    private PCComponent[] computer;
    //The purpose of the computer
    String purpose;

    /**
     * Default constructor that initializes the Computer object with default values
     */
    public Computer() {
        computer = new PCComponent[11];
        purpose = "Personal Computer";

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

}
