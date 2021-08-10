package data;

import java.util.*;
import util.MyToys;

public class PhoneList {
    private ArrayList < Phone > phoneList = new ArrayList < > ();
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
    public void searchPhoneByModel() {
        String model;
        Phone x;
        model =  MyToys.getID("Enter phone's model (AA-DDDDD)\nA matches any alphabet\nD matches any digit: "
                , "Invalid", "^[A-Za-z]{2}\\d{5}$");
        x = searchObjectPhoneByModel(model);
        System.out.println("-------------------------------------------------");
        if (x == null)
            System.err.println("Not found");
        else {
            System.out.println("Here is the phone that you wanna search");
            String header;
            header = String.format("|%-8s|%-5s|%-5s|%-7s|%-9s|%-8s|%-12s|",
                    "MODEL", "RAM", "PRI-CAM", "SCR-SIZE", "PRICE", "COLOR", "BRANCH");
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
            model =  MyToys.getID("Enter phone's model (AA-DDDDD)\nA matches any alphabet\nD matches any digit: "
                , "Invalid", "^[A-Za-z]{2}\\d{5}$");
            pos = searchPhoneByModel(model);
            if (pos != -1)
                System.err.println("This model is already exist");
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
        System.out.println("Are you sure adding this phone");
        boolean check = MyToys.getBoolean("Are you sure adding this phone (Y/N): ", 
                        "Invalid");
        if (check) {
            phoneList.add(new Phone(model, ram, primaryCamera, screenSize, price, color, branch));
            System.out.println("A phone's profile is sucessfully added");
        }       
    }

    public void removePhone() {
        if (phoneList.isEmpty()) 
            System.out.println("The list is empty");
        String model, pos;
        id = MyToys.getAnInteger("Enter phone's ID: ", "ID must be an positive " +
            "integer", 1, Integer.MAX_VALUE);
        pos = searchPhoneByModel(id);
        if (pos == -1) {
            System.err.println("Not found");
        } else {
            for (Phone phone : phoneList) {
                if (phone.getManager() != null && phone.getManager().equals(phoneList.get(pos))) 
                    phone.setManager(null);
            }
            phoneList.remove(pos);
            System.out.println("The phone information is remove sucessfully");
        }
    }

    public void printManagerListAscByModel() {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print");
            return;
        }
        Collections.sort(phoneList);
        System.out.println("-------------------------------------------------");
        System.out.println("Here is the manager list");
        String header = String.format("|%-4s|%-15s|%-6s|%-10s|%-10s|",
            "ID", "NAME", "GENDER", "BASIC", "BONUS");
        System.out.println(header);
        for (Phone st: phoneList) {
            if (st instanceof Manager) {
                st.showDetail();
            }
        }
    }

    public void printPhoneListAscByModel(Manager manager) {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print");
            return;
        }
        Collections.sort(phoneList);
        System.out.println("-------------------------------------------------");
        System.out.println("Here is the phone list");
        String header = String.format("|%-4s|%-15s|%-6s|%-10s|%-10s|",
            "ID", "NAME", "GENDER", "BASIC", "BONUS");
        System.out.println(header);
        for (Phone st: phoneList) {
            if (!(st.equals(manager))) {
                st.showDetail();
            }
        }
    }

    public void printPhoneListAscByModel() {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print");
            return;
        }
        Collections.sort(phoneList);
        System.out.println("-------------------------------------------------");
        System.out.println("Here is the phone list");
        String header = String.format("|%-4s|%-15s|%-6s|%-10s|%-10s|",
            "ID", "NAME", "GENDER", "BASIC", "BONUS");
        System.out.println(header);
        for (Phone st: phoneList)
            st.showDetail();
    }

    public void printPhoneListAscByName() {
        if (phoneList.isEmpty()) {
            System.out.println("The storage is empty. Nothing to print");
            return;
        }
        Collections.sort(phoneList, new Comparator < Phone > () {
            @Override
            public int compare(Phone p1, Phone p2) {
                return p1.getName().compareToIgnoreCase(p2.getName());
            }
        });
        System.out.println("-------------------------------------------------");
        System.out.println("Here is the phone list");
        String header = String.format("|%-4s|%-15s|%-6s|%-10s|%-10s|",
            "ID", "NAME", "GENDER", "BASIC", "BONUS");
        System.out.println(header);
        for (Phone st: phoneList)
            st.showDetail();
    }


}