package entities;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<InventoryItem> items;
    private String name;

    public Inventory(String name) {
        this.name = name;
        this.items = new ArrayList<InventoryItem>();
    }

    public Inventory(String name, ArrayList<InventoryItem> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }
}
