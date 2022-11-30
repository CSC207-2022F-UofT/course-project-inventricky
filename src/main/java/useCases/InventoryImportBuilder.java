package useCases;

import entities.Inventory;
import useCases.importUseCase.ImportInventory;

public class InventoryImportBuilder implements InventoryBuilder {
    private final String name;
    private final String filename;

    public InventoryImportBuilder(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }

    public Inventory create() {
        Inventory inv = new Inventory(name);
        ImportInventory importer = new ImportInventory(inv);
        importer.importToInventory(filename);
        inv.updateHistory("New inventory created from import");
        return inv;
    }
}
