package import_use_case;

import Screens.InventoryViewModel;
import database.Importer;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;

import java.util.HashMap;

public class ImportInventory implements ImportInputBoundary{
    private final Inventory inventory;

    final ImportPresenter importPresenter;

    HashMap controllers;

    public ImportInventory(Inventory inv, ImportPresenter presenter, HashMap controllers) {
        this.inventory = inv;
        this.importPresenter = presenter;
        this.controllers = controllers;
    }

    @Override
    public InventoryViewModel create(ImportRequestModel importRequestModel) {
        Importer importer = new Importer(importRequestModel.getFileName());

        ImportDataWrapper wrappedInv = importer.importSerializable();

        String[][] inventoryTable = new String[wrappedInv.getList().size()][7]; //InventoryViewModel
        for (int i = 0; i < wrappedInv.getList().size(); i++) {

            if ( wrappedInv.getList().get(i) instanceof InventoryItem) {
                InventoryItem item = (InventoryItem) wrappedInv.getList().get(i);
                inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode(),
                        item.getBuyPrice()+"", item.getSellPrice()+"",
                        Integer.toString(item.getCaseQuantity()), item.getDepartment()};
                inventory.addItem(item);
            } else {
                //this.inventory.addOrder((Order) obj);
                //TODO
            }



        }
        return importPresenter.prepareSuccessView(inventoryTable, controllers, importRequestModel.getInvName());
    }
}
