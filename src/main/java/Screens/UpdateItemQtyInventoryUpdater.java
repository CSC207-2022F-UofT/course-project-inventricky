package Screens;

import remove_item_use_case.RemoveItemResponseModel;
import update_item_quantity_use_case.UpdateItemQtyPresenter;
import update_item_quantity_use_case.UpdateItemQtyResponseModel;

public class UpdateItemQtyInventoryUpdater implements UpdateItemQtyPresenter {
    @Override
    public InventoryViewModel prepareSuccessView(UpdateItemQtyResponseModel Item, String[][] inventoryTable) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable);

        new InventoryUI(inventoryViewModel);
        return inventoryViewModel;
    }

    @Override
    public RemoveItemResponseModel prepareFailView(String error) {
        return null;
    }
}
