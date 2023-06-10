import java.util.Scanner;

public class Menu {

    private String menuTitle;
    private Menu mainMenu;
    private Menu previousMenu;
    private MenuOption[] menuOptions;

    public Menu(MenuOption[] paramMenuOptions, String paramMenuTitle, Menu paramMainMenu, Menu paramPreviousMenu) {
        menuTitle = paramMenuTitle;
        mainMenu = paramMainMenu;
        previousMenu = paramPreviousMenu;
        menuOptions = paramMenuOptions;
    }

    public void display() {
        System.out.println(menuTitle);
        int i;
        for (i = 0; i < menuOptions.length; i++) {
            System.out.println((i+1) + ". " + menuOptions[i].getDisplayText());
        }
        if (previousMenu != null) {
            System.out.println((i+1) + ". Return to Previous Menu.");
        }
        if (mainMenu != null) {
            System.out.println((i+2) + ". Return to Main Menu.");
        }
    }

    public int getUserChoice() {
        Scanner input = new Scanner(System.in);
        String choice = "";
        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Enter your choice: ");
            choice = input.next();

            if (Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= menuOptions.length) {
                validChoice = true;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return Integer.parseInt(choice);
    }
    public Menu getMainMenu() {
        return mainMenu;
    }

    public Menu getPreviousMenu() {
        return previousMenu;
    }

    public void setMainMenu(Menu paramMainMenu) {
        mainMenu = paramMainMenu;
    }

    public void setPreviousMenu(Menu paramPreviousMenu) {
        previousMenu = paramPreviousMenu;
    }

    public MenuOption[] getMenuOptions() {
        return menuOptions;
    }
}
