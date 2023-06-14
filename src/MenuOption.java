/**
 * MenuOption class
 *
 * This class is used to create a menu option that can be added to a menu.
 *
 * @version 1.0
 * @since 2023-06-09
 */
public class MenuOption {
    // the text that will be displayed at a specific menu option
    private String displayText;
    // the submenu of the specific option
    private Menu subMenu;

    /**
     * constructor that initializes the MenuOption object with provided values
     *
     * @param paramDisplayText The text that will be displayed at a specific menu option
     * @param paramSubMenu The submenu of the specific option
     */
    public MenuOption(String paramDisplayText, Menu paramSubMenu) {
        displayText = paramDisplayText;
        subMenu = paramSubMenu;

    }

    /**
     * gets the display text of the menu option
     * @return the display text of the menu option
     */
    public String getDisplayText() {
        return displayText;
    }

    /**
     * gets the submenu of the menu option
     * @return the submenu of the menu option
     */
    public Menu getSubMenu() {
        return subMenu;
    }
    /**
     * toString method to print out the display text of the menu option
     * @return
     * The string representation of the menu option
     */
    public String toString() {
        return displayText;
    }
}
