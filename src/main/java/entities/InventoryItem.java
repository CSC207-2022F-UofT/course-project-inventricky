package entities;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class InventoryItem extends Item implements Serializable {

    //Instance Variables
    private double quantityBought; // quantity of product bought so far (double type if measured in kg)

    private double quantitySold; // quantity of product sold so far (double type if measured in kg)

    private ArrayList<String> itemHistory; // List of changes to item quantity

    public double getQuantityBought() {
        return quantityBought;
    }

    // Getters and Setters
    public void setQuantityBought(double quantityBought) {
        this.quantityBought = quantityBought;
    }

    public double getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(double quantitySold) {
        this.quantitySold = quantitySold;
    }

    public ArrayList<String> getItemHistory() {
        return itemHistory;
    }


    //Constructor

    public InventoryItem(String name, boolean isWeight, double quantity, double buyPrice,
                         double sellPrice, int caseQuantity, String department, double quantityBought, double quantitySold) {
        super(name, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
        this.itemHistory = new ArrayList<String>();
        this.itemHistory.add(this.getBarcode() + " " + name);
    }

    //constructor for test InventoryItems
    public InventoryItem(String name, String barcode, boolean isWeight, double quantity, double buyPrice,
                         double sellPrice, int caseQuantity, String department, double quantityBought, double quantitySold) {
        super(name, barcode, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
        this.itemHistory = new ArrayList<String>();
        this.itemHistory.add(this.getBarcode() + " " + name);
    }

}
