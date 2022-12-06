package Screens;

import new_item_use_case.NewItemPresenter;
import new_item_use_case.NewItemResponseModel;

//TODO implement methods
public class NewItemInventoryUpdater implements NewItemPresenter {
    @Override
    public InventoryViewModel prepareSuccessView(NewItemResponseModel item, String[][] inventoryTable) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable);

        InventoryUI invUI = new InventoryUI(inventoryViewModel);
        OrderHistoryUI.setParent(invUI);
        return inventoryViewModel;
    }

    @Override
    public NewItemResponseModel prepareFailView(String error) {
        return null;
    }
}
