package data;

public class Phone implements Comparable<Phone>{
    private String model;
    private int ram;
    private int primaryCamera;
    private double screenSize;
    private double price;
    private String color;
    private String brand;

    public Phone(String model, int ram, int primaryCamera, double screenSize, double price, String color, String brand) {
        this.model = model;
        this.ram = ram;
        this.primaryCamera = primaryCamera;
        this.screenSize = screenSize;
        this.price = price;
        this.color = color;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(int primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public void showDetail() {
        System.out.printf("|%8s|%2dGB|%4dMP|%9.1f''|%8.2f$|%-8s|%-12s|\n"
                , model, ram, primaryCamera, screenSize, price, color, brand);
    }

    @Override
    public int compareTo(Phone that) {
        return this.model.compareToIgnoreCase(that.getModel());
    }

    @Override
    public String toString() {
        return model + "#" + ram + "#" + primaryCamera + "#" + screenSize + "#" + price + "#" + color + "#" + brand;
    }
    
}
