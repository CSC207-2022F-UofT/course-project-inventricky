package Screens;

import delete_inventory_use_case.DeleteInventoryPresenter;

import java.util.HashMap;

public class DeleteInventoryUpdater implements DeleteInventoryPresenter {

    @Override
    public InventoryViewModel prepareSuccessView(HashMap controllers) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(new String[][] {}, new String[] {});
        new MainCreationUI(controllers);
        return inventoryViewModel;
    }
}
