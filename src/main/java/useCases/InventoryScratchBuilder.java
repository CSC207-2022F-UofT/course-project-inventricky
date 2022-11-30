package useCases;

import entities.Inventory;
import entities.InventoryItem;

public class InventoryScratchBuilder {
    private final String name;

    public InventoryScratchBuilder(String name) {
        this.name = name;
    }

    public Inventory create() {
        Inventory inv = new Inventory(this.name);
        inv.updateHistory("New inventory created from scratch");
        return inv;
    }

    public static void main(String[] args) {
        Inventory inv = new InventoryScratchBuilder("test").create();
        inv.addItem(new InventoryItem("bananasss","183" , true, 10, 2,
                3, 5, "1", 10, 0));
        System.out.println(inv.getItems());
    }
}
