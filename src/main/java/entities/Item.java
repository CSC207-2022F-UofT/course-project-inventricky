package entities;

import barcode_use_case.BarcodeInteractor;
import barcode_use_case.GenerateBarcodeInputBoundary;
import barcode_use_case.ReadBarcodeInputBoundary;
import database_access.BarcodeMapReader;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public abstract class Item implements Serializable {

    //Class Variables
    private static String file = "src/main/java/temp_files/new_inventory_barcodes_temp.csv"; //file path of barcode csv, defaults to empty csv for new Inventory

    //Shared mapping of departments to barcodes used by item constructor
    private static HashMap<String, List<String>> barcodes = new BarcodeInteractor().readBarcode(file);

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


    public static String getFile() {
        return file;
    }

    //update filepath of barcode csv

    /** Update filepath of barcode csv
     *
     * @param newFile   filepath of barcode csv.
     */
    public static void setFile(String newFile) {
        file = newFile;
        barcodes = BarcodeMapReader.readBarcodes(file);
    }


    //Constructor

    //For Order and testing

    /** Construct a new Item for orders or testing (barcode not generated)
     *
     * @param name              name of item.
     * @param barcode           barcode of item.
     * @param isWeight          true if item is quantified in kg.
     * @param quantity          quantity of item.
     * @param buyPrice          buy price of item.
     * @param sellPrice         sell price of item.
     * @param caseQuantity      quantity of item per case.
     * @param department        department number of item.
     */
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

    /** Construct a new inventory item.
     *
     * @param name              name of item.
     * @param isWeight          true if item is quantified in kg.
     * @param quantity          quantity of item.
     * @param buyPrice          buy price of item.
     * @param sellPrice         sell price of item.
     * @param caseQuantity      quantity of item per case.
     * @param department        department number of item.
     */
    public Item(String name, boolean isWeight, double quantity, double buyPrice, double sellPrice, int caseQuantity, String department) {
        this.name = name;
        barcodes = BarcodeMapReader.readBarcodes(file);
        this.barcode = new BarcodeInteractor().generateBarcode(department, barcodes, file);
        this.department = department;
        this.isWeight = isWeight;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.caseQuantity = caseQuantity;
    }

}

