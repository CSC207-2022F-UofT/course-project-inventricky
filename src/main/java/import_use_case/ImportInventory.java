package import_use_case;

import Screens.InventoryViewModel;
import database_access.Importer;
import entities.Inventory;
import entities.InventoryItem;
import entities.Item;

import java.time.LocalDate;
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

        //Imported inventory must already have barcode csv in exports
        Item.setFile("src/main/java/exports/" + importRequestModel.getInvName() + ".csv");


        ImportDataWrapper wrappedInv = importer.importSerializable();

        String[][] inventoryTable = new String[wrappedInv.getList().size()][7]; //InventoryViewModel
        String[] inventoryHistory = new String[]{"Created from Import on " + LocalDate.now() + "."};
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
        return importPresenter.prepareSuccessView(inventoryTable, inventoryHistory, controllers, importRequestModel.getInvName());
    }
}
