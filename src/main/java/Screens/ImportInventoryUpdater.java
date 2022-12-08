package Screens;

import import_use_case.ImportPresenter;

import java.util.HashMap;

public class ImportInventoryUpdater implements ImportPresenter {
    /**
     * Must be implemented by presenters.
     *
     * @param inventoryTable table representation of inventory
     * @param controllers hashmap of controller objects
     * @param invName name of inventory
     * @return InventoryViewModel returns an inventoryViewModel
     */
    @Override
    public InventoryViewModel prepareSuccessView(String[][] inventoryTable, HashMap<String, Object> controllers, String invName) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable);
        InventoryUI newInv = new InventoryUI(inventoryViewModel);
        newInv.setName(invName);
        newInv.refresh();
        newInv.setControllers(controllers);
        return inventoryViewModel;
    }

}
