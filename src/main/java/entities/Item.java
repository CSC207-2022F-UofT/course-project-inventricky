package entities;

import java.io.File;

public abstract class Item {

    // Instance Variables
    private String name; // product name
    private int barcode; // product barcode
    private boolean isUnit; // true if product is quantified per unit
    private double quantity; // quantity of product in on hand in inventory (double type if measured in kg)
    private double quantityBought; // quantity of product bought so far (double type if measured in kg)
    private double quantitySold; // quantity of product sold so far (double type if measured in kg)
    private int buyPrice; // buying price of item (per item or price per kg)
    private int sellPrice; // selling price of item (per item or price per kg)
    private int caseQuantity; // quantity of item per case

    private File itemHistory; // text file of changes to item quantity

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getBarcode() { return barcode; }

    public boolean isUnit() {
        return isUnit;
    }

    public void setUnit(boolean unit) {
        this.isUnit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) { this.quantity = quantity; }

    public double getQuantityBought() { return quantityBought; }

    public void setQuantityBought(double quantity) { this.quantityBought = quantity; }

    public double getQuantitySold() { return quantitySold; }

    public void setQuantitySold(double quantity) { this.quantitySold = quantity; }

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

}

