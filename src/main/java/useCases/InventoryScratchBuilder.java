package useCases;

import entities.Inventory;

public class InventoryScratchBuilder {
    private final String name;

    public InventoryScratchBuilder(String name) {
        this.name = name;
    }

    public Inventory create() {
        Inventory i = new Inventory(this.name);
        i.updateHistory("New inventory created from scratch");
        return(i);
    }
}
