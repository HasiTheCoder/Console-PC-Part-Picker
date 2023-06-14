import java.text.NumberFormat;

/**
 * Description: The computer object, where all the PCComponents are stored
 * @Author Hasnain Heryani
 */
public class Computer {

    private String name;
    private Stack components;
    private StringArrayStack compatibleMatricies;
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
    public double getCurrentPrice() {
        return currentPrice;
    }
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return components.toString() + "\nTotal Price: " + money.format(currentPrice);
    }
    public void addCompatibleMatrix(String[][] matrix) {
        compatibleMatricies.push(matrix);
    }
    public void removeCompatibleMatrix() {
        compatibleMatricies.pop();
    }
    public StringArrayStack getCompatibleMatrix() {
        return compatibleMatricies;
    }
    public void removeLastComponent() {
        if (!components.isEmpty()) {
            currentPrice -= components.tail().getPrice();
            components.pop();
        }
    }
    public String getName() {
        return name;
    }
    public void addComponent(PCComponent component) {
        components.push(component);
        currentPrice += component.getPrice();
    }
}
