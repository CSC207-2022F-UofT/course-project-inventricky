package entities;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

public abstract class InventoryItem extends Item implements Serializable {

    //Instance Variables
    private double quantityBought; // quantity of product bought so far (double type if measured in kg)

    private double quantitySold; // quantity of product sold so far (double type if measured in kg)

    private File itemHistory; // text file of changes to item quantity

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

    public File getItemHistory() {
        return itemHistory;
    }

    public void setItemHistory(File itemHistory) {
        this.itemHistory = itemHistory;
    }

    //Constructor

    public InventoryItem(String name, boolean isWeight, double quantity, int buyPrice,
                         int sellPrice, int caseQuantity, int department, double quantityBought, double quantitySold) {
        super(name, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
        this.itemHistory = new File("path to be confirmed"); //TODO Figure out where to put files
    }

    //TODO Implement


    public abstract void orderItem(); // order more stock for item

    public abstract void remindOrder(); // remind user to order more stock for item

}
