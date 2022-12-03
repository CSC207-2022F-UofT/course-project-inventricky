package Screens;

import import_use_case.ImportPresenter;
import new_item_use_case.NewItemResponseModel;

import java.util.HashMap;

public class ImportInventoryUpdater implements ImportPresenter {

    @Override
    public InventoryViewModel prepareSuccessView(String[][] inventoryTable, HashMap controllers, String invName) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable);
        InventoryUI newInv = new InventoryUI(inventoryViewModel);
        newInv.setName(invName);
        newInv.refresh();
        newInv.setControllers(controllers);
        return inventoryViewModel;
    }

    @Override
    public NewItemResponseModel prepareFailView(String error) //TODO more speicific errors
    {
        return null;
    }

}
