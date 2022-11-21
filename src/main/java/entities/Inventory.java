package entities;
import entities.Ordering_Recieving.Order;
import useCases.UpdateItemQuantity;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
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

    public void addItem(InventoryItem item) {
        boolean b = false;
        for (InventoryItem i : this.getItems()) {
            if (Objects.equals(i.getName(), item.getName())) {
                UpdateItemQuantity u = new UpdateItemQuantity();
                UpdateItemQuantity.updateQty(this, item.getBarcode(), item.getQuantity(), "bought");
                b = true;
                this.updateHistory("Item" + i.getName() + "had it's quantity increased by" + item.getQuantity());
                break;
            }
        }
        if (!b) {
            this.items.add(item);
            this.updateHistory("Item" + item.getName() + "was added to the inventory");
        }
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void removeItem(InventoryItem item) {
        this.items.remove(item);
        this.updateHistory("Item" + item.getName() + "was removed from the inventory");
    }

    public void removeOrder(Order order) {
        this.orders.remove(order);
        this.updateHistory("Order" + order.getName() + "was removed from the inventory");
    }

    public void updateHistory(String event) {
        this.history.add(event);
    }

    public String getName() {
        return name;
    }

    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
