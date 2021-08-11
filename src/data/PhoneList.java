package data;

import java.io.Serializable;
import java.util.*;
import util.MyToys;

public class PhoneList implements Serializable {
    private ArrayList < Phone > phoneList = new ArrayList < > ();

    public ArrayList < Phone > getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList < Phone > phoneList) {
        this.phoneList = phoneList;
    }

    //    search Phone ra vị trí
    public int searchPhoneByModel(String model) {
        for (int i = 0; i < phoneList.size(); i++)
            if (phoneList.get(i).getModel().compareToIgnoreCase(model) == 0)
                return i;
        return -1;
    }
    //    search Phone ra nguyên Phone
    public Phone searchObjectPhoneByModel(String model) {
        if (phoneList.isEmpty())
            return null;
        for (Phone p: phoneList)
            if (p.getModel().compareToIgnoreCase(model) == 0)
                return p;
        return null;
    }
    //
    private ArrayList < Phone > searchListPhoneByModel(String key) {
        ArrayList < Phone > res = new ArrayList < > ();
        for (Phone p: phoneList) {
            if (p.getModel().contains(key))
                res.add(p);
        }
        return res;
    }

    public void searchPhoneList() {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print.");
            return;
        }
        String key = MyToys.getString("Enter phone's model: ", "I can't understand you");
        key = key.toUpperCase();
        ArrayList < Phone > res;
        res = searchListPhoneByModel(key);
        if (res.isEmpty()) {
            System.err.println("Not found");
        } else {
            System.out.println("Here is the phone that you wanna search");
            String header;
            header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
                " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
            System.out.println(header);
            for (Phone p: res)
                p.showDetail();
        }
    }

    public void remove() {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print.");
            return;
        }
        String key = MyToys.getString("Enter phone's model: ", "I can't understand you");
        key = key.toUpperCase();
        ArrayList < Phone > res;
        res = searchListPhoneByModel(key);
        if (res.isEmpty()) {
            System.err.println("Not found");
        } else {
            System.out.println("Here is the phone that you wanna search");
            String header;
            header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
                " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
            System.out.println(header);
            for (Phone p: res)
                p.showDetail();
            int choice = MyToys.getAnInteger("Enter number of row you wanna remove: ", "Invalid", 1, res.size());
            boolean check = MyToys.getBoolean("Are you sure removing this phone (Y/N): ",
                "Invalid");
            if (check) {
                phoneList.remove(choice - 1);
                System.out.println("A phone's profile is sucessfully removed");
            }
        }
    }

    public void searchPhoneByModel() {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print.");
            return;
        }
        String model;
        Phone x;
        model = MyToys.getID("Enter phone's model (AA-DDDDD)\nA matches any alphabet\nD matches any digit: ", "Invalid", "^[A-Za-z]{2}-\\d{5}$");
        x = searchObjectPhoneByModel(model);
        System.out.println("----------------------------------------------------------------------");
        if (x == null)
            System.err.println("Not found");
        else {
            System.out.println("Here is the phone that you wanna search");
            String header;
            header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
                " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
            System.out.println(header);
            x.showDetail();
        }
    }

    public void addNewPhone() {
        String model, color, branch;
        int ram, primaryCamera;
        double screenSize, price;
        int pos;
        do {
            model = MyToys.getID("Enter phone's model (AA-DDDDD)\nA matches any alphabet\nD matches any digit: ", "Invalid", "^[A-Za-z]{2}-\\d{5}$");
            pos = searchPhoneByModel(model);
            if (pos != -1)
                System.err.println("This phone Model is already exist");
        } while (pos != -1);
        ram = MyToys.getAnInteger("Enter phone's RAM (GB): ",
            "RAM must be a positive interger", 1, 64);
        primaryCamera = MyToys.getAnInteger("Enter phone's primary camera (PM): ",
            "Primary camera must be a positive interger", 1, 50);
        screenSize = MyToys.getADouble("Enter phone's screen size (''): ",
            "Screen size must be a positive real number", 1, 15);
        price = MyToys.getADouble("Enter phone's price ($): ",
            "Price must be a positive real number", 1, 4000);
        color = MyToys.getAName("Enter phone's color: ",
            "Color only contain alphabet");
        branch = MyToys.getAName("Enter phone's branch: ",
            "Branch only contain alphabet");
        boolean check = MyToys.getBoolean("Are you sure adding this phone (Y/N): ",
            "Invalid");
        if (check) {
            phoneList.add(new Phone(model, ram, primaryCamera, screenSize, price, color, branch));
            System.out.println("A phone's profile is sucessfully added");
        }
    }

    public void removePhone() {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print.");
            return;
        }
        String model;
        int pos;
        model = MyToys.getID("Enter phone's model (AA-DDDDD)\nA matches any alphabet\nD matches any digit: ", "Invalid", "^[A-Za-z]{2}-\\d{5}$");
        pos = searchPhoneByModel(model);
        if (pos == -1) {
            System.err.println("Not found");
        } else {
            String header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
                " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
            System.out.println(header);
            phoneList.get(pos).showDetail();
            boolean check = MyToys.getBoolean("Are you sure removing this phone (Y/N): ",
                "Invalid");
            if (check) {
                phoneList.remove(pos);
                System.out.println("A phone's profile is sucessfully removed");
            }
        }
    }

    public void printManagerListAscByModel() {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print.");
            return;
        }
        Collections.sort(phoneList);
        System.out.println("Here is the phone list");
        System.out.println(" ____________________________________________________________________ ");
        String header = String.format("|%-8s|%-5s|%-6s|%-11s|%-9s|%-8s|%-15s|",
            " MODEL  ", " RAM ", "CAMERA", "SCREEN SIZE", "  PRICE  ", "COLOR", "BRANCH");
        System.out.println(header);
        for (Phone p: phoneList) {
            p.showDetail();
        }
    }
}