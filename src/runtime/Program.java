package runtime;

import data.Menu;

public class Program {
    public static void main(String[] args) {
        Menu mainMenu = new Menu("HKT Store - @ 2021 by <SE161289 - Tứn Kịt> \nSelect the options below:");
        mainMenu.addNewOption("1. Add a phone");
        mainMenu.addNewOption("2. Search a phone by model");
        mainMenu.addNewOption("3. Remove the phone by model");
        mainMenu.addNewOption("4. Print the phone list in the descending order of Model");
        mainMenu.addNewOption("5. Quit");
        int choice = 0;
        do {
            mainMenu.printMenu();
            choice = mainMenu.getChoice();
            switch (choice) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);
    }
}