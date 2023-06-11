/**
 * MenuOption class
 *
 * This class is used to create a menu option that can be added to a menu.
 *
 * @version 1.0
 * @since 2023-06-09
 */
public class MenuOption {
    private String displayText;
    private Menu subMenu;




    public MenuOption(String paramDisplayText, Menu paramSubMenu) {
        displayText = paramDisplayText;
        subMenu = paramSubMenu;

    }

    public String getDisplayText() {
        return displayText;
    }

    public Menu getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(Menu paramSubMenu) {
        subMenu = paramSubMenu;
    }
}
