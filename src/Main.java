import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        serializeRefData();
        /*ReferenceData referenceData = LoadReferenceData("referenceData.json");
        Menu currentMenu = loadMenuStructure();
        currentMenu.display();
        int userChoice;

        Computer currentComputer = new Computer();

        while (true) {
            userChoice = currentMenu.getUserChoice();
            if (userChoice <= currentMenu.getMenuOptions().length && currentMenu.getMenuOptions()[userChoice-1].getDisplayText().equalsIgnoreCase("Exit"))
            {
                break;
            }

            if (userChoice == currentMenu.getMenuOptions().length + 1) {
                if (currentMenu.getPreviousMenu() != null) {
                    (currentMenu = currentMenu.getPreviousMenu()).display();
                }
            }
            else if (userChoice == currentMenu.getMenuOptions().length + 2) {
                if (currentMenu.getMainMenu() != null) {
                    (currentMenu = currentMenu.getMainMenu()).display();
                }
            }
            else if (userChoice <= currentMenu.getMenuOptions().length) {
                    if (currentMenu.getMenuOptions()[userChoice - 1].getSubMenu() == null) {

                        if (!currentMenu.getKeyIdentifier().isEmpty())
                        {
                            PCComponent tempCompoent = referenceData.getPCComponent(currentMenu.getKeyIdentifier());
                            if (tempCompoent != null) {
                                currentComputer.addComponent(tempCompoent);
                            }
                            else {
                                System.out.println("Component not found.");
                            }
                        }
                        currentMenu.getPreviousMenu().display();
                        currentMenu = currentMenu.getPreviousMenu();
                    } else {
                        currentMenu.getMenuOptions()[userChoice - 1].getSubMenu().display();
                        // set the current menu to the selected submenu
                        currentMenu = currentMenu.getMenuOptions()[userChoice - 1].getSubMenu();
                    }
                }
            }*/
        }


    private static ReferenceData LoadReferenceData(String jsonFilePath) {
        ReferenceData referenceData = null;
        Gson gson = new Gson();
        try {
            String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            referenceData = gson.fromJson(json, ReferenceData.class);
        } catch (IOException e) {
            System.out.println("Reference Data Load Failed. " + e.toString());
        }
        return referenceData;
    }
    private static Menu loadMenuStructure() {
        MenuOption[] m1DetailOption = new MenuOption[1];
        m1DetailOption[0] = new MenuOption("M1 Detail String", null);
        Menu m1DetailMenu = new Menu(m1DetailOption, "M1 Name", null , null, "M1PartNumber");

        MenuOption[] m2DetailOption = new MenuOption[1];
        m2DetailOption[0] = new MenuOption("M2 Detail String", null);
        Menu m2DetailMenu = new Menu(m2DetailOption, "M2 Name", null , null , "M2PartNumber");

        MenuOption[] m3DetailOption = new MenuOption[1];
        m3DetailOption[0] = new MenuOption("M3 Detail String", null);
        Menu m3DetailMenu = new Menu(m3DetailOption, "M3 Name", null , null , "M3PartNumber");

        MenuOption[] motherboardListOptions = new MenuOption[3];
        motherboardListOptions[0] = new MenuOption("M1", m1DetailMenu);
        motherboardListOptions[1] = new MenuOption("M2", m2DetailMenu);
        motherboardListOptions[2] = new MenuOption("M3", m3DetailMenu);
        Menu motherboardListMenu = new Menu(motherboardListOptions, "Motherboard List", null , null );

        m1DetailMenu.setPreviousMenu(motherboardListMenu);
        m2DetailMenu.setPreviousMenu(motherboardListMenu);
        m3DetailMenu.setPreviousMenu(motherboardListMenu);

        MenuOption[] c1DetailOption = new MenuOption[1];
        c1DetailOption[0] = new MenuOption("C1 Detail String", null);
        Menu c1DetailMenu = new Menu(c1DetailOption, "C1 Name", null , null , "C1PartNumber");

        MenuOption[] c2DetailOption = new MenuOption[1];
        c2DetailOption[0] = new MenuOption("C2 Detail String", null);
        Menu c2DetailMenu = new Menu(c2DetailOption, "C2 Name", null , null , "C2PartNumber");

        MenuOption[] c3DetailOption = new MenuOption[1];
        c3DetailOption[0] = new MenuOption("C3 Detail String", null);
        Menu c3DetailMenu = new Menu(c3DetailOption, "C3 Name", null , null , "C3PartNumber");

        MenuOption[] cpuListOptions = new MenuOption[3];
        cpuListOptions[0] = new MenuOption("C1", c1DetailMenu);
        cpuListOptions[1] = new MenuOption("C2", c2DetailMenu);
        cpuListOptions[2] = new MenuOption("C3", c3DetailMenu);
        Menu cpuListMenu = new Menu(cpuListOptions, "CPU List", null , null );

        c1DetailMenu.setPreviousMenu(cpuListMenu);
        c2DetailMenu.setPreviousMenu(cpuListMenu);
        c3DetailMenu.setPreviousMenu(cpuListMenu);

        MenuOption[] g1DetailOption = new MenuOption[1];
        g1DetailOption[0] = new MenuOption("G1 Detail String", null);
        Menu g1DetailMenu = new Menu(g1DetailOption, "G1 Name", null , null , "G1PartNumber");

        MenuOption[] g2DetailOption = new MenuOption[1];
        g2DetailOption[0] = new MenuOption("G2 Detail String", null);
        Menu g2DetailMenu = new Menu(g2DetailOption, "G2 Name", null , null , "G2PartNumber");

        MenuOption[] g3DetailOption = new MenuOption[1];
        g3DetailOption[0] = new MenuOption("G3 Detail String", null);
        Menu g3DetailMenu = new Menu(g3DetailOption, "G3 Name", null , null , "G3PartNumber");

        MenuOption[] gpuListOptions = new MenuOption[3];
        gpuListOptions[0] = new MenuOption("G1", g1DetailMenu);
        gpuListOptions[1] = new MenuOption("G2", g2DetailMenu);
        gpuListOptions[2] = new MenuOption("G3", g3DetailMenu);
        Menu gpuListMenu = new Menu(gpuListOptions, "GPU List", null , null );

        g1DetailMenu.setPreviousMenu(gpuListMenu);
        g2DetailMenu.setPreviousMenu(gpuListMenu);
        g3DetailMenu.setPreviousMenu(gpuListMenu);

        MenuOption[] newComputerSubMenuOptions = new MenuOption[3];
        newComputerSubMenuOptions[0] = new MenuOption("Add Motherboard", motherboardListMenu);
        newComputerSubMenuOptions[1] = new MenuOption("Add CPU", cpuListMenu);
        newComputerSubMenuOptions[2] = new MenuOption("Add GPU", gpuListMenu);
        Menu newComputerMenu = new Menu(newComputerSubMenuOptions, "Configure a New computer", null, null);

        motherboardListMenu.setPreviousMenu(newComputerMenu);
        cpuListMenu.setPreviousMenu(newComputerMenu);
        gpuListMenu.setPreviousMenu(newComputerMenu);

        MenuOption[] mainMenuOptions = new MenuOption[7];
        mainMenuOptions[0] = new MenuOption("Configure a New computer", newComputerMenu);
        mainMenuOptions[1] = new MenuOption("Build Computer Report", null);
        mainMenuOptions[2] = new MenuOption("View Computer", null);
        mainMenuOptions[3] = new MenuOption("Check Computer Compatibility", null);
        mainMenuOptions[4] = new MenuOption("Find Prebuilt Computer", null);
        mainMenuOptions[5] = new MenuOption("Tutorial", null);
        mainMenuOptions[6] = new MenuOption("Exit", null);
        Menu mainMenu = new Menu(mainMenuOptions, "Main Menu", null , null);

        m1DetailMenu.setMainMenu(mainMenu);
        m2DetailMenu.setMainMenu(mainMenu);
        m3DetailMenu.setMainMenu(mainMenu);
        c1DetailMenu.setMainMenu(mainMenu);
        c2DetailMenu.setMainMenu(mainMenu);
        c3DetailMenu.setMainMenu(mainMenu);
        g1DetailMenu.setMainMenu(mainMenu);
        g2DetailMenu.setMainMenu(mainMenu);
        g3DetailMenu.setMainMenu(mainMenu);
        newComputerMenu.setMainMenu(mainMenu);
        newComputerMenu.setPreviousMenu(mainMenu);
        motherboardListMenu.setMainMenu(mainMenu);
        cpuListMenu.setMainMenu(mainMenu);
        gpuListMenu.setMainMenu(mainMenu);
        return mainMenu;
    }

/*    public static int mainMenu() {
        try {
            System.out.println(menus.getMenus());
            int choice = input.nextInt();
            input.nextLine();
            if (choice > 7 || choice < 1) {
                System.out.println("Invalid input");
                return mainMenu();
            }
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Press enter to continue");
            input.nextLine();
            return mainMenu();
        }
    }
    public static int mainMenuSubMenus(int index) {
        int choice = -1;
        try {
            System.out.println(menus.getSubMenu(index).getMenus());
            if (index != 6) {
                    if (index == 0) {
                        System.out.println("Enter -1 to return to the previous menu");
                        choice = input.nextInt();
                        input.nextLine();
                        if (choice > 9 || choice < 0 && choice != -1) {
                            System.out.println("Invalid input. Press enter to continue");
                            input.nextLine();
                            return mainMenuSubMenus(index);
                        }
                    }
                    else if (index == 4) {
                        //TODO create the if structure for this when this part of program is created
                        //This is for the prebuilt computers
                    }
            }
            else {
                return -2;
            }
            return choice;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            input.nextLine();
            return mainMenuSubMenus(index);
        }
    }
    public static void partList(int index, int menuChoice) {
        try {
            System.out.println(menus.getSubMenu(0).getSubMenu(index));
            System.out.println("Enter the index of the part you want to add to your computer." +
                    "\nIf you want to view the part details, enter the index followed by v" +
                    "\nIf you want to return to the previous menu, enter -1");
            String partChoice = input.next();
            int partChoice2 = Integer.parseInt(partChoice.substring(0, 1));
            input.nextLine();
            if (partChoice.contains("v")) {
                PCComponent component = referenceData.getComponent(partChoice2, menuChoice);
                System.out.println(referenceData.getComponent(partChoice2, menuChoice));
                System.out.println("Enter y if you would like to add this or n if you would to return to the previous menu");
                String choice = input.next();
                if (choice.equals("y")) {

                    currentComputer.addComponent(component);
                    System.out.println(currentComputer.computerCost());
                }
                else {
                    partList(index+1, menuChoice);
                }
            }
            else if (partChoice2 == -1) {
                int choice2 = mainMenuSubMenus(0);
                partList(choice2-1, choice2);
            }
            else {
                currentComputer.addComponent(referenceData.getComponent(partChoice2, menuChoice));
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
    }*/

    /*public static void menus() {
        boolean hasExited = false;
        while (!hasExited) {
            int menuChoice = menuLevel1();
            input.nextLine();
            if (menuChoice == 1) {
                System.out.println(levelOneMenus[1]);
                menuLevel2();
            }
            else if (menuChoice == 2) {
                System.out.println(levelOneMenus[2]);
            }
            else if (menuChoice == 3) {
                System.out.println(levelOneMenus[3]);
            }
            else if (menuChoice == 4) {
                System.out.println(levelOneMenus[4]);
            }
            else if (menuChoice == 5) {
                System.out.println(levelOneMenus[5]);
                //navigate to prebuilt list and work with user from there
            }
            else if (menuChoice == 6) {
                System.out.println(levelOneMenus[6]);
            }
            else if (menuChoice == 7) {
                hasExited = true;
            }
            else {
                System.out.println("Invalid input");
                menus();
            }
        }
    }

    private static int menuLevel1() {
        System.out.println(levelOneMenus[0]);
        return input.nextInt();
    }

    public static void menuLevel2() {
        int menuChoice = input.nextInt();
        input.nextLine();
        if (menuChoice > 9 || menuChoice < 1) {
            System.out.println("Invalid input");
            System.out.println(levelOneMenus[1]);
            menuLevel2();
        }
        System.out.println(levelTwoMenus[menuChoice - 1]);
        System.out.println("Enter the number of the part you want to select or enter 0 to go back to the main menu. " +
                "\nYou may also enter v after the number to view the part details:");
        menuLevel3(menuChoice);
    }
    public static void menuLevel3(int menuChoice) {
        String partChoice = input.nextLine();
        String finalPartChoice = "";
        if (partChoice.contains("v")) {
            System.out.println(referenceData.getComponent(removeV(partChoice), menuChoice));
            System.out.println("\nEnter y to select this part or n to go back to the previous menu: ");
            finalPartChoice = input.nextLine();
            if (finalPartChoice.equals("y")) {
                currentComputer.addComponent(referenceData.getComponent(removeV(partChoice), menuChoice));
            }
            else if (finalPartChoice.equals("n")) {
                menuLevel2();
            }
            else {
                System.out.println("Invalid input");
                menuLevel2();
            }
        }
        else if (partChoice.equals("0")) {
            menus();
        }
        else if (Integer.parseInt(partChoice) > 0 && Integer.parseInt(partChoice) <= referenceData.getComponentList(Integer.parseInt(partChoice))) {
            currentComputer.addComponent(referenceData.getComponent(Integer.parseInt(partChoice), menuChoice));
        }
        else {
            System.out.println("Invalid input");
            menuLevel2();
        }
    }
    public static int removeV(String partChoice) {
        while (partChoice.contains("v")) {
            partChoice = partChoice.substring(0, partChoice.length() - 1);
        }
        return Integer.parseInt(partChoice);
    }*/



    /**
     * For setting up json file and adding data to file. Not used in final program.
     */
    public static void serializeRefData()
    {
        String[][] compatibleMotherboard = new String[][] {{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73"}, {"Memory Kits", "CMK32GX5M2B5600C36", "F5-6000J3636F16GX2-TZ5RK", "F5-6400J3239G32GX2-TZ5RK"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        String[][] compatibleMotherboard2 = new String[][] {{"CPUs", "100-100000593WOF", "100-100001015BOX", "100-100000910WOF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73"}, {"Memory Kits", "CMK16GX4M2B3200C16", "SP016GXLZU320BDAJ5", "AX4U32008G16A-DW50"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        String[][] compatibleMotherboard3 = new String[][] {{"CPUs", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73"}, {"Memory Kits", "CMK32GX5M2B5600C36", "F5-6000J3636F16GX2-TZ5RK", "F5-6400J3239G32GX2-TZ5RK"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        String[][] compatibleMotherboard4 = new String[][] {{"CPUs", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73"}, {"Memory Kits", "CMK16GX4M2B3200C16", "SP016GXLZU320BDAJ5", "AX4U32008G16A-DW50"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        Motherboard motherboard = new Motherboard(compatibleMotherboard, "Gigabyte Z790 AORUS ELITE AX ATX LGA1700 Motherboard", "Z790 AORUS ELITE AX", 254.99, "LGA1700", "Intel Z790", "ATX", 4, 6, "Gigabyte", "DDR5", 0, "Black", 128, 7600, 3, 0, 0, 0, true, 4, 0, 0, 0, "1 x 2.5 Gb/s (Realtek)", 2, 1, 0, 1, 0, false, "Wi-Fi 6E", true);
        Motherboard motherboard3 = new Motherboard(compatibleMotherboard3, "Asus TUF GAMING X570-PLUS (Wi-Fi) ATX AM4 Motherboard", "TUF GAMING X570-PLUS (Wi-Fi)", 209.99, "AM4", "AMD X570", "ATX", 4, 8, "Asus", "DDR4", 0, "Black/Gold", 128, 4400, 2, 0, 0, 2, true, 2, 0, 0, 0, "1 x 1Gb/s (Realtek L8200A)", 2, 1, 0, 0, 0, false, "Wi-Fi 5", true);
        Motherboard motherboard2 = new Motherboard(compatibleMotherboard3, "Gigabyte B650 GAMING X AX ATX AM5 Motherboard", "B650 GAMING X AX", 179.99, "AM5", "AMD B650", "ATX", 4, 4, "Gigabyte", "DDR5", 0, "Black/Gray", 128, 6400, 3, 0, 0, 0, false, 3, 0, 0, 0, "1 x 2.5 Gb/s (Realtek)", 2, 1, 0, 0, 1, false, "Wi-Fi 6E", true);
        Motherboard motherboard4 = new Motherboard(compatibleMotherboard4, "MSI MAG B660 TOMAHAWK WIFI DDR4 ATX LGA1700 Motherboard", "MAG B660 TOMAHAWK WIFI DDR4", 189.99, "LGA1700", "Intel B660", "ATX", 4, 6, "MSI", "DDR4", 0, "Black/Silver", 128, 4800, 2, 0, 0, 1,true, 4, 0, 0, 0, "1 x 2.5 Gb/s (Realtek RTL8125B-CG)", 2, 1, 0, 1, 0, false, "Wi-Fi 6", true); //MAG B660 TOMAHAWK WIFI DDR4
        Motherboard motherboard5 = new Motherboard(compatibleMotherboard, "Asus ROG MAXIMUS Z790 HERO ATX LGA1700 Motherboard", "ROG MAXIMUS Z790 HERO", 559.99, "LGA1700", "Intel Z790", "ATX", 4, 6, "Asus", "DDR5", 0, "Black", 128, 7800, 3, 0, 0, 0, true, 3, 0, 0, 0, "1 x 2.5 Gb/s (Intel)", 2, 2, 0, 0, 1, false, "Wi-Fi 6E", true); //ROG MAXIMUS Z790 HERO
        //Fill in these motherboards
        Motherboard motherboard6 = new Motherboard(compatibleMotherboard2, "MSI MAG X670E TOMAHAWK WIFI ATX AM5 Motherboard", "MAG X670E TOMAHAWK WIFI", 309.99, "AM5", "AMD X670E", "ATX", 4, 4, "MSI", "DDR5", 0, "Black", 192, 6600, 3, 0, 0, 1, false, 4, 0, 0, 0, "1 x 2.5 Gb/s (Realtek RTL8125BG)", 2, 2, 0, 1, 0, false, "Wi-Fi 6E", true); //MAG X670E TOMAHAWK WIFI
        // ROG STRIX X670E-E GAMING WIFI
        Motherboard motherboard7 = new Motherboard(compatibleMotherboard2, "Asus ROG STRIX X670E-E GAMING WIFI ATX AM5 Motherboard", "ROG STRIX X670E-E GAMING WIFI", 482.99, "AM5", "AMD X670E", "ATX", 4, 4, "Asus", "DDR5", 0, "Black/Silver", 128, 6400, 3, 0, 0, 0, false, 4, 0, 0, 0, "1 x 2.5 Gb/s (Intel)", 3, 1, 0, 0, 1, false, "Wi-Fi 6E", true); //ROG STRIX X670E-E GAMING WIFI
        //MAG B550 TOMAHAWK
        Motherboard motherboard8 = new Motherboard(compatibleMotherboard2, "MSI MAG B550 TOMAHAWK ATX AM4 Motherboard", "MAG B550 TOMAHAWK", 169.99, "AM4", "AMD B550", "ATX", 4, 6, "MSI", "DDR4", 0, "Black/Silver", 128, 4866, 2, 0, 0, 2, true, 4, 0, 0, 0, "1 x 1 Gb/s\n1 x 2.5 Gb/s", 2, 1, 0, 1, 0, false, "None", true); //MAG B550 TOMAHAWK
        //Prime B450M-A II
        Motherboard motherboard9 = new Motherboard(compatibleMotherboard2, "Asus Prime B450M-A II Micro ATX AM4 Motherboard", "Prime B450M-A II", 79.98, "AM4", "AMD B450", "Micro ATX", 4, 6, "Asus", "DDR4", 0, "Black/White", 128, 4400, 1, 0, 0, 2, false, 1, 0, 0, 0, "1 x 1 Gb/s", 2, 1, 0, 0, 0, false, "None", true); //Prime B450M-A II
        String[][] compatibleCPU1 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO"}};
        String[][] compatibleCPU2 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO"}};
        String[][] compatibleCPU3 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO"}};
        String[][] compatibleCPU4 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI", "ROG STRIX X670E-E GAMING WIFI"}};
        String[][] compatibleCPU5 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI", "ROG STRIX X670E-E GAMING WIFI"}};
        String[][] compatibleCPU6 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI", "ROG STRIX X670E-E GAMING WIFI"}};
        String[][] compatibleCPU7 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        String[][] compatibleCPU8 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        String[][] compatibleCPU9 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        CPU CPU1 = new CPU(compatibleCPU1, "Intel", "Intel Core i9-13900K 3 GHz 24-Core Processor", "BX8071513900K", 559.99, 24, 3, 5.8, 125, "Intel Core i9", "Raptor Lake", "Raptor Lake", "LGA1700", "Intel UHD Graphics 770", 128, true, false, "Boxed", "8 x 32 kB Instruction, 8 x 48 kB Data", "16 x 32 kB Instruction, 16 x 64 kB Data", "8 x 2 MB", "4 x 4 MB", "1 x 36 MB", 10, false, "Yes: Hyper-Threading");
        CPU CPU2 = new CPU(compatibleCPU2, "Intel", "Intel Core i7-13700K 3.4 GHz 16-Core Processor", "BX8071513700K", 419.99, 16, 3.4, 5.4, 125, "Intel Core i7", "Raptor Lake", "Raptor Lake", "LGA1700", "Intel UHD Graphics 770", 128, true, false, "Boxed", "8 x 32 kB Instruction, 8 x 48 kB Data", "8 x 32 kB Instruction, 8 x 64 kB Data", "8 x 2 MB", "2 x 4 MB", "1 x 30 MB", 10, false, "Yes: Hyper-Threading");
        CPU CPU3 = new CPU(compatibleCPU3, "Intel", "Intel Core i7-12700KF 3.6 GHz 12-Core Processor", "BX8071512700KF", 294.99, 12, 3.6, 5, 125, "Intel Core i7", "Alder Lake", "Alder Lake", "LGA1700", "None", 128, false, false, "Boxed", "8 x 32 kB Instruction, 8 x 48 kB Data", "4 x 32 kB Instruction, 4 x 64 kB Data", "8 x 1.25 MB", "1 x 2 MB", "1 x 25 MB", 10, false, "Yes: Hyper-Threading");
        CPU CPU4 = new CPU(compatibleCPU4, "AMD", "AMD Ryzen 5 7600X 4.7 GHz 6-Core Processor", "100-100000593WOF", 241.83, 6, 4.7, 5.3, 105, "AMD Ryzen 5", "Zen 4", "Raphael", "AM5", "Radeon", 128, true, false, "Boxed", "6 x 32 kB Instruction, 6 x 32 kB Data", "None", "6 x 1 MB", "None", "1 x 32 MB", 5, false, "Yes");
        CPU CPU5 = new CPU(compatibleCPU5, "AMD", "AMD Ryzen 5 7600 3.8 GHz 6-Core Processor", "100-100001015BOX", 219.99, 6, 3.8, 5.1, 65, "AMD Ryzen 5", "Zen 4", "Raphael", "AM5", "Radeon", 128, true, true, "Boxed", "6 x 32 kB Instruction, 6 x 32 kB Data", "None", "6 x 1 MB", "None", "1 x 32 MB", 5, true, "Yes");
        CPU CPU6 = new CPU(compatibleCPU6, "AMD", "AMD Ryzen 7 7800X3D 4.2 GHz 8-Core Processor", "100-100000910WOF", 449.00, 8, 4.2, 5, 120, "AMD Ryzen 7", "Zen 4", "Raphael", "AM5", "Radeon", 128, true, false, "Boxed", "8 x 32 kB Instruction, 8 x 32 kB Data", "None", "8 x 1 MB", "None", "1 x 96 MB", 5, false, "Yes");
        CPU CPU7 = new CPU(compatibleCPU7, "AMD", "AMD Ryzen 5 5600X 3.7 GHz 6-Core Processor", "100-100000065BOX", 148.99, 6, 3.7, 4.6, 65, "AMD Ryzen 5", "Zen 3", "Vermeer", "AM4", "None", 128, false, true, "Boxed", "6 x 32 kB Instruction, 6 x 32 kB Data", "None", "6 x 512 kB", "None", "1 x 32 MB", 7, true, "Yes");
        CPU CPU8 = new CPU(compatibleCPU8, "AMD", "AMD Ryzen 7 5800X 3.8 GHz 8-Core Processor", "100-100000063WOF", 229.00, 8, 3.8, 4.7, 105, "AMD Ryzen 7", "Zen 3", "Vermeer", "AM4", "None", 128, false, false, "Boxed", "8 x 32 kB Instruction, 8 x 32 kB Data", "None", "8 x 512 kB", "None", "1 x 32 MB", 7, false, "Yes");
        CPU CPU9 = new CPU(compatibleCPU9, "AMD", "AMD Ryzen 9 5950X 3.4 GHz 16-Core Processor", "100-100000059WOF", 459.00, 16, 3.4, 4.9, 105, "AMD Ryzen 9", "Zen 3", "Vermeer", "AM4", "None", 128, false, false, "Boxed", "16 x 32 kB Instruction, 16 x 32 kB Data", "None", "16 x 512 kB", "None", "2 x 32 MB", 7, false, "Yes");
        CaseFans casefan1 = new CaseFans("Corsair iCUE SP120 RGB ELITE 47.7 CFM 120 mm Fans 3-Pack", "Corsair", "CO-9050109-WW", 71.98, "iCUE SP120 RGB ELITE", 120, "Black/White", 3, "400 - 1500 RPM", "---", "---", true, "Addressable RGB", "4-pin PWM + proprietary RGB", "USB", "1.46 mmH2O");
        CaseFans casefan2 = new CaseFans("Lian Li UNI SL120 58.54 CFM 120 mm Fans 3-Pack", "Lian Li", "UF-SL120-3W", 96.95, "UNI SL120", 120, "White", 3, "800 - 1900 RPM","58.54 CFM", "17 - 31 dB", true, "Addressable RGB", "4-pin PWM + proprietary RGB", "USB", "2.54 mmH2O");
        CaseFans casefan3 = new CaseFans("Noctua A12x25 PWM 60.1 CFM 120 mm Fan", "Noctua", "NF-A12x25 PWM", 32.95, "A12x25 PWM", 120, "Brown", 1, "450 - 2000 RPM", "49.73 - 60.1 CFM", "18.8 - 22.6 dB", true, "None", "4-pin PWM", "None", "2.34 mmH2O");
        String[][] compatibleCase1 = new String[][]{
                {
                    "Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                    "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"
                },
                {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"},
                {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"},
                {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"},
                {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        String[][] compatibleCase2 = new String[][]{
                {
                    "Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                    "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"
                 },
                {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"},
                {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"},
                {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"},
                {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        String[][] compatibleCase3 = new String[][]{
                {
                        "Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                        "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"
                },
                {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"},
                {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"},
                {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"},
                {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}};
        Case case1 = new Case(compatibleCase1, "Lian Li O11 Dynamic EVO ATX Mid Tower Case", "Lian Li", "PC-O11DEW", 157.99, "ATX Mid Tower", "White/Gray", false, "Tempered Glass", true, "USB 3.2 Gen 2 Type C, USB 3.2 Gen 1 Type A", new String[]{"ATX", "EATX", "Micro ATX", "Mini ITX"}, 422, 16.614, new String[]{"6 x internal 3.5\"", "3 x Internal 2.5\""}, new String[]{"8 x Full Height"}, "446 x 272 x 445", "17.6 x 10.7 x 17.5", 53.98, 1.91);
        Case case2 = new Case(compatibleCase2, "Corsair 4000D Airflow ATX Mid Tower Case", "Corsair", "CC-9011200-WW", 94.99, "ATX Mid Tower", "Black", false, "Tinted Tempered Glass", true, "USB 3.2 Gen 1 Type C, USB 3.2 Gen 1 Type A", new String[]{"ATX", "EATX", "Micro ATX", "Mini ITX"}, 360, 14.173, new String[]{"2 x internal 3.5\"", "2 x Internal 2.5\""}, new String[]{"7 x Full Height"}, "453 x 230 x 466", "17.8 x 9.1 x 18.3", 48.553, 1.715);
        Case case3 = new Case(compatibleCase3, "NZXT H5 Flow ATX Mid Tower Case", "NZXT", "CC-H51FB-01", 94.99, "ATX Mid Tower", "Black", false, "Tempered Glass", true, "USB 3.2 Gen 2 Type C, USB 3.2 Gen 1 Type A", new String[]{"ATX", "EATX", "Micro ATX", "Mini ITX"}, 365, 14.37, new String[]{"1 x internal 3.5\"", "1 x Internal 2.5\""}, new String[]{"7 x Full Height"}, "446 x 227 x 464", "17.6 x 8.9 x 18.3", 46.976, 1.659);
        String[][] compatibleCPUCooler1 = new String[][]{{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF", "100-100000593WOF", "100-100001015BOX", "100-100000910WOF", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        String[][] compatibleCPUCooler2 = new String[][]{{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF", "100-100000593WOF", "100-100001015BOX", "100-100000910WOF", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        String[][] compatibleCPUCooler3 = new String[][]{{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF", "100-100000593WOF", "100-100001015BOX", "100-100000910WOF", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        CPUCooler cpuCooler1 = new CPUCooler(compatibleCPUCooler1,"Cooler Master", "Cooler Master MASTERLIQUID ML240L RGB V2 65.59 CFM Liquid CPU Cooler", "MLW-D24M-A18PC-R2", 89.99, "MASTERLIQUID ML240L RGB V2", "650 - 1800", "6-27 dB", "Black", new String[]{"AM2", "AM2+", "AM3", "AM3+", "AM4", "AM5", "FM1", "FM2", "FM2+", "LGA1150", "LGA 1151", "LGA 1155", "LGA 1156", "LGA 1200", "LGA 1366", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"}, "Yes - 240mm", "No");;
        CPUCooler cpuCooler2 = new CPUCooler(compatibleCPUCooler2, "Noctua", "Noctua NH-D15 chromax.black 82.52 CFM CPU Cooler", "NH-D15 CHROMAX.BLACK", 119.95, "NH-D15 chromax.black", "300 - 1500", "19.2 - 24.6 dB", "Black", new String[]{"AM2", "AM2+", "AM3", "AM3+", "AM4", "AM5", "FM1", "FM2", "FM2+", "LGA1150", "LGA 1151", "LGA 1155", "LGA 1156", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"}, "Yes - 140mm", "No");
        CPUCooler cpuCooler3 = new CPUCooler(compatibleCPUCooler3, "NZXT", "NZXT Kraken Z73 73.11 CFM Liquid CPU Cooler", "RL-KRZ73-01", 279.99, "Kraken Z73", "500 - 1800", "21 - 36 dB", "Black", new String[]{"AM4", "AM5", "sTR4", "sTRX4", "LGA1150", "LGA 1151", "LGA 1155", "LGA 1156", "LGA 1200", "LGA 1366", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"}, "Yes - 360mm", "No");
        String[][] compatibleMemoryKit1 = new String[][]{{"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK"}};
        String[][] compatibleMemoryKit2 = new String[][]{{"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK"}};
        String[][] compatibleMemoryKit3 = new String[][]{{"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK"}};
        String[][] compatibleMemoryKit4 = new String[][]{{"Motherboards", "TUF GAMING X570-PLUS (Wi-Fi)", "MAG B660 TOMAHAWK WIFI DDR4", "Prime B450M-A II", "MAG B550 TOMAHAWK" }};
        String[][] compatibleMemoryKit5 = new String[][]{{"Motherboards", "TUF GAMING X570-PLUS (Wi-Fi)", "MAG B660 TOMAHAWK WIFI DDR4", "Prime B450M-A II", "MAG B550 TOMAHAWK" }};
        String[][] compatibleMemoryKit6 = new String[][]{{"Motherboards", "TUF GAMING X570-PLUS (Wi-Fi)", "MAG B660 TOMAHAWK WIFI DDR4", "Prime B450M-A II", "MAG B550 TOMAHAWK" }};
        MemoryKits memoryKit1 = new MemoryKits(compatibleMemoryKit1, "Corsair", "CMK32GX5M2B5600C36", "Corsair Vengeance 32 GB (2 x 16 GB) DDR5-5600 CL36 Memory", 94.99, "DDR5-5600", "288-pin DIMM (DDR5)", "2 x 16GB", 2.906 ,"Black", 12.857, 36, 1.25, "36-36-36-76", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKit2 = new MemoryKits(compatibleMemoryKit2, "G.Skill", "F5-6000J3636F16GX2-TZ5RK", "G.Skill Trident Z5 RGB 32 GB (2 x 16 GB) DDR5-6000 CL36 Memory", 109.99, "DDR5-6000", "288-pin DIMM (DDR5)", "2 x 16GB", 3.437,"Black", 12, 36, 1.35, "36-36-36-96", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKit3 = new MemoryKits(compatibleMemoryKit3, "G.Skill", "F5-6400J3239G32GX2-TZ5RK", "G.Skill Trident Z5 RGB 64 GB (2 x 32 GB) DDR5-6400 CL32 Memory", 237.99, "DDR5-6400", "288-pin DIMM (DDR5)", "2 x 32GB", 3.719,"Black/Silver", 10, 32, 1.4, "32-39-39-102", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKits4 = new MemoryKits(compatibleMemoryKit4, "Corsair", "CMK16GX4M2B3200C16", "Corsair Vengeance LPX 16 GB (2 x 8 GB) DDR4-3200 CL16 Memory", 39.99, "DDR4-3200", "288-pin DIMM (DDR4)", "2 x 8GB", 2.499, "Black/Yellow", 10, 16, 1.35, "16-18-18-36", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKits5 = new MemoryKits(compatibleMemoryKit5, "Silicon Power", "SP016GXLZU320BDAJ5", "Silicon Power GAMING 16 GB (2 x 8 GB) DDR4-3200 CL16 Memory", 29.97, "DDR4-3200", "288-pin DIMM (DDR4)", "2 x 8GB", 1.873, "Black/Gray", 10, 16, 1.35, "16-18-18-38", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKits6 = new MemoryKits(compatibleMemoryKit6, "ADATA", "AX4U32008G16A-DW50", "ADATA XPG SPECTRIX D50 16 GB (2 x 8 GB) DDR4-3200 CL16 Memory", 43.99, "DDR4-3200", "288-pin DIMM (DDR4)", "2 x 8GB", 2.749, "White", 10, 16, 1.35, "16-20-20", "Non-ECC/Unbuffered", true);
        String[][] compatibleGPU1 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}};
        String[][] compatibleGPU2 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}};
        String[][] compatibleGPU3 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}};
        GPU gpu1 = new GPU(compatibleGPU1, "MSI", "RTX3060Ventus2X12GOC", "MSI GeForce RTX 3060 Ventus 2X 12G GeForce RTX 3060 12GB 12 GB Video Card", 289.99, "GeForce RTX 3060 12GB", 12, "GDDR6", 1320, 1777, 15000, "PCIe x 16", "Black", "G-Sync", 235, 170, 2, 2, "2 Fans", "1 PCIe 8-pin", "1 HDMI Outputs", "3 DisplayPort Outputs");
        GPU gpu2 = new GPU(compatibleGPU2, "Asus", "TUF-RTX4070TI-12G-GAMING", "Asus TUF GAMING GeForce RTX 4070 Ti 12 GB Video Card", 799.99, "GeForce RTX 4070 Ti", 12, "GDDR6X", 2310, 2640, 21000, "PCIe x 16", "Black", "G-Sync", 305, 285, 2, 4, "3 Fans", "1 PCIe 16-pin", "2 HDMI 2.1a Outputs", "3 DisplayPort 1.4a Outputs");
        GPU gpu3 = new GPU(compatibleGPU3, "Gigabyte", "GV-R66EAGLE-8GD", "Gigabyte EAGLE Radeon RX 6600 8 GB Video Card", 199.99, "Radeon RX 6600", 8, "GDDR6", 1626, 2491, 14000, "PCIe x 16", "Black/Silver", "FreeSync", 282, 132, 2, 2, "3 Fans", "1 PCIe 8-pin", "2 HDMI Outputs", "2 DisplayPort Outputs");
        String[][] compatiblePowerSupply1 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
            "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"GPUs", "RTX3060Ventus2X12GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}};
        String[][] compatiblePowerSupply2 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"GPUs", "RTX3060Ventus2X12GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}};
        String[][] compatiblePowerSupply3 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"GPUs", "RTX3060Ventus2X12GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}};
        PowerSupply powerSupply = new PowerSupply(compatiblePowerSupply1, "Corsair", "CP-9020200-NA", "Corsair RM850x (2021) 850 W 80+ Gold Certified Fully Modular ATX Power Supply", 149.99, "ATX", "80+ Gold", 850, 160, "Full", "Black", false, 0, 3, 0, 0, 0, 4, 0, 14, 4);
        PowerSupply powerSupply2 = new PowerSupply(compatiblePowerSupply2, "Corsair", "CP-9020262-NA", "Corsair RM750e (2023) 750 W 80+ Gold Certified Fully Modular ATX Power Supply", 99.99, "ATX", "80+ Gold", 750, 140, "Full", "Black", false, 0, 2, 1, 0, 0, 3, 0, 7, 4);
        PowerSupply powerSupply3 = new PowerSupply(compatiblePowerSupply3, "Corsair", "CP-9020201-NA", "Corsair RM1000x (2021) 1000 W 80+ Gold Certified Fully Modular ATX Power Supply", 174.99, "ATX", "80+ Gold", 1000, 180, "Full", "Black", false, 0, 3, 0, 0, 0, 4, 0, 14, 8);
        String[][] compatibleStorage1 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        String[][] compatibleStorage2 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        String[][] compatibleStorage3 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}};
        Storage storage = new Storage(compatibleStorage1, "Samsung", "Samsung 970 Evo Plus 1 TB M.2-2280 PCIe 3.0 X4 NVME Solid State Drive", "MZ-V7S1T0B/AM", 69.98, "1 TB", 0.070, "SSD", 1024, "M.2-2280", "M.2 PCIe 3.0 x 4", true);
        Storage storage2 = new Storage(compatibleStorage2, "Samsung", "Samsung 980 Pro 2 TB M.2-2280 PCIe 4.0 X4 NVME Solid State Drive", "MZ-V8P2T0B/AM", 129.99, "2 TB", 0.065, "SSD", 2048, "M.2-2280", "M.2 PCIe 4.0 x 4", true);
        Storage storage3 = new Storage(compatibleStorage3, "Seagate", "Seagate Barracuda Compute 2 TB 3.5\" 7200 RPM Internal Hard Drive", "ST2000DM008", 49.99, "2 TB", 0.025, "HDD - 7200 RPM", 256, "3.5\"", "SATA 6.0 Gb/s", false);


        ReferenceData refData = new ReferenceData();
        refData.setCaseFans(new CaseFans[]{casefan1, casefan2, casefan3});
        refData.setCases(new Case[]{case1, case2, case3});
        refData.setCPUs(new CPU[]{CPU1, CPU2, CPU3, CPU4, CPU5, CPU6, CPU7, CPU8, CPU9});
        refData.setCPUCoolers(new CPUCooler[]{cpuCooler1, cpuCooler2, cpuCooler3});
        refData.setGPUs(new GPU[]{gpu1, gpu2, gpu3});
        refData.setMemoryKits(new MemoryKits[]{memoryKit1, memoryKit2, memoryKit3, memoryKits4, memoryKits5, memoryKits6});
        refData.setMotherboards(new Motherboard[]{motherboard, motherboard2, motherboard3, motherboard4, motherboard5, motherboard6, motherboard7, motherboard8, motherboard9});
        refData.setPowerSupplies(new PowerSupply[]{powerSupply, powerSupply2, powerSupply3});
        refData.setStorages(new Storage[]{storage, storage2, storage3});

        try (Writer writer = new FileWriter("referenceData.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(refData, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}