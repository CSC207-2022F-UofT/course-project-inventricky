package entities;
import barcode_use_case.BarcodeInteractor;
import barcode_use_case.ReadBarcodeInputBoundary;
import barcode_use_case.RemoveBarcodeInputBoundary;
import database_access.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * The Inventory class. Keeps track of the items and orders of the inventory as well as its history.
 */
public class Inventory {
    private static String file = Item.getFile(); //file path of barcode csv

    //Shared mapping of departments to barcodes used by item constructor
    private static HashMap<String, List<String>> barcodes;
    private String name;
    private ArrayList<InventoryItem> items;
    private ArrayList<Order> orders;
    private ArrayList<String> history;

    public Inventory(String name) {
        this.name = name;
        this.items = new ArrayList<InventoryItem>();
        this.orders = new ArrayList<Order>();
        this.history = new ArrayList<String>();
    }

    public Inventory(String name, ArrayList<InventoryItem> items, ArrayList<Order> orders) {
        this.name = name;
        this.items = items;
        this.orders = orders;
        this.history = new ArrayList<String>();
    }

    /** Adds an Item to the inventor's list of items. If the item is already in the inventory, increase the quantity of
     * the item.
     ** @param item Item that is to be added to Inventory.
     */
    public void addItem(InventoryItem item) {
        boolean b = false;
        for (InventoryItem i : this.getItems()) {
            if (Objects.equals(i.getName(), item.getName())) {
//                UpdateItemQuantity u = new UpdateItemQuantity();
//                u.updateQty(this, item.getBarcode(), item.getQuantity(), "bought");
                double q = i.getQuantity();
                i.setQuantity(q + item.getQuantity());
                b = true;
                this.updateHistory("Item " + i.getName() + " had it's quantity increased by " + item.getQuantity());
                break;
            }
        }
        if (!b) {
            this.items.add(item);
            this.updateHistory("Item " + item.getName() + " was added to the inventory");
        }
    }

    /** Adds an Order to the inventor's list of orders.
     * @param order Order that is to be added.
     */
    public void addOrder(Order order) {
        this.orders.add(order);
        this.updateHistory("Order " + order.getName() + " was added to the inventory");
    }

    /** Removes an Item to the inventor's list of items.
     * @param item Item that is to be removed.
     * @param testing true if method is being called for test, ignores barcode remover
     */
    public void removeItem(InventoryItem item, boolean testing) {
        if (!testing) {
            file = Item.getFile(); //update filepath of csv
            this.barcodes = new BarcodeInteractor().readBarcode(file);
            new BarcodeInteractor().removeBarcode(item.getBarcode(), barcodes, file);
        }

        this.items.remove(item);
        this.updateHistory("Item " + item.getName() + " was removed from the inventory");
    }

    /** Removes an order to the inventor's list of orders.
     * @param order Order that is to be removed.
     */
    public void removeOrder(Order order) {
        this.orders.remove(order);
        this.updateHistory("Order " + order.getName() + " was removed from the inventory");
    }

    /** Adds an event to the inventor's history.
     * @param event Event to be added to history.
     */
    public void updateHistory(String event) {
        this.history.add(event);
    }

    /** Gets the name of the inventory.
     * @return The name of the inventory.
     */
    public String getName() {
        return name;
    }

    /** Gets the items of the inventory.
     * @return The items ArrayList associated with the inventory.
     */
    public ArrayList<InventoryItem> getItems() {
        return this.items;
    }

    /** Gets the orders of the inventory.
     * @return The orders ArrayList associated with the inventory.
     */
    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    /** Gets the history of the inventory.
     * @return The history of the inventory.
     */
    public ArrayList<String> getHistory() {
        return history;
    }

    /** Set the name of the inventory.
     * @param name The new name of the inventory.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Set the items of the inventory.
     * @param items The new items of the inventory.
     */
    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    /** Set the orders of the inventory.
     * @param orders The new orders of the inventory.
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /** Set the history of the inventory.
     * @param history The new history of the inventory.
     */
    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }

}
