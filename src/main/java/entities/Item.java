package entities;

public abstract class Item {

    //Instance Variables
    private String name; // product name
    private int barcode; // product barcode

    private boolean isWeight; // true if product is quantified by weight
    private double quantity; // quantity of product in on hand in inventory (double type if measured in kg)
    private int buyPrice; // buying price of item (per item or price per kg)
    private int sellPrice; // selling price of item (per item or price per kg)
    private int caseQuantity; // quantity of item per case

    private int department; //Department # of item

    //Getters and Setters
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getBarcode() { return barcode; }

    public void setBarcode(int barcode) { this.barcode = barcode; }

    public void setIsWeight(boolean weight) {
        this.isWeight = weight;
    }

    public boolean getIsWeight() { return isWeight; }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) { this.quantity = quantity; }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getCaseQuantity() {
        return caseQuantity;
    }

    public void setCaseQuantity(int caseQuantity) {
        this.caseQuantity = caseQuantity;
    }

    public int getDepartment() { return department; }

    public void setDepartment() { this.department = department; }

    //Constructor

    //For Order
    public Item(String name, int barcode, boolean isWeight, double quantity, int buyPrice, int sellPrice, int caseQuantity, int department) {
        this.name = name;
        this.barcode = barcode;
        this.department = department;
        this.isWeight = isWeight;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.caseQuantity = caseQuantity;
    }

    //For inventory item
    public Item(String name, boolean isWeight, double quantity, int buyPrice, int sellPrice, int caseQuantity, int department) {
        this.name = name;
        this.barcode = BarcodeGenerator.generateBarcode(department);
        this.department = department;
        this.isWeight = isWeight;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.caseQuantity = caseQuantity;
    }

}

