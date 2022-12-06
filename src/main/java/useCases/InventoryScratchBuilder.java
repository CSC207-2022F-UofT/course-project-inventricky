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
        inv.updateHistory("New inventory created from scratch AAAAAA");
        return inv;
    }
}
