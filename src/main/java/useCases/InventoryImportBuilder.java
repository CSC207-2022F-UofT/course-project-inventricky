package useCases;

import entities.Importer1;
import entities.Inventory;

public class InventoryImportBuilder implements InventoryBuilder {
    private final String name;
    private final String filename;

    public InventoryImportBuilder(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }

    public Inventory create() {
        Inventory inv = new Inventory(name);
        new Importer1(filename, inv).importSerializable();
        inv.updateHistory("New inventory created from import");
        return inv;
    }
}
