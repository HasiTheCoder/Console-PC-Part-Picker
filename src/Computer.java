import java.text.NumberFormat;

/**
 * Description: The computer object, where all the PCComponents are stored
 * @Author Hasnain Heryani
 */
public class Computer {

    private String name;
    private Stack components;
    private double currentPrice;
    /**
     * Default constructor that initializes the Computer object with default values
     */
    public Computer() {
        name = "My New Computer";
        components = new Stack();
        currentPrice = 0;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }
    public String toString() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return components.toString() + "\nTotal Price: " + money.format(currentPrice);
    }

    public String getName() {
        return name;
    }
    public void addComponent(PCComponent component) {
        components.push(component);
        currentPrice += component.getPrice();
    }
}
