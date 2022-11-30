package import_use_case;

import database.Importer;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;

public class ImportInventory {
    private final Inventory inventory;

    public ImportInventory(Inventory inv) {
        this.inventory = inv;
    }

    public void importToInventory(String filename) {
        Importer importer = new Importer(filename);

        ImportDataWrapper wrappedInv = importer.importSerializable();

        String[][] inventoryTable = new String[inventory.getItems().size()][3]; //InventoryViewModel
        for (int i = 0; i < wrappedInv.getList().size(); i++) {

            if ( wrappedInv.getList().get(i) instanceof InventoryItem) {
                InventoryItem item = (InventoryItem) wrappedInv.getList().get(i);
                inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode()};
            } else {
                //this.inventory.addOrder((Order) obj);
                //TODO
            }


        }
    }
}
