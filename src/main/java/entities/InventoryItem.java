package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

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

    public void setItemHistory(ArrayList itemHistory) {
        this.itemHistory = itemHistory;
    }

    //Constructor

    public InventoryItem(String name, boolean isWeight, double quantity, double buyPrice,
                         double sellPrice, int caseQuantity, String department, double quantityBought, double quantitySold) {
        super(name, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
        this.itemHistory = new ArrayList<String>(); //TODO Figure out where to put files
    }

    //constructor for test InventoryItems
    public InventoryItem(String name, String barcode, boolean isWeight, double quantity, double buyPrice,
                         double sellPrice, int caseQuantity, String department, double quantityBought, double quantitySold) {
        super(name, barcode, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
        this.itemHistory = new ArrayList<String>(); //TODO Figure out where to put files
    }

    //TODO Implement


//    public abstract void orderItem(); // order more stock for item
//
//    public abstract void remindOrder(); // remind user to order more stock for item
}
