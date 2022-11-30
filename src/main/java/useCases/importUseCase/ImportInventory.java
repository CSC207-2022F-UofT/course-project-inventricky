package useCases.importUseCase;

import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import gateways.Importer;

public class ImportInventory {
    private final Inventory inventory;

    public ImportInventory(Inventory inv) {
        this.inventory = inv;
    }

    public void importToInventory(String filename) {
        Importer importer = new Importer(filename);
        ImportDataWrapper wrapper = new ImportDataWrapper(importer.importSerializable());

        for (Object obj : wrapper.getList()) {
            if (obj instanceof InventoryItem) {
                this.inventory.addItem((InventoryItem) obj);
            } else {
                this.inventory.addOrder((Order) obj);
            }
        }
    }
}
