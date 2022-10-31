import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private String name;

    public Inventory(String name) {
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    public Inventory(String name, ArrayList<Item> items) {
        this.name = name;
        this.items = items;
    }

    public Inventory() {
        this.name = "Untitled";
        this.items = new ArrayList<Item>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
