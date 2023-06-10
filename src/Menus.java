import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Menus {
/*    private String menus;
    private Menus[] subMenus;
    public Menus(String menu, Menus[] subMenu) {
        menus = menu;
        subMenus = subMenu;
    }
    public Menus() {
        menus = """
                    Main Menu
            1. Configure a New computer
            2. Build Computer Report
            3. View Computer
            4. Check Computer Compatibility
            5. Find Prebuilt Computer
            6. Tutorial
            7. Exit
            """;
        subMenus = new Menus[] {
                new Menus("""
        Configure a New Computer
1. Motherboard
2. CPU
3. CPU Cooler
4. GPU
5. Memory Kit
6. Storage
7. Case
8. Case Fan
9. Power Supply
""", new Menus[] {
                        new Menus(("Motherboards\n" + Main.referenceData.printComponentList(1)), new Menus[0]),
                        new Menus(("CPUs\n" + Main.referenceData.printComponentList(2)), new Menus[0]),
                        new Menus(("CPU Coolers\n" + Main.referenceData.printComponentList(3)), new Menus[0]),
                        new Menus(("GPUs\n" + Main.referenceData.printComponentList(4)), new Menus[0]),
                        new Menus(("Memory Kits\n" + Main.referenceData.printComponentList(5)), new Menus[0]),
                        new Menus(("Storages\n" + Main.referenceData.printComponentList(6)), new Menus[0]),
                        new Menus(("Cases\n" + Main.referenceData.printComponentList(7)), new Menus[0]),
                        new Menus(("Case Fans\n" + Main.referenceData.printComponentList(8)), new Menus[0]),
                        new Menus(("Power Supplies\n" + Main.referenceData.printComponentList(9)), new Menus[0])
                }),
                        new Menus("\t\tComputer Report\n" + printReceipt(), new Menus[0]),
                new Menus("\t\tView Computer\n" + Main.currentComputer.toString() + "\nComputer Cost: " + Main.currentComputer.computerCost(), new Menus[0]),
                new Menus("Feature not implemented yet", new Menus[0]),
                new Menus("Feature not implemented yet", new Menus[0]),
                new Menus("Feature not implemented yet", new Menus[0]),
                new Menus("Have a nice day!", new Menus[0])
        };
    }
    public String getMenus() {
        return menus;
    }
    public Menus getSubMenu(int index) {
        return subMenus[index];
    }
    private static String printReceipt() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt"));
            writer.write("Computer Report\n");
            writer.write(Main.currentComputer.toString());
            writer.write("Cost:" + Main.currentComputer.computerCost() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Receipt printed to file: Receipt.txt";
    }
    public String toString() {
        return menus;
    }*/
}
