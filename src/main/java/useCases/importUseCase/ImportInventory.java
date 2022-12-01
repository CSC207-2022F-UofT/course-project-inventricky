package useCases.importUseCase;

import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import databases.Importer;

public class ImportInventory {
    private final Inventory inventory;

    public ImportInventory(Inventory inv) {
        this.inventory = inv;
    }

    public void importToInventory(String filename) {
        Importer importer = new Importer(filename);
        ImportDataWrapper wrappedinv = importer.importSerializable();

        for (Object obj : wrappedinv.getList()) {
            if (obj instanceof InventoryItem) {
                this.inventory.addItem((InventoryItem) obj);
            } else {
                this.inventory.addOrder((Order) obj);
            }
        }

        String[][] inventoryTable = new String[inventory.getItems().size()][3]; //InventoryViewModel
        for (int i = 0; i < wrappedinv.getList().size(); i++) {
            if (wrappedinv.getList().get(i) instanceof InventoryItem) {
                InventoryItem item = (InventoryItem) wrappedinv.getList().get(i);
                inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode()};
            } else {
                //this.inventory.addOrder((Order) obj);
                //TODO
            }
        }
    }
}
