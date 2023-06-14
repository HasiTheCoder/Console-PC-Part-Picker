import java.text.NumberFormat;

/**
 * Description: The computer object, where all the PCComponents are stored
 * @Author Hasnain Heryani
 */
public class Computer {
    //The name of the computer
    private String name;
    //The components of the computer
    private Stack components;
    //The compatible matricies of the computer
    private StringArrayStack compatibleMatricies;
    //The current price of the computer
    private double currentPrice;
    /**
     * Default constructor that initializes the Computer object with default values
     */
    public Computer() {
        name = "My New Computer";
        components = new Stack();
        compatibleMatricies = new StringArrayStack();
        currentPrice = 0;
    }

    /**
     * toString method to print out the current computer
     * @return
     * The string representation of the computer
     */
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return components.toString() + "\nTotal Price: " + money.format(currentPrice);
    }

    /**
     * Removes the top compatible matrix from the stack
     */
    public void removeCompatibleMatrix() {
        compatibleMatricies.pop();
    }

    /**
     * gets the entire Stack with the compatible matricies
     * @return the compatible matricies
     */
    public StringArrayStack getCompatibleMatrix() {
        return compatibleMatricies;
    }

    /**
     * Removes the last component added to the stack
     */
    public void removeLastComponent() {
        if (!components.isEmpty()) {
            currentPrice -= components.tail().getPrice();
            components.pop();
        }
    }

    /**
     * Gets the name of the computer
     * @return the name of the computer as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a component to the stack
     * @param component
     */
    public void addComponent(PCComponent component) {
        components.push(component);
        currentPrice += component.getPrice();
    }
}
