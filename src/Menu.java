import java.util.Scanner;

/**
 * Description: The menu object that is used to display the menu options to the user
 * @Author Hasnain Heryani
 */
public class Menu {
    //The identifier for the view computer menu
    public static final String VIEW_COMPUTER_IDENTIFIER = "##ViewComputer##";
    //The identifier for the build computer report menu
    public static final String BUILD_COMPUTER_REPORT = "##BuildComputerReport##";
    //The identifier for the tutorial menu
    public static final String TUTORIAL = "##Tutorial##";
    //The identifier for the remove last component menu
    public static final String REMOVE_LAST_COMPONENT = "##RemoveLastComponent##";
    //The title of the menu
    private String menuTitle;
    //The main menu
    private Menu mainMenu;
    //The previous menu
    private Menu previousMenu;
    //The menu options or anything displayed in the menu other than the title
    private MenuOption[] menuOptions;
    //The key identifier for the menu
    private String keyIdentifier = "";

    /**
     * constructor for the menu object
     * @param paramMenuOptions The menu options or anything displayed in the menu other than the title
     * @param paramMenuTitle The title of the menu
     * @param paramMainMenu The main menu
     * @param paramPreviousMenu The previous menu
     * @param paramKeyIdentifier The key identifier for the menu
     */
    public Menu(MenuOption[] paramMenuOptions, String paramMenuTitle, Menu paramMainMenu, Menu paramPreviousMenu, String paramKeyIdentifier) {
        menuTitle = paramMenuTitle;
        mainMenu = paramMainMenu;
        previousMenu = paramPreviousMenu;
        menuOptions = paramMenuOptions;
        keyIdentifier = paramKeyIdentifier;
    }

    /**
     * The overloaded constructor for the menu object
     * @param paramMenuOptions The menu options or anything displayed in the menu other than the title
     * @param paramMenuTitle The title of the menu
     * @param paramMainMenu The main menu
     * @param paramPreviousMenu The previous menu
     */
    public Menu(MenuOption[] paramMenuOptions, String paramMenuTitle, Menu paramMainMenu, Menu paramPreviousMenu) {
        menuTitle = paramMenuTitle;
        mainMenu = paramMainMenu;
        previousMenu = paramPreviousMenu;
        menuOptions = paramMenuOptions;
    }

    /**
     * Displays the menu that calls the method
     */
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
        if (!keyIdentifier.isEmpty() && (!keyIdentifier.equalsIgnoreCase(Menu.VIEW_COMPUTER_IDENTIFIER) && !keyIdentifier.equalsIgnoreCase(Menu.BUILD_COMPUTER_REPORT)  && !keyIdentifier.equalsIgnoreCase(Menu.TUTORIAL)))
        {
            System.out.println("Press 1 to add this to your new computer.");
        }
    }

    /**
     * displays the view computer menu
     * @param currentComputer The current computer
     */
    public void display(Computer currentComputer)
    {
        System.out.println(currentComputer.getName());
        System.out.println("1." + currentComputer + "\n");
        if (previousMenu != null) {
            System.out.println("2. Return to Previous Menu.");
        }
        if (mainMenu != null) {
            System.out.println("3. Return to Main Menu.");
        }
    }

    /**
     * Takes user input
     * @return The user choice
     */
    public int getUserChoice() {
        // Takes input
        Scanner input = new Scanner(System.in);
        String userChoiceText = "";
        int userChoice = 0;
        //reject everything except 1 to menuOptions length +2
            System.out.println("Enter your choice: ");
            userChoiceText = input.nextLine();
            // The max length is the length of the menu options + 2 for the return to previous menu and return to main menu options
            int maxLength = menuOptions.length+2;
            // If the main menu is null then the max length is the length of the menu options.
            // tries to take input. If the input is not the right type, then catches exception and tries again recursively
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
                return getUserChoice();
            }
            // If the input is not the right type, then catches exception and tries again recursively
            catch (NumberFormatException ex) {
                System.out.println("Invalid choice. Please try again.");
                return getUserChoice();
            }
    }

    /**
     * Gets the main menu
     * @return The main menu
     */
    public Menu getMainMenu() {
        return mainMenu;
    }

    /**
     * Gets the previous menu
     * @return The previous menu
     */
    public Menu getPreviousMenu() {
        return previousMenu;
    }

    /**
     * Sets the main menu
     * @param paramMainMenu The main menu
     */
    public void setMainMenu(Menu paramMainMenu) {
        mainMenu = paramMainMenu;
    }

    /**
     * Sets the previous menu
     * @param paramPreviousMenu The previous menu
     */
    public void setPreviousMenu(Menu paramPreviousMenu) {
        previousMenu = paramPreviousMenu;
    }

    /**
     * Gets the menu options
     * @return The menu options
     */
    public MenuOption[] getMenuOptions() {
        return menuOptions;
    }

    /**
     * Gets the key identifier
     * @return The key identifier
     */
    public String getKeyIdentifier() {
        return keyIdentifier;
    }

    /**
     * toString method to display the menu
     * @return
     */
    public String toString() {
        String output = "";
        output += menuTitle + "\n";
        for (int i = 0; i < menuOptions.length; i++) {
            output += (i+1) + ". " + menuOptions[i].getDisplayText() + "\n";
        }
        if (previousMenu != null) {
            output += (menuOptions.length+1) + ". Return to Previous Menu.\n";
        }
        if (mainMenu != null) {
            output += (menuOptions.length+2) + ". Return to Main Menu.\n";
        }
        if (!keyIdentifier.isEmpty() && (!keyIdentifier.equalsIgnoreCase(Menu.VIEW_COMPUTER_IDENTIFIER) && !keyIdentifier.equalsIgnoreCase(Menu.BUILD_COMPUTER_REPORT)  && !keyIdentifier.equalsIgnoreCase(Menu.TUTORIAL)))
        {
            output += "Press 1 to add this to your new computer.\n";
        }
        return output;
    }
}
