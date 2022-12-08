package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class InventoryItem extends Item implements Serializable {

    //Instance Variables
    private double quantityBought; // quantity of product bought so far (double type if measured in kg)

    private double quantitySold; // quantity of product sold so far (double type if measured in kg)

    private final ArrayList<String> itemHistory; // List of changes to item quantity

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

    /** Construct a new inventory item
     *
     * @param name              name of item.
     * @param isWeight          true if item is quantified in kg.
     * @param quantity          quantity of item.
     * @param buyPrice          buy price of item.
     * @param sellPrice         sell price of item.
     * @param caseQuantity      quantity of item per case.
     * @param department        department number of item.
     * @param quantityBought    quantity of item bought so far.
     * @param quantitySold      quantity of item sold so far.
     */
    public InventoryItem(String name, boolean isWeight, double quantity, double buyPrice,
                         double sellPrice, int caseQuantity, String department, double quantityBought, double quantitySold) {
        super(name, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
        this.itemHistory = new ArrayList<>();
        this.itemHistory.add(this.getBarcode() + " " + name);
    }

    //constructor for test InventoryItems

    /** Construct a new inventory item for testing (barcode not generated)
     *
     * @param name              name of item.
     * @param barcode           barcode of item.
     * @param isWeight          true if item is quantified in kg.
     * @param quantity          quantity of item.
     * @param buyPrice          buy price of item.
     * @param sellPrice         sell price of item.
     * @param caseQuantity      quantity of item per case.
     * @param department        department number of item.
     * @param quantityBought    quantity of item bought so far.
     * @param quantitySold      quantity of item sold so far.
     */
    public InventoryItem(String name, String barcode, boolean isWeight, double quantity, double buyPrice,
                         double sellPrice, int caseQuantity, String department, double quantityBought, double quantitySold) {
        super(name, barcode, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.quantityBought = quantityBought;
        this.quantitySold = quantitySold;
        this.itemHistory = new ArrayList<>();
        this.itemHistory.add(this.getBarcode() + " " + name);
    }

}

