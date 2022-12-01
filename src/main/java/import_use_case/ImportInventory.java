package import_use_case;

import database.Importer;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;

import java.util.HashMap;

public class ImportInventory {
    private final Inventory inventory;

    final ImportPresenter importPresenter;

    String filename;

    HashMap controllers;

    public ImportInventory(Inventory inv, String filename, ImportPresenter presenter, HashMap controllers) {
        this.inventory = inv;
        this.importPresenter = presenter;
        this.filename = filename;
        this.controllers = controllers;
    }

    public void importToInventory() {
        Importer importer = new Importer(filename);

        ImportDataWrapper wrappedInv = importer.importSerializable();

        String[][] inventoryTable = new String[wrappedInv.getList().size()][3]; //InventoryViewModel
        for (int i = 0; i < wrappedInv.getList().size(); i++) {

            if ( wrappedInv.getList().get(i) instanceof InventoryItem) {
                InventoryItem item = (InventoryItem) wrappedInv.getList().get(i);
                inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode()};
                inventory.addItem(item);
            } else {
                //this.inventory.addOrder((Order) obj);
                //TODO
            }



        }
        importPresenter.prepareSuccessView(inventoryTable, controllers);
    }
}
