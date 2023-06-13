/**
 * Main class for the PC Builder program.
 * Description of the program: This program allows the user to build a computer by selecting components from a menu.
 * The user can also view the computer they have built, and print a receipt of the computer they have built with the cost of the computer to purchase it
 * The program does not allow for the user to input a component that is not compatible with the other components in the computer
 * Course Code: ICS4U
 * Data: 6/13/2023
 * @Author Hasnain Heryani
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {
    public static void main(String[] args) {
        // Load the reference data from the JSON file
        ReferenceData referenceData = LoadReferenceData("referenceData.json");
        // Sort the reference data
        referenceData.sortReferenceData();
        // Load the menu structure from method below with the hard coded menu structure
        Menu currentMenu = loadMenuStructure(referenceData);
        // Display the main menu
        currentMenu.display();
        // Get the user's choice
        int userChoice;
        // Create a new computer object
        Computer currentComputer = new Computer();
        // Create a 2D array to store the compatible components for the current computer
        String[][] currentCompatibleComponents = null;
        //Runs the program until the user decides to exit
        boolean hasExited = false;
        while (!hasExited) {
            // Get the user's choice
            userChoice = currentMenu.getUserChoice();
            // If the user chooses to exit, exit the program
            if (userChoice <= currentMenu.getMenuOptions().length && currentMenu.getMenuOptions()[userChoice - 1].getDisplayText().equalsIgnoreCase("Exit")) {
                hasExited = true;
            }
            // Else continue the program with the user's choice
            else {
                // If the user chooses to return to the previous menu
                if (userChoice == currentMenu.getMenuOptions().length + 1) {
                    if (currentMenu.getPreviousMenu() != null) {
                        (currentMenu = currentMenu.getPreviousMenu()).display();
                    }
                // If the user chooses to return to the main menu
                } else if (userChoice == currentMenu.getMenuOptions().length + 2) {
                    if (currentMenu.getMainMenu() != null) {
                        (currentMenu = currentMenu.getMainMenu()).display();
                    }
                // If the user any other option
                } else if (userChoice <= currentMenu.getMenuOptions().length) {
                    // If the user chooses an option that is a leaf node in the menu structure
                    if (currentMenu.getMenuOptions()[userChoice - 1].getSubMenu() == null) {
                        // If the user chooses to view the computer
                        if (currentMenu.getKeyIdentifier().equalsIgnoreCase(Menu.VIEW_COMPUTER_IDENTIFIER)) {
                            currentMenu.display(currentComputer);
                        // If the user chooses to build a computer
                        } else if (currentMenu.getKeyIdentifier().equalsIgnoreCase(Menu.BUILD_COMPUTER_REPORT)) {
                            printReceipt(currentComputer);
                            currentMenu = currentMenu.getPreviousMenu();
                        // If the user chooses to see the tutorial
                        } else if (currentMenu.getKeyIdentifier().equalsIgnoreCase(Menu.TUTORIAL)) {
                            createTutorial(currentMenu);
                            currentMenu = currentMenu.getPreviousMenu();
                            currentMenu.display();
                        // If the user chooses to add a component to their computer
                        } else if (!currentMenu.getKeyIdentifier().isEmpty()) {
                            // Get the component from the reference data based on the key identifier of the menu they are on (key identifier is the part number)
                            PCComponent tempComponent = referenceData.getPCComponent(currentMenu.getKeyIdentifier());
                            // If the component exists
                            if (tempComponent != null) {
                                // Global Compatible Components doesn't exist i.e. no components have been added yet
                                if (currentCompatibleComponents == null) {
                                    // Set the current compatible components to the compatible components of the tempComponent
                                    currentCompatibleComponents = tempComponent.getCompatibleComponents();
                                    // Add the tempComponent to the current computer
                                    currentComputer.addComponent(tempComponent);
                                    // If the Global compatible components exists i.e. components have been added
                                } else {
                                    // search for the tempComponent in the current compatible components
                                    if (searchComponent(tempComponent, currentCompatibleComponents)) {
                                        // Add the tempComponent to the current computer
                                        currentComputer.addComponent(tempComponent);
                                        // Set the current compatible components to the intersection of the current compatible components and the compatible components of the tempComponent
                                        currentCompatibleComponents = getIntersection(currentCompatibleComponents, tempComponent.getCompatibleComponents());
                                        //Else the component is not compatible
                                    } else {
                                        System.out.println("Component not compatible.");
                                    }
                                }
                            // Else the component does not exist in data. This should never happen otherwise how the hell did you mess up this badly
                            } else {
                                System.out.println("Component not found.");
                                System.out.println("Please contact the developer of this program. How did you mess up this badly");
                            }
                            // move back to the previous menu and display it
                            currentMenu.getPreviousMenu().display();
                            // set the current menu to the previous menu
                            currentMenu = currentMenu.getPreviousMenu();
                        }
                    // Else the user chooses an option that is not a leaf node in the menu structure
                    } else {
                        // Display the submenu based on the user's choice
                        currentMenu.getMenuOptions()[userChoice - 1].getSubMenu().display();
                        // set the current menu to the selected submenu
                        currentMenu = currentMenu.getMenuOptions()[userChoice - 1].getSubMenu();
                    }
                }
            }
        }
    }

    /**
     * This method creates a hard coded tutorial for the program. Ideally this would be taken from a json file but it would become far too complex for the scope of this project
     * @param currentMenu the current menu the user is on
     * returns void
     */
    private static void createTutorial(Menu currentMenu) {
        //use a linked list and the menu system created to make a tutorial for this program
        TutorialLinkedList tutorial = new TutorialLinkedList();
        // All the menus that will be shown to the user during the tutorial
        tutorial.addToFront(currentMenu.getMainMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[1].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[1].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[2].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[2].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[3].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[3].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[4].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[4].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[5].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[5].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[6].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[6].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[7].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[7].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[8].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[0].getSubMenu().getMenuOptions()[8].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[2].getSubMenu());
        tutorial.addToBack(currentMenu.getMainMenu().getMenuOptions()[2].getSubMenu().getMenuOptions()[0].getSubMenu());
        tutorial.printTutorial();
    }

    /**
     * gets the intersection of the current compatible components and the new compatible components
     * @param currentCompatibleComponents the current compatible components the user has selected
     * @param newCompatibleComponents the new compatible components the user has selected
     * @return String[][] the new compatible components the user has selected
     */
    private static String[][] getIntersection(String[][] currentCompatibleComponents, String[][] newCompatibleComponents) {
        // the intersection of the two arrays that will be returned
            String[][] intersectionResult = new String[9][];
            for (int i = 0; i < 9; i++) {
                // The category name to search for in the current compatible components and new compatible components
                String searchCategoryName = newCompatibleComponents[i][0];
                String[] newComponentCategoryRow = getComponentCategoryRow(newCompatibleComponents, searchCategoryName);
                String[] currentComponentCategoryRow = getComponentCategoryRow(currentCompatibleComponents, searchCategoryName);
                // if the category name is not in the new components then it has reached the end of the new compatible components array and the rest is empty
                //In that case it copies over the rest of the current compatible components array since it is already compatible
                if (newComponentCategoryRow == null)
                {
                    // find the first empty row in the intersection result
                    int startIndex = findEmptyRow(intersectionResult);
                    // copy over the rest of the current compatible components array
                    int j =0;
                    while (j<9 && startIndex < 9 && intersectionResult[startIndex] == null) {
                        // if any row in the middle of current compatible components are empty then skip them
                        if (currentCompatibleComponents[j][0].isEmpty()) {
                            j++;
                        }
                        // else copy over the row
                        else {
                            intersectionResult[startIndex] = currentCompatibleComponents[j];
                            j++;
                            startIndex++;
                        }
                    }
                    // if the intersection result had any null rows in the array then, initialize them with empty strings to prevent null pointer exception later on
                    i = 9;
                    int index = findNullRow(intersectionResult);
                    while (index != -1) {
                        intersectionResult[index] = new String[]{""};
                        index = findNullRow(intersectionResult);
                    }
                }
                // if the category name is not in the current components then copy the new compatible components row over
                else if (currentComponentCategoryRow == null) {
                    int index = findEmptyRow(intersectionResult);
                    if (index != -1) {
                        intersectionResult[index] = newCompatibleComponents[i];
                    }
                }
                // else if the category name is in both the current components and the new components then get the intersection of the two rows
                else
                {
                    String[] intersectionRow = getRowIntersection(newComponentCategoryRow, currentComponentCategoryRow);
                    intersectionResult[i] = intersectionRow;
                    int index = findCategoryRow(currentCompatibleComponents, searchCategoryName);
                    if (index != -1) {
                        currentCompatibleComponents[index] = new String[]{""};
                    }
                }
            }
            return intersectionResult;
        }

    /**
     * gets the row of the category name in the array
     * @param array the array to search in
     * @param categoryName the category name to search for
     * @return an int with the index of the category name in the array
     */
        private static int findCategoryRow(String[][] array, String categoryName) {
            for (int i = 0; i < 9; i++) {
                if (array[i][0].equalsIgnoreCase(categoryName))
                {
                    return i;
                }
            }
            return -1;
        }

    /**
     * Finds all the rows in the array that are null
     * @param array the array to search in
     * @return an int with the index of the first null row in the array
     */
    private static int findNullRow(String[][] array) {
            for (int i = 0; i < 9; i++) {
                if (array[i] == null)
                {
                    return i;
                }
            }
            return -1;
        }

    /**
     * Finds the first empty row in the array
     * @param array the array to search in
     * @return an int with the index of the first empty row in the array
     */
    private static int findEmptyRow(String[][] array) {
        for (int i = 0; i < 9; i++) {
            if (array[i] == null || array[i][0].isEmpty())
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Takes the intersections of two arrays
     * @param newComponentCategoryRow the new component category row
     * @param currentComponentCategoryRow the current component category row
     * @return String[] the intersection of the two arrays
     */
    private static String[] getRowIntersection(String[] newComponentCategoryRow, String[] currentComponentCategoryRow) {
        // the intersection of the two arrays that will be returned
        String[] rowIntersectionResult = new String[Math.min(newComponentCategoryRow.length, currentComponentCategoryRow.length)+1];
        for (int i = 0; i < newComponentCategoryRow.length; i++) {
            for (int j = 0; j < currentComponentCategoryRow.length; j++) {
                // if the two strings are equal then add it to the intersection result
                if (newComponentCategoryRow[i].equalsIgnoreCase(currentComponentCategoryRow[j]))
                {
                        rowIntersectionResult[j] = newComponentCategoryRow[i];
                    /*else {
                        rowIntersectionResult[j] = newComponentCategoryRow[i];
                    }*/
                }
            }
        }
        return rowIntersectionResult;
    }

    /**
     * Gets the row of the component category name in the compatible matrix
     * @param compatibleMatrix the compatible matrix to search in
     * @param componentCategoryName the component category name to search for
     * @return String[] the row of the component category name in the compatible matrix
     */
    private static String[] getComponentCategoryRow(String[][] compatibleMatrix, String componentCategoryName)
        {
            for (int i = 0; i < 9; i++) {
                if (compatibleMatrix[i] == null || compatibleMatrix[i][0].isEmpty())
                {
                    return null;
                }
                else if (compatibleMatrix[i][0].equalsIgnoreCase(componentCategoryName))
                {
                    return compatibleMatrix[i];
                }
            }
            return null;
        }

    /**
     * prints the receipt to a file called Receipt.txt
     * @param currentComputer the computer to print the receipt for
     * Returns nothing
     */
    private static void printReceipt(Computer currentComputer) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt"));
            writer.write("Computer Report\n");
            writer.write(currentComputer.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Receipt printed to file: Receipt.txt");
    }

    /**
     * Searches the components array for the component based on part number to check compatibility
     * @param component the component to search for
     * @param components the components array to search in
     * @return boolean true if the component is compatible, false if not
     */
    private static boolean searchComponent(PCComponent component, String[][] components) {
        // the type of the component
        String type = component.getType() + "s";
        // if the component category row is null then the component is compatible
        if (getComponentCategoryRow(components, type) == null) {
            return true;
        }
            for (int i = 0; i < components.length; i++) {
                for (int j = 0; j < components[i].length; j++) {
                    if (components[i][j] != null && components[i][j].equalsIgnoreCase(component.getPartNumber())) {
                        return true;
                    }
                }
            }
            return false;
        }

    /**
     * Loads the reference data from the json file
     * @param jsonFilePath the path to the json file
     * @return ReferenceData the reference data
     */
    private static ReferenceData LoadReferenceData(String jsonFilePath) {
        //The reference data to be returned
        ReferenceData referenceData = null;
        //The gson object to read the json file
        Gson gson = new Gson();
        // try to read the json file and load the reference data
        try {
            // read the json file into a string
            String json = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            //convert the string into the reference data object
            referenceData = gson.fromJson(json, ReferenceData.class);
        } catch (IOException e) {
            // if the file cannot be read then print an error message
            System.out.println("Reference Data Load Failed. " + e);
        }
        // return the reference data
        return referenceData;
    }

    /**
     * Loads the menu structure based on the reference data
     * @param referenceData the reference data to load the menu structure from
     * @return the root Menu
     */
    private static Menu loadMenuStructure(ReferenceData referenceData) {
        // The arrays from the reference data to load the menu structure from
        Motherboard[] motherboards = referenceData.getMotherboards();
        CPU[] cpus = referenceData.getCPUs();
        GPU[] gpus = referenceData.getGPUs();
        MemoryKits[] memoryKits = referenceData.getMemoryKits();
        Storage[] storages = referenceData.getStorages();
        PowerSupply[] powerSupplies = referenceData.getPowerSupplies();
        Case[] cases = referenceData.getCases();
        CaseFans[] caseFans = referenceData.getCaseFans();
        CPUCooler[] cpuCoolers = referenceData.getCPUCoolers();
        // The menu options for the motherboard list menu
        MenuOption[] motherboardListOptions = new MenuOption[motherboards.length];
        for (int i = 0; i < motherboards.length; i++) {
            // The menu options for the motherboard sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(motherboards[i].toString(), null);
            Menu motherboardSubMenu = new Menu(menuOption, motherboards[i].getName() + "\n", null , null, motherboards[i].getPartNumber());
            motherboardListOptions[i] = new MenuOption(motherboards[i].getName() + " - $" + motherboards[i].getPrice(), motherboardSubMenu);
        }
        // The motherboard list menu with its submenus and options
        Menu motherboardListMenu = new Menu(motherboardListOptions, "Motherboard List", null , null );

        // set the previous menu for the motherboard list menu
        for (int i = 0; i < motherboardListOptions.length; i++) {
            motherboardListOptions[i].getSubMenu().setPreviousMenu(motherboardListMenu);
        }

        // The menu options for the cpu list menu
        MenuOption[] cpuListOptions = new MenuOption[cpus.length];
        for (int i = 0; i < cpus.length; i++) {
            // The menu options for the cpu sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(cpus[i].toString(), null);
            Menu cpuSubMenu = new Menu(menuOption, cpus[i].getName() + "\n", null , null, cpus[i].getPartNumber());
            cpuListOptions[i] = new MenuOption(cpus[i].getName() + " - $" + cpus[i].getPrice(), cpuSubMenu);
        }

        // The cpu list menu with its submenus and options
        Menu cpuListMenu = new Menu(cpuListOptions, "CPU List", null , null );

        // set the previous menu for the cpu list menu
        for (int i = 0; i < cpuListOptions.length; i++) {
            cpuListOptions[i].getSubMenu().setPreviousMenu(cpuListMenu);
        }

        // The menu options for the gpu list menu
        MenuOption[] gpuListOptions = new MenuOption[gpus.length];
        for (int i = 0; i < gpus.length; i++) {
            // The menu options for the gpu sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(gpus[i].toString(), null);
            Menu gpuSubMenu = new Menu(menuOption, gpus[i].getName() + "\n", null , null, gpus[i].getPartNumber());
            gpuListOptions[i] = new MenuOption(gpus[i].getName() + " - $" + gpus[i].getPrice(), gpuSubMenu);
        }

        // The gpu list menu with its submenus and options
        Menu gpuListMenu = new Menu(gpuListOptions, "GPU List", null , null );

        // set the previous menu for the gpu list menu
        for (int i = 0; i < gpuListOptions.length; i++) {
            gpuListOptions[i].getSubMenu().setPreviousMenu(gpuListMenu);
        }

        // The menu options for the memory kit list menu
        MenuOption[] memoryKitListOptions = new MenuOption[memoryKits.length];
        for (int i = 0; i < memoryKits.length; i++) {
            // The menu options for the memory kit sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(memoryKits[i].toString(), null);
            Menu memoryKitSubMenu = new Menu(menuOption, memoryKits[i].getName() + "\n", null , null, memoryKits[i].getPartNumber());
            memoryKitListOptions[i] = new MenuOption(memoryKits[i].getName() + " - $" + memoryKits[i].getPrice(), memoryKitSubMenu);
        }

        // The memory kit list menu with its submenus and options
        Menu memoryKitListMenu = new Menu(memoryKitListOptions, "Memory Kit List", null , null );

        // set the previous menu for the memory kit list menu
        for (int i = 0; i < memoryKitListOptions.length; i++) {
            memoryKitListOptions[i].getSubMenu().setPreviousMenu(memoryKitListMenu);
        }

        // The menu options for the storage list menu
        MenuOption[] storageListOptions = new MenuOption[storages.length];
        for (int i = 0; i < storages.length; i++) {
            // The menu options for the storage sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(storages[i].toString(), null);
            Menu storageSubMenu = new Menu(menuOption, storages[i].getName() + "\n", null , null, storages[i].getPartNumber());
            storageListOptions[i] = new MenuOption(storages[i].getName() + " - $" + storages[i].getPrice(), storageSubMenu);
        }

        // The storage list menu with its submenus and options
        Menu storageListMenu = new Menu(storageListOptions, "Storage List", null , null );

        // set the previous menu for the storage list menu
        for (int i = 0; i < storageListOptions.length; i++) {
            storageListOptions[i].getSubMenu().setPreviousMenu(storageListMenu);
        }

        // The menu options for the power supply list menu
        MenuOption[] powerSupplyListOptions = new MenuOption[powerSupplies.length];
        for (int i = 0; i < powerSupplies.length; i++) {
            // The menu options for the power supply sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(powerSupplies[i].toString(), null);
            Menu powerSupplySubMenu = new Menu(menuOption, powerSupplies[i].getName() + "\n", null , null, powerSupplies[i].getPartNumber());
            powerSupplyListOptions[i] = new MenuOption(powerSupplies[i].getName() + " - $" + powerSupplies[i].getPrice(), powerSupplySubMenu);
        }

        // The power supply list menu with its submenus and options
        Menu powerSupplyListMenu = new Menu(powerSupplyListOptions, "Power Supply List", null , null );
        // set the previous menu for the power supply list menu
        for (int i = 0; i < powerSupplyListOptions.length; i++) {
            powerSupplyListOptions[i].getSubMenu().setPreviousMenu(powerSupplyListMenu);
        }

        // The menu options for the case list menu
        MenuOption[] caseListOptions = new MenuOption[cases.length];
        for (int i = 0; i < cases.length; i++) {
            // The menu options for the case sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(cases[i].toString(), null);
            Menu caseSubMenu = new Menu(menuOption, cases[i].getName() + "\n", null , null, cases[i].getPartNumber());
            caseListOptions[i] = new MenuOption(cases[i].getName() + " - $" + cases[i].getPrice(), caseSubMenu);
        }

        // The case list menu with its submenus and options
        Menu caseListMenu = new Menu(caseListOptions, "Case List", null , null );
        // set the previous menu for the case list menu
        for (int i = 0; i < caseListOptions.length; i++) {
            caseListOptions[i].getSubMenu().setPreviousMenu(caseListMenu);
        }

        // The menu options for the cpu cooler list menu
        MenuOption[] cpuCoolerListOptions = new MenuOption[cpuCoolers.length];
        for (int i = 0; i < cpuCoolers.length; i++) {
            // The menu options for the cpu cooler sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(cpuCoolers[i].toString(), null);
            Menu cpuCoolerSubMenu = new Menu(menuOption, cpuCoolers[i].getName() + "\n", null , null, cpuCoolers[i].getPartNumber());
            cpuCoolerListOptions[i] = new MenuOption(cpuCoolers[i].getName() + " - $" + cpuCoolers[i].getPrice(), cpuCoolerSubMenu);
        }

        // The cpu cooler list menu with its submenus and options
        Menu cpuCoolerListMenu = new Menu(cpuCoolerListOptions, "CPU Cooler List", null , null );
        // set the previous menu for the cpu cooler list menu
        for (int i = 0; i < cpuCoolerListOptions.length; i++) {
            cpuCoolerListOptions[i].getSubMenu().setPreviousMenu(cpuCoolerListMenu);
        }

        // The menu options for the cpu fans list menu
        MenuOption[] caseFansListOptions = new MenuOption[caseFans.length];
        for (int i = 0; i < caseFans.length; i++) {
            // The menu options for the cpu cooler sub menu
            MenuOption[] menuOption = new MenuOption[1];
            menuOption[0] = new MenuOption(caseFans[i].toString(), null);
            Menu caseFansSubMenu = new Menu(menuOption, caseFans[i].getName() + "\n", null , null, caseFans[i].getPartNumber());
            caseFansListOptions[i] = new MenuOption(caseFans[i].getName() + " - $" + caseFans[i].getPrice(), caseFansSubMenu);
        }

        // The cpu fans list menu with its submenus and options
        Menu caseFansListMenu = new Menu(caseFansListOptions, "Case Fans List", null , null );
        // set the previous menu for the cpu fans list menu
        for (int i = 0; i < caseFansListOptions.length; i++) {
            caseFansListOptions[i].getSubMenu().setPreviousMenu(caseFansListMenu);
        }
        //The menu options for configuring a new computer
        MenuOption[] newComputerSubMenuOptions = new MenuOption[9];
        newComputerSubMenuOptions[0] = new MenuOption("Add Motherboard", motherboardListMenu);
        newComputerSubMenuOptions[1] = new MenuOption("Add CPU", cpuListMenu);
        newComputerSubMenuOptions[2] = new MenuOption("Add GPU", gpuListMenu);
        newComputerSubMenuOptions[3] = new MenuOption("Add CPU Cooler", cpuCoolerListMenu);
        newComputerSubMenuOptions[4] = new MenuOption("Add Power Supply", powerSupplyListMenu);
        newComputerSubMenuOptions[5] = new MenuOption("Add Memory Kit", memoryKitListMenu);
        newComputerSubMenuOptions[6] = new MenuOption("Add Storage Drive", storageListMenu);
        newComputerSubMenuOptions[7] = new MenuOption("Add Case", caseListMenu);
        newComputerSubMenuOptions[8] = new MenuOption("Add Case Fans", caseFansListMenu);
        Menu newComputerMenu = new Menu(newComputerSubMenuOptions, "Configure a New computer", null, null);
        // set the previous menu for the new computer menu
        motherboardListMenu.setPreviousMenu(newComputerMenu);
        cpuListMenu.setPreviousMenu(newComputerMenu);
        gpuListMenu.setPreviousMenu(newComputerMenu);
        cpuCoolerListMenu.setPreviousMenu(newComputerMenu);
        powerSupplyListMenu.setPreviousMenu(newComputerMenu);
        memoryKitListMenu.setPreviousMenu(newComputerMenu);
        storageListMenu.setPreviousMenu(newComputerMenu);
        caseListMenu.setPreviousMenu(newComputerMenu);
        caseFansListMenu.setPreviousMenu(newComputerMenu);

        //The menu options for the main menu
        //Building a computer report menu
        MenuOption[] buildComputerReportSubMenuOptions = new MenuOption[1];
        buildComputerReportSubMenuOptions[0] = new MenuOption("Build Computer Report", null);
        Menu buildComputerReportMenu = new Menu(buildComputerReportSubMenuOptions, "Build Computer Report", null, null, Menu.BUILD_COMPUTER_REPORT);
        //View Computer Menu
        MenuOption[] viewComputerSubMenuOptions = new MenuOption[1];
        viewComputerSubMenuOptions[0] = new MenuOption("View My New Computer", null);
        Menu viewComputerMenu = new Menu(viewComputerSubMenuOptions, "View Computer", null, null, Menu.VIEW_COMPUTER_IDENTIFIER);
        //Tutorial Menu
        MenuOption[] tutorial = new MenuOption[1];
        tutorial[0] = new MenuOption("Start Tutorial", null);
        Menu tutorialMenu = new Menu(tutorial, "Tutorial", null, null, Menu.TUTORIAL);
        //Main Menu
        MenuOption[] mainMenuOptions = new MenuOption[5];
        mainMenuOptions[0] = new MenuOption("Configure a New computer", newComputerMenu);
        mainMenuOptions[1] = new MenuOption("Build Computer Report", buildComputerReportMenu);
        mainMenuOptions[2] = new MenuOption("View Computer", viewComputerMenu);
        mainMenuOptions[3] = new MenuOption("Tutorial", tutorialMenu);
        mainMenuOptions[4] = new MenuOption("Exit", null);
        Menu mainMenu = new Menu(mainMenuOptions, "Main Menu", null , null);
        // set the previous menu for all the submenus of the main menu
        buildComputerReportMenu.setPreviousMenu(mainMenu);
        viewComputerMenu.setPreviousMenu(mainMenu);
        tutorialMenu.setPreviousMenu(mainMenu);
        buildComputerReportMenu.setMainMenu(mainMenu);
        viewComputerMenu.setMainMenu(mainMenu);
        tutorialMenu.setMainMenu(mainMenu);

        //sets the main menus for all the 2nd level nodes and leaf nodes
        for (int i = 0; i < motherboardListOptions.length; i++) {
            motherboardListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }

        for (int i = 0; i < cpuListOptions.length; i++) {
            cpuListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }

        for (int i = 0; i < gpuListOptions.length; i++) {
            gpuListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }

        for (int i = 0; i < cpuCoolerListOptions.length; i++) {
            cpuCoolerListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }

        for (int i = 0; i < powerSupplyListOptions.length; i++) {
            powerSupplyListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }

        for (int i = 0; i < memoryKitListOptions.length; i++) {
            memoryKitListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }

        for (int i = 0; i < storageListOptions.length; i++) {
            storageListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }

        for (int i = 0; i < caseListOptions.length; i++) {
            caseListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }

        for (int i = 0; i < caseFansListOptions.length; i++) {
            caseFansListOptions[i].getSubMenu().setMainMenu(mainMenu);
        }
        newComputerMenu.setMainMenu(mainMenu);
        newComputerMenu.setPreviousMenu(mainMenu);
        viewComputerMenu.setMainMenu(mainMenu);
        viewComputerMenu.setPreviousMenu(mainMenu);
        motherboardListMenu.setMainMenu(mainMenu);
        cpuListMenu.setMainMenu(mainMenu);
        gpuListMenu.setMainMenu(mainMenu);
        cpuCoolerListMenu.setMainMenu(mainMenu);
        powerSupplyListMenu.setMainMenu(mainMenu);
        memoryKitListMenu.setMainMenu(mainMenu);
        storageListMenu.setMainMenu(mainMenu);
        caseListMenu.setMainMenu(mainMenu);
        caseFansListMenu.setMainMenu(mainMenu);
        //returns the main menu or root menu
        return mainMenu;
    }
}