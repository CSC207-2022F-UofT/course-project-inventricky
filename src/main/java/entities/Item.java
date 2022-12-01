package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public abstract class Item implements Serializable {

    //Class Variables
    private static final String file = "src/main/java/exports/testbarcodes.csv"; //file path of barcode csv

    //Shared mapping of departments to barcodes used by item constructor
    private static HashMap<String, List<String>> barcodes = BarcodeMapReader.readBarcodes(file);

    //Instance Variables
    private String name; // product name
    private String barcode; // product barcode

    private boolean isWeight; // true if product is quantified by weight
    private double quantity; // quantity of product in on hand in inventory (double type if measured in kg)
    private double buyPrice; // buying price of item (per item or price per kg)
    private double sellPrice; // selling price of item (per item or price per kg)
    private int caseQuantity; // quantity of item per case

    private String department; //Department # of item

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }


    public boolean getIsWeight() {
        return isWeight;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getBuyPrice() {
        return buyPrice;
    }


    public double getSellPrice() {
        return sellPrice;
    }


    public int getCaseQuantity() {
        return caseQuantity;
    }


    public String getDepartment() {
        return department;
    }


    //Constructor

    //For Order and testing
    public Item(String name, String barcode, boolean isWeight, double quantity, double buyPrice, double sellPrice, int caseQuantity, String department) {
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
    public Item(String name, boolean isWeight, double quantity, double buyPrice, double sellPrice, int caseQuantity, String department) {
        this.name = name;
        barcodes = BarcodeMapReader.readBarcodes(file);
        this.barcode = BarcodeGenerator.generateBarcode(department, barcodes, file);
        this.department = department;
        this.isWeight = isWeight;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.caseQuantity = caseQuantity;
    }

}

