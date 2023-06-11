/**
 * Description: The computer object, where all the PCComponents are stored
 *
 * @Author Hasnain Heryani
 */
public class Computer {
    private Stack components;
    private double currentPrice;
    /**
     * Default constructor that initializes the Computer object with default values
     */
    public Computer() {
        components = new Stack();
        currentPrice = 0;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }
    public String toString() {
        return components.toString();
    }
    public void addComponent(PCComponent component) {
        components.push(component);
        currentPrice += component.getPrice();
    }
}
