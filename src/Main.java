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
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Computer Craft. Are you Crafters ready to build a computer? YES!");
        System.out.println("Let's get started! Press enter to start.");
        input.nextLine();
        System.out.println();
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
                        } else if (currentMenu.getKeyIdentifier().equalsIgnoreCase(Menu.REMOVE_LAST_COMPONENT)) {
                            currentComputer.removeLastComponent();
                            currentComputer.removeCompatibleMatrix();
                            currentMenu.display(currentComputer);
                        } else if (!currentMenu.getKeyIdentifier().isEmpty()) {
                            // Get the component from the reference data based on the key identifier of the menu they are on (key identifier is the part number)
                            PCComponent tempComponent = referenceData.getPCComponent(currentMenu.getKeyIdentifier());
                            // If the component exists
                            if (tempComponent != null) {
                                // Global Compatible Components doesn't exist i.e. no components have been added yet
                                if (currentComputer.getCompatibleMatrix().top() == null) {
                                    // Set the current compatible components to the compatible components of the tempComponent
                                    currentComputer.getCompatibleMatrix().push(tempComponent.getCompatibleComponents());
                                    // Add the tempComponent to the current computer
                                    currentComputer.addComponent(tempComponent);
                                    // If the Global compatible components exists i.e. components have been added
                                } else {
                                    // search for the tempComponent in the current compatible components
                                    if (searchComponent(tempComponent, currentComputer.getCompatibleMatrix().top())) {
                                        // Add the tempComponent to the current computer
                                        currentComputer.addComponent(tempComponent);
                                        // Set the current compatible components to the intersection of the current compatible components and the compatible components of the tempComponent
                                        currentComputer.getCompatibleMatrix().push(getIntersection(currentComputer.getCompatibleMatrix().top(), tempComponent.getCompatibleComponents()));
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
        System.out.println("Bye! Have a Great Day!");
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
        tutorial.printTutorial();
        currentMenu = currentMenu.getMainMenu();
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
            menuOption[0] = new MenuOption("\n" + motherboards[i].toString(), null);
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
            menuOption[0] = new MenuOption("\n" + cpus[i].toString(), null);
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
            menuOption[0] = new MenuOption("\n" + gpus[i].toString(), null);
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
            menuOption[0] = new MenuOption("\n" + memoryKits[i].toString(), null);
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
            menuOption[0] = new MenuOption("\n" + storages[i].toString(), null);
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
            menuOption[0] = new MenuOption("\n" + powerSupplies[i].toString(), null);
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
            menuOption[0] = new MenuOption("\n" + cases[i].toString(), null);
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
            menuOption[0] = new MenuOption("\n" + cpuCoolers[i].toString(), null);
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
            menuOption[0] = new MenuOption("\n" + caseFans[i].toString(), null);
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
        //Remove last component menu
        MenuOption[] removeLastComponent = new MenuOption[1];
        removeLastComponent[0] = new MenuOption("Remove Last Component", null);
        Menu removeLastComponentMenu = new Menu(removeLastComponent, "Remove Last Component", null, null, Menu.REMOVE_LAST_COMPONENT);
        //Main Menu
        MenuOption[] mainMenuOptions = new MenuOption[6];
        mainMenuOptions[0] = new MenuOption("Configure a New computer", newComputerMenu);
        mainMenuOptions[1] = new MenuOption("Build Computer Report", buildComputerReportMenu);
        mainMenuOptions[2] = new MenuOption("View Computer", viewComputerMenu);
        mainMenuOptions[3] = new MenuOption("Tutorial", tutorialMenu);
        mainMenuOptions[4] = new MenuOption("Remove Last Component", removeLastComponentMenu);
        mainMenuOptions[5] = new MenuOption("Exit", null);
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
        buildComputerReportMenu.setMainMenu(mainMenu);
        buildComputerReportMenu.setPreviousMenu(mainMenu);
        tutorialMenu.setMainMenu(mainMenu);
        tutorialMenu.setPreviousMenu(mainMenu);
        removeLastComponentMenu.setMainMenu(mainMenu);
        removeLastComponentMenu.setPreviousMenu(mainMenu);
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
    public static void serializeRefData()
    {
        //DDR5 Intel
        String[][] compatibleMotherboard = new String[][] {{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Memory Kits", "CMK32GX5M2B5600C36", "F5-6000J3636F16GX2-TZ5RK", "F5-6400J3239G32GX2-TZ5RK"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}, {""}, {""}};
        //DDR5 AMD
        String[][] compatibleMotherboard2 = new String[][] {{"CPUs", "100-100000593WOF", "100-100001015BOX", "100-100000910WOF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Memory Kits", "CMK32GX5M2B5600C36", "F5-6000J3636F16GX2-TZ5RK", "F5-6400J3239G32GX2-TZ5RK"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}, {""}, {""}};
        //DDR4 AMD
        String[][] compatibleMotherboard4 = new String[][] {{"CPUs", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Memory Kits", "CMK16GX4M2B3200C16", "SP016GXLZU320BDAJ5", "AX4U32008G16A-DW50"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}, {""}, {""}};
        //DDR4 Intel
        String[][] compatibleMotherboard5 = new String[][] {{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF"}, {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73"}, {"Memory Kits", "CMK16GX4M2B3200C16", "SP016GXLZU320BDAJ5", "AX4U32008G16A-DW50"}, {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}, {""}, {""}};
        Motherboard motherboard = new Motherboard(compatibleMotherboard, "Gigabyte Z790 AORUS ELITE AX ATX LGA1700 Motherboard", "Z790 AORUS ELITE AX", 254.99, "LGA1700", "Intel Z790", "ATX", 4, 6, "Gigabyte", "DDR5", 0, "Black", 128, 7600, 3, 0, 0, 0, true, 4, 0, 0, 0, "1 x 2.5 Gb/s (Realtek)", 2, 1, 0, 1, 0, false, "Wi-Fi 6E", true);
        Motherboard motherboard3 = new Motherboard(compatibleMotherboard4, "Asus TUF GAMING X570-PLUS (Wi-Fi) ATX AM4 Motherboard", "TUF GAMING X570-PLUS (Wi-Fi)", 209.99, "AM4", "AMD X570", "ATX", 4, 8, "Asus", "DDR4", 0, "Black/Gold", 128, 4400, 2, 0, 0, 2, true, 2, 0, 0, 0, "1 x 1Gb/s (Realtek L8200A)", 2, 1, 0, 0, 0, false, "Wi-Fi 5", true);
        Motherboard motherboard2 = new Motherboard(compatibleMotherboard2, "Gigabyte B650 GAMING X AX ATX AM5 Motherboard", "B650 GAMING X AX", 179.99, "AM5", "AMD B650", "ATX", 4, 4, "Gigabyte", "DDR5", 0, "Black/Gray", 128, 6400, 3, 0, 0, 0, false, 3, 0, 0, 0, "1 x 2.5 Gb/s (Realtek)", 2, 1, 0, 0, 1, false, "Wi-Fi 6E", true);
        Motherboard motherboard4 = new Motherboard(compatibleMotherboard5, "MSI MAG B660 TOMAHAWK WIFI DDR4 ATX LGA1700 Motherboard", "MAG B660 TOMAHAWK WIFI DDR4", 189.99, "LGA1700", "Intel B660", "ATX", 4, 6, "MSI", "DDR4", 0, "Black/Silver", 128, 4800, 2, 0, 0, 1,true, 4, 0, 0, 0, "1 x 2.5 Gb/s (Realtek RTL8125B-CG)", 2, 1, 0, 1, 0, false, "Wi-Fi 6", true); //MAG B660 TOMAHAWK WIFI DDR4
        Motherboard motherboard5 = new Motherboard(compatibleMotherboard, "Asus ROG MAXIMUS Z790 HERO ATX LGA1700 Motherboard", "ROG MAXIMUS Z790 HERO", 559.99, "LGA1700", "Intel Z790", "ATX", 4, 6, "Asus", "DDR5", 0, "Black", 128, 7800, 3, 0, 0, 0, true, 3, 0, 0, 0, "1 x 2.5 Gb/s (Intel)", 2, 2, 0, 0, 1, false, "Wi-Fi 6E", true); //ROG MAXIMUS Z790 HERO
        //Fill in these motherboards
        Motherboard motherboard6 = new Motherboard(compatibleMotherboard2, "MSI MAG X670E TOMAHAWK WIFI ATX AM5 Motherboard", "MAG X670E TOMAHAWK WIFI", 309.99, "AM5", "AMD X670E", "ATX", 4, 4, "MSI", "DDR5", 0, "Black", 192, 6600, 3, 0, 0, 1, false, 4, 0, 0, 0, "1 x 2.5 Gb/s (Realtek RTL8125BG)", 2, 2, 0, 1, 0, false, "Wi-Fi 6E", true); //MAG X670E TOMAHAWK WIFI
        // ROG STRIX X670E-E GAMING WIFI
        Motherboard motherboard7 = new Motherboard(compatibleMotherboard2, "Asus ROG STRIX X670E-E GAMING WIFI ATX AM5 Motherboard", "ROG STRIX X670E-E GAMING WIFI", 482.99, "AM5", "AMD X670E", "ATX", 4, 4, "Asus", "DDR5", 0, "Black/Silver", 128, 6400, 3, 0, 0, 0, false, 4, 0, 0, 0, "1 x 2.5 Gb/s (Intel)", 3, 1, 0, 0, 1, false, "Wi-Fi 6E", true); //ROG STRIX X670E-E GAMING WIFI
        //MAG B550 TOMAHAWK
        Motherboard motherboard8 = new Motherboard(compatibleMotherboard4, "MSI MAG B550 TOMAHAWK ATX AM4 Motherboard", "MAG B550 TOMAHAWK", 169.99, "AM4", "AMD B550", "ATX", 4, 6, "MSI", "DDR4", 0, "Black/Silver", 128, 4866, 2, 0, 0, 2, true, 4, 0, 0, 0, "1 x 1 Gb/s\n1 x 2.5 Gb/s", 2, 1, 0, 1, 0, false, "None", true); //MAG B550 TOMAHAWK
        //Prime B450M-A II
        Motherboard motherboard9 = new Motherboard(compatibleMotherboard4, "Asus Prime B450M-A II Micro ATX AM4 Motherboard", "Prime B450M-A II", 79.98, "AM4", "AMD B450", "Micro ATX", 4, 6, "Asus", "DDR4", 0, "Black/White", 128, 4400, 1, 0, 0, 2, false, 1, 0, 0, 0, "1 x 1 Gb/s", 2, 1, 0, 0, 0, false, "None", true); //Prime B450M-A II
        String[][] compatibleCPU1 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPU2 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPU3 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPU4 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI", "ROG STRIX X670E-E GAMING WIFI"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPU5 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI", "ROG STRIX X670E-E GAMING WIFI"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPU6 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI", "ROG STRIX X670E-E GAMING WIFI"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPU7 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPU8 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPU9 = new String[][]{{"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"}, {"Motherboards", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        CPU CPU1 = new CPU(compatibleCPU1, "Intel", "Intel Core i9-13900K 3 GHz 24-Core Processor", "BX8071513900K", 559.99, 24, 3, 5.8, 125, "Intel Core i9", "Raptor Lake", "Raptor Lake", "LGA1700", "Intel UHD Graphics 770", 128, true, false, "Boxed", "8 x 32 kB Instruction, 8 x 48 kB Data", "16 x 32 kB Instruction, 16 x 64 kB Data", "8 x 2 MB", "4 x 4 MB", "1 x 36 MB", 10, false, "Yes: Hyper-Threading");
        CPU CPU2 = new CPU(compatibleCPU2, "Intel", "Intel Core i7-13700K 3.4 GHz 16-Core Processor", "BX8071513700K", 419.99, 16, 3.4, 5.4, 125, "Intel Core i7", "Raptor Lake", "Raptor Lake", "LGA1700", "Intel UHD Graphics 770", 128, true, false, "Boxed", "8 x 32 kB Instruction, 8 x 48 kB Data", "8 x 32 kB Instruction, 8 x 64 kB Data", "8 x 2 MB", "2 x 4 MB", "1 x 30 MB", 10, false, "Yes: Hyper-Threading");
        CPU CPU3 = new CPU(compatibleCPU3, "Intel", "Intel Core i7-12700KF 3.6 GHz 12-Core Processor", "BX8071512700KF", 294.99, 12, 3.6, 5, 125, "Intel Core i7", "Alder Lake", "Alder Lake", "LGA1700", "None", 128, false, false, "Boxed", "8 x 32 kB Instruction, 8 x 48 kB Data", "4 x 32 kB Instruction, 4 x 64 kB Data", "8 x 1.25 MB", "1 x 2 MB", "1 x 25 MB", 10, false, "Yes: Hyper-Threading");
        CPU CPU4 = new CPU(compatibleCPU4, "AMD", "AMD Ryzen 5 7600X 4.7 GHz 6-Core Processor", "100-100000593WOF", 241.83, 6, 4.7, 5.3, 105, "AMD Ryzen 5", "Zen 4", "Raphael", "AM5", "Radeon", 128, true, false, "Boxed", "6 x 32 kB Instruction, 6 x 32 kB Data", "None", "6 x 1 MB", "None", "1 x 32 MB", 5, false, "Yes");
        CPU CPU5 = new CPU(compatibleCPU5, "AMD", "AMD Ryzen 5 7600 3.8 GHz 6-Core Processor", "100-100001015BOX", 219.99, 6, 3.8, 5.1, 65, "AMD Ryzen 5", "Zen 4", "Raphael", "AM5", "Radeon", 128, true, true, "Boxed", "6 x 32 kB Instruction, 6 x 32 kB Data", "None", "6 x 1 MB", "None", "1 x 32 MB", 5, true, "Yes");
        CPU CPU6 = new CPU(compatibleCPU6, "AMD", "AMD Ryzen 7 7800X3D 4.2 GHz 8-Core Processor", "100-100000910WOF", 449.00, 8, 4.2, 5, 120, "AMD Ryzen 7", "Zen 4", "Raphael", "AM5", "Radeon", 128, true, false, "Boxed", "8 x 32 kB Instruction, 8 x 32 kB Data", "None", "8 x 1 MB", "None", "1 x 96 MB", 5, false, "Yes");
        CPU CPU7 = new CPU(compatibleCPU7, "AMD", "AMD Ryzen 5 5600X 3.7 GHz 6-Core Processor", "100-100000065BOX", 148.99, 6, 3.7, 4.6, 65, "AMD Ryzen 5", "Zen 3", "Vermeer", "AM4", "None", 128, false, true, "Boxed", "6 x 32 kB Instruction, 6 x 32 kB Data", "None", "6 x 512 kB", "None", "1 x 32 MB", 7, true, "Yes");
        CPU CPU8 = new CPU(compatibleCPU8, "AMD", "AMD Ryzen 7 5800X 3.8 GHz 8-Core Processor", "100-100000063WOF", 229.00, 8, 3.8, 4.7, 105, "AMD Ryzen 7", "Zen 3", "Vermeer", "AM4", "None", 128, false, false, "Boxed", "8 x 32 kB Instruction, 8 x 32 kB Data", "None", "8 x 512 kB", "None", "1 x 32 MB", 7, false, "Yes");
        CPU CPU9 = new CPU(compatibleCPU9, "AMD", "AMD Ryzen 9 5950X 3.4 GHz 16-Core Processor", "100-100000059WOF", 459.00, 16, 3.4, 4.9, 105, "AMD Ryzen 9", "Zen 3", "Vermeer", "AM4", "None", 128, false, false, "Boxed", "16 x 32 kB Instruction, 16 x 32 kB Data", "None", "16 x 512 kB", "None", "2 x 32 MB", 7, false, "Yes");
        CaseFans casefan1 = new CaseFans("Corsair iCUE SP120 RGB ELITE 47.7 CFM 120 mm Fans 3-Pack", "Corsair", "CO-9050109-WW", 71.98, "iCUE SP120 RGB ELITE", 120, "Black/White", 3, "400 - 1500 RPM", "---", "---", true, "Addressable RGB", "4-pin PWM + proprietary RGB", "USB", "1.46 mmH2O", new String[][]{{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}});
        CaseFans casefan2 = new CaseFans("Lian Li UNI SL120 58.54 CFM 120 mm Fans 3-Pack", "Lian Li", "UF-SL120-3W", 96.95, "UNI SL120", 120, "White", 3, "800 - 1900 RPM","58.54 CFM", "17 - 31 dB", true, "Addressable RGB", "4-pin PWM + proprietary RGB", "USB", "2.54 mmH2O", new String[][]{{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}});
        CaseFans casefan3 = new CaseFans("Noctua A12x25 PWM 60.1 CFM 120 mm Fan", "Noctua", "NF-A12x25 PWM", 32.95, "A12x25 PWM", 120, "Brown", 1, "450 - 2000 RPM", "49.73 - 60.1 CFM", "18.8 - 22.6 dB", true, "None", "4-pin PWM", "None", "2.34 mmH2O", new String[][]{{""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}});
        String[][] compatibleCase1 = new String[][]{
                {
                        "Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                        "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"
                },
                {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"},
                {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"},
                {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"},
                {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}, {""}, {""}, {""}, {""}};
        String[][] compatibleCase2 = new String[][]{
                {
                        "Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                        "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"
                },
                {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"},
                {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"},
                {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"},
                {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}, {""}, {""}, {""}, {""}};
        String[][] compatibleCase3 = new String[][]{
                {
                        "Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                        "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"
                },
                {"CPU Coolers", "MLW-D24M-A18PC-R2", "NH-D15 CHROMAX.BLACK", "RL-KRZ73-01"},
                {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"},
                {"GPUs", "RTX3060Ventus2X212GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"},
                {"Storages", "MZ-V7S1T0B/AM", "MZ-V8P2T0B/AM", "ST2000DM008"}, {""}, {""}, {""}, {""}};
        Case case1 = new Case(compatibleCase1, "Lian Li O11 Dynamic EVO ATX Mid Tower Case", "Lian Li", "PC-O11DEW", 157.99, "ATX Mid Tower", "White/Gray", false, "Tempered Glass", true, "USB 3.2 Gen 2 Type C, USB 3.2 Gen 1 Type A", new String[]{"ATX", "EATX", "Micro ATX", "Mini ITX"}, 422, 16.614, new String[]{"6 x internal 3.5\"", "3 x Internal 2.5\""}, new String[]{"8 x Full Height"}, "446 x 272 x 445", "17.6 x 10.7 x 17.5", 53.98, 1.91);
        Case case2 = new Case(compatibleCase2, "Corsair 4000D Airflow ATX Mid Tower Case", "Corsair", "CC-9011200-WW", 94.99, "ATX Mid Tower", "Black", false, "Tinted Tempered Glass", true, "USB 3.2 Gen 1 Type C, USB 3.2 Gen 1 Type A", new String[]{"ATX", "EATX", "Micro ATX", "Mini ITX"}, 360, 14.173, new String[]{"2 x internal 3.5\"", "2 x Internal 2.5\""}, new String[]{"7 x Full Height"}, "453 x 230 x 466", "17.8 x 9.1 x 18.3", 48.553, 1.715);
        Case case3 = new Case(compatibleCase3, "NZXT H5 Flow ATX Mid Tower Case", "NZXT", "CC-H51FB-01", 94.99, "ATX Mid Tower", "Black", false, "Tempered Glass", true, "USB 3.2 Gen 2 Type C, USB 3.2 Gen 1 Type A", new String[]{"ATX", "EATX", "Micro ATX", "Mini ITX"}, 365, 14.37, new String[]{"1 x internal 3.5\"", "1 x Internal 2.5\""}, new String[]{"7 x Full Height"}, "446 x 227 x 464", "17.6 x 8.9 x 18.3", 46.976, 1.659);
        String[][] compatibleCPUCooler1 = new String[][]{{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF", "100-100000593WOF", "100-100001015BOX", "100-100000910WOF", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPUCooler2 = new String[][]{{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF", "100-100000593WOF", "100-100001015BOX", "100-100000910WOF", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleCPUCooler3 = new String[][]{{"CPUs", "BX8071513900K", "BX8071513700K", "BX8071512700KF", "100-100000593WOF", "100-100001015BOX", "100-100000910WOF", "100-100000065BOX", "100-100000063WOF", "100-100000059WOF"}, {"Cases", "CC-9011200-WW", "CC-H51FB-01", "PC-O11DEW"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        CPUCooler cpuCooler1 = new CPUCooler(compatibleCPUCooler1,"Cooler Master", "Cooler Master MASTERLIQUID ML240L RGB V2 65.59 CFM Liquid CPU Cooler", "MLW-D24M-A18PC-R2", 89.99, "MASTERLIQUID ML240L RGB V2", "650 - 1800", "6-27 dB", "Black", new String[]{"AM2", "AM2+", "AM3", "AM3+", "AM4", "AM5", "FM1", "FM2", "FM2+", "LGA1150", "LGA 1151", "LGA 1155", "LGA 1156", "LGA 1200", "LGA 1366", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"}, "Yes - 240mm", "No");;
        CPUCooler cpuCooler2 = new CPUCooler(compatibleCPUCooler2, "Noctua", "Noctua NH-D15 chromax.black 82.52 CFM CPU Cooler", "NH-D15 CHROMAX.BLACK", 119.95, "NH-D15 chromax.black", "300 - 1500", "19.2 - 24.6 dB", "Black", new String[]{"AM2", "AM2+", "AM3", "AM3+", "AM4", "AM5", "FM1", "FM2", "FM2+", "LGA1150", "LGA 1151", "LGA 1155", "LGA 1156", "LGA 1200", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"}, "Yes - 140mm", "No");
        CPUCooler cpuCooler3 = new CPUCooler(compatibleCPUCooler3, "NZXT", "NZXT Kraken Z73 73.11 CFM Liquid CPU Cooler", "RL-KRZ73-01", 279.99, "Kraken Z73", "500 - 1800", "21 - 36 dB", "Black", new String[]{"AM4", "AM5", "sTR4", "sTRX4", "LGA1150", "LGA 1151", "LGA 1155", "LGA 1156", "LGA 1200", "LGA 1366", "LGA 1700", "LGA 2011", "LGA 2011-3", "LGA 2066"}, "Yes - 360mm", "No");
        //FIX THIS MEMORY COMPATIBILITY GARBAGE
        String[][] compatibleMemoryKit1 = new String[][]{{"Motherboards", "Z790 AORUS ELITE AX", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleMemoryKit2 = new String[][]{{"Motherboards", "Z790 AORUS ELITE AX", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleMemoryKit3 = new String[][]{{"Motherboards", "Z790 AORUS ELITE AX", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI"}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleMemoryKit4 = new String[][]{{"Motherboards", "TUF GAMING X570-PLUS (Wi-Fi)", "MAG B660 TOMAHAWK WIFI DDR4", "Prime B450M-A II", "MAG B550 TOMAHAWK" }, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleMemoryKit5 = new String[][]{{"Motherboards", "TUF GAMING X570-PLUS (Wi-Fi)", "MAG B660 TOMAHAWK WIFI DDR4", "Prime B450M-A II", "MAG B550 TOMAHAWK" }, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleMemoryKit6 = new String[][]{{"Motherboards", "TUF GAMING X570-PLUS (Wi-Fi)", "MAG B660 TOMAHAWK WIFI DDR4", "Prime B450M-A II", "MAG B550 TOMAHAWK" }, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}};
        MemoryKits memoryKit1 = new MemoryKits(compatibleMemoryKit1, "Corsair", "CMK32GX5M2B5600C36", "Corsair Vengeance 32 GB (2 x 16 GB) DDR5-5600 CL36 Memory", 94.99, "DDR5-5600", "288-pin DIMM (DDR5)", "2 x 16GB", 2.906 ,"Black", 12.857, 36, 1.25, "36-36-36-76", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKit2 = new MemoryKits(compatibleMemoryKit2, "G.Skill", "F5-6000J3636F16GX2-TZ5RK", "G.Skill Trident Z5 RGB 32 GB (2 x 16 GB) DDR5-6000 CL36 Memory", 109.99, "DDR5-6000", "288-pin DIMM (DDR5)", "2 x 16GB", 3.437,"Black", 12, 36, 1.35, "36-36-36-96", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKit3 = new MemoryKits(compatibleMemoryKit3, "G.Skill", "F5-6400J3239G32GX2-TZ5RK", "G.Skill Trident Z5 RGB 64 GB (2 x 32 GB) DDR5-6400 CL32 Memory", 237.99, "DDR5-6400", "288-pin DIMM (DDR5)", "2 x 32GB", 3.719,"Black/Silver", 10, 32, 1.4, "32-39-39-102", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKits4 = new MemoryKits(compatibleMemoryKit4, "Corsair", "CMK16GX4M2B3200C16", "Corsair Vengeance LPX 16 GB (2 x 8 GB) DDR4-3200 CL16 Memory", 39.99, "DDR4-3200", "288-pin DIMM (DDR4)", "2 x 8GB", 2.499, "Black/Yellow", 10, 16, 1.35, "16-18-18-36", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKits5 = new MemoryKits(compatibleMemoryKit5, "Silicon Power", "SP016GXLZU320BDAJ5", "Silicon Power GAMING 16 GB (2 x 8 GB) DDR4-3200 CL16 Memory", 29.97, "DDR4-3200", "288-pin DIMM (DDR4)", "2 x 8GB", 1.873, "Black/Gray", 10, 16, 1.35, "16-18-18-38", "Non-ECC/Unbuffered", true);
        MemoryKits memoryKits6 = new MemoryKits(compatibleMemoryKit6, "ADATA", "AX4U32008G16A-DW50", "ADATA XPG SPECTRIX D50 16 GB (2 x 8 GB) DDR4-3200 CL16 Memory", 43.99, "DDR4-3200", "288-pin DIMM (DDR4)", "2 x 8GB", 2.749, "White", 10, 16, 1.35, "16-20-20", "Non-ECC/Unbuffered", true);
        String[][] compatibleGPU1 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleGPU2 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleGPU3 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"Power Supplies", "CP-9020200-NA", "CP-9020262-NA", "CP-9020201-NA"}, {""}, {""}, {""}, {""}, {""}, {""}};
        GPU gpu1 = new GPU(compatibleGPU1, "MSI", "RTX3060Ventus2X12GOC", "MSI GeForce RTX 3060 Ventus 2X 12G GeForce RTX 3060 12GB 12 GB Video Card", 289.99, "GeForce RTX 3060 12GB", 12, "GDDR6", 1320, 1777, 15000, "PCIe x 16", "Black", "G-Sync", 235, 170, 2, 2, "2 Fans", "1 PCIe 8-pin", "1 HDMI Outputs", "3 DisplayPort Outputs");
        GPU gpu2 = new GPU(compatibleGPU2, "Asus", "TUF-RTX4070TI-12G-GAMING", "Asus TUF GAMING GeForce RTX 4070 Ti 12 GB Video Card", 799.99, "GeForce RTX 4070 Ti", 12, "GDDR6X", 2310, 2640, 21000, "PCIe x 16", "Black", "G-Sync", 305, 285, 2, 4, "3 Fans", "1 PCIe 16-pin", "2 HDMI 2.1a Outputs", "3 DisplayPort 1.4a Outputs");
        GPU gpu3 = new GPU(compatibleGPU3, "Gigabyte", "GV-R66EAGLE-8GD", "Gigabyte EAGLE Radeon RX 6600 8 GB Video Card", 199.99, "Radeon RX 6600", 8, "GDDR6", 1626, 2491, 14000, "PCIe x 16", "Black/Silver", "FreeSync", 282, 132, 2, 2, "3 Fans", "1 PCIe 8-pin", "2 HDMI Outputs", "2 DisplayPort Outputs");
        String[][] compatiblePowerSupply1 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"GPUs", "RTX3060Ventus2X12GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatiblePowerSupply2 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"GPUs", "RTX3060Ventus2X12GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatiblePowerSupply3 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {"GPUs", "RTX3060Ventus2X12GOC", "TUF-RTX4070TI-12G-GAMING", "GV-R66EAGLE-8GD"}, {""}, {""}, {""}, {""}, {""}, {""}};
        PowerSupply powerSupply = new PowerSupply(compatiblePowerSupply1, "Corsair", "CP-9020200-NA", "Corsair RM850x (2021) 850 W 80+ Gold Certified Fully Modular ATX Power Supply", 149.99, "ATX", "80+ Gold", 850, 160, "Full", "Black", false, 0, 3, 0, 0, 0, 4, 0, 14, 4);
        PowerSupply powerSupply2 = new PowerSupply(compatiblePowerSupply2, "Corsair", "CP-9020262-NA", "Corsair RM750e (2023) 750 W 80+ Gold Certified Fully Modular ATX Power Supply", 99.99, "ATX", "80+ Gold", 750, 140, "Full", "Black", false, 0, 2, 1, 0, 0, 3, 0, 7, 4);
        PowerSupply powerSupply3 = new PowerSupply(compatiblePowerSupply3, "Corsair", "CP-9020201-NA", "Corsair RM1000x (2021) 1000 W 80+ Gold Certified Fully Modular ATX Power Supply", 174.99, "ATX", "80+ Gold", 1000, 180, "Full", "Black", false, 0, 3, 0, 0, 0, 4, 0, 14, 8);
        String[][] compatibleStorage1 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleStorage2 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}};
        String[][] compatibleStorage3 = new String[][]{{"Cases", "PC-O11DEW", "CC-9011200-WW", "CC-H51FB-01"}, {"Motherboards", "Z790 AORUS ELITE AX", "MAG B660 TOMAHAWK WIFI DDR4", "ROG MAXIMUS Z790 HERO", "B650 GAMING X AX", "MAG X670E TOMAHAWK WIFI",
                "ROG STRIX X670E-E GAMING WIFI", "MAG B550 TOMAHAWK", "TUF GAMING X570-PLUS (WI-FI)", "Prime B450M-A II"}, {""}, {""}, {""}, {""}, {""}, {""}};
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