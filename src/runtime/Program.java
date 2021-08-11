package runtime;

import data.Menu;
import data.PhoneList;

public class Program {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("HKT Store - @ 2021 by <SE161289 - Tứn Kịt> \nSelect the options below:");
        PhoneList pL = new PhoneList();
        mainMenu.addNewOption("1. Add a phone");
        mainMenu.addNewOption("2. Search a phone by model");
        mainMenu.addNewOption("3. Remove the phone by model");
        mainMenu.addNewOption("4. Print the phone list in the descending order of model");
        mainMenu.addNewOption("5. Quit");
        int choice = 0;
        do {
            mainMenu.printMenu();
            choice = mainMenu.getChoice();
            switch (choice) {
                case 1:
                    pL.addNewPhone();
                    break;
                case 2:
                    pL.searchPhoneList();
                    break;
                case 3:
                    pL.remove();
                    break;
                case 4:
                    pL.printManagerListAscByModel();
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}