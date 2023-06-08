public class Menus {
    private static Menus currentMenu;
    private String menus;
    private Menus[] subMenus;
    public Menus(String menu, int subMenuCount) {
        currentMenu = this;
        menus = menu;
        subMenus = new Menus[subMenuCount];
    }
    public void setSubMenuCount(int subMenuCount) {
        subMenus = new Menus[subMenuCount];
    }
    public int getSubMenuCount() {
        return subMenus.length;
    }
    public String getMenus() {
        return menus;
    }
    public Menus getCurrentMenu() {
        return currentMenu;
    }
    public Menus getSubMenu(int index) {
        return subMenus[index];
    }
    public void setSubMenu(int index, String menu, int subMenuCount){
        subMenus[index] = new Menus(menu, subMenuCount);
    }
    public void changeCurrentMenu(Menus menu) {
        currentMenu = menu;
    }
    public String toString() {
        return menus;
    }
}
