/**
 * Description: The computer object, where all the PCComponents are stored
 *
 * @Author Hasnain Heryani
 */
public class Computer {
    private Stack computer;
    private double price;
    /**
     * Default constructor that initializes the Computer object with default values
     */
    public Computer() {
        computer = new Stack();
        price = 0;
    }
    public double computerCost() {
        return price;
    }
    public String toString() {
        return computer.toString();
    }
    public void addComponent(PCComponent component) {
        computer.push(component);
        price += component.getPrice();
    }
}
