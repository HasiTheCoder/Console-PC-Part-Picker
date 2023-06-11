import java.util.Scanner;

public class Menu {

    private String menuTitle;
    private Menu mainMenu;
    private Menu previousMenu;
    private MenuOption[] menuOptions;

    private String keyIdentifier = "";

    public Menu()
    {

    }
    public Menu(MenuOption[] paramMenuOptions, String paramMenuTitle, Menu paramMainMenu, Menu paramPreviousMenu, String paramKeyIdentifier) {
        menuTitle = paramMenuTitle;
        mainMenu = paramMainMenu;
        previousMenu = paramPreviousMenu;
        menuOptions = paramMenuOptions;
        keyIdentifier = paramKeyIdentifier;
    }

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
        if (!keyIdentifier.isEmpty())
        {
            System.out.println("Press 1 to add this to your new computer.");
        }
    }

    public int getUserChoice() {

        Scanner input = new Scanner(System.in);
        String userChoiceText = "";
        int userChoice = 0;
        //reject everything except 1 to menuoptions length +2

        while (true) {
            System.out.println("Enter your choice: ");
            userChoiceText = input.nextLine();
            int maxLength = menuOptions.length+2;
            try {
                if (mainMenu == null)
                {
                    maxLength = menuOptions.length;
                }

                userChoice = Integer.parseInt(userChoiceText);
                if (userChoice >= 1 && userChoice <= maxLength)
                {
                    return userChoice;
                }
                System.out.println("Invalid choice. Please try again.");
            }
            catch (NumberFormatException ex) {
                System.out.println("Invalid choice. Please try again.");
            }
        }
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

    public String getKeyIdentifier() {
        return keyIdentifier;
    }
}
