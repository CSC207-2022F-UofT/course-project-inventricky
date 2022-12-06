package Screens;

import remove_item_use_case.RemoveItemPresenter;
import remove_item_use_case.RemoveItemResponseModel;

public class RemoveItemInventoryUpdater implements RemoveItemPresenter {
    @Override
    public InventoryViewModel prepareSuccessView(RemoveItemResponseModel oldItem, String[][] inventoryTable, String[] inventoryHistory) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable, inventoryHistory);

        new InventoryUI(inventoryViewModel);
        return inventoryViewModel;
    }

    @Override
    public RemoveItemResponseModel prepareFailView(String error) {
        return null;
    }
}
