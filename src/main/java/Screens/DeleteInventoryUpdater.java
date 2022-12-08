package Screens;

import delete_inventory_use_case.DeleteInventoryPresenter;

import java.util.HashMap;

public class DeleteInventoryUpdater implements DeleteInventoryPresenter {

    /** Makes a new MainCreationUI and updates InventoryViewModel.
     * @param controllers The associated controllers.
     * @return The new blank InventoryViewModel
     */
    @Override
    public InventoryViewModel prepareSuccessView(HashMap controllers) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(new String[][] {}, new String[] {});
        new MainCreationUI(controllers);
        return inventoryViewModel;
    }
}
