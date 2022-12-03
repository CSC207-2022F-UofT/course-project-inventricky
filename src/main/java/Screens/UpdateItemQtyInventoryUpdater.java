package Screens;

import remove_item_use_case.RemoveItemResponseModel;
import update_item_quantity_use_case.UpdateItemQtyPresenter;
import update_item_quantity_use_case.UpdateItemQtyResponseModel;

public class UpdateItemQtyInventoryUpdater implements UpdateItemQtyPresenter {
    @Override
    public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel Item, String[][] inventoryTable) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable);

        new InventoryUI(inventoryViewModel);
        return inventoryViewModel;
    }

    @Override
    public InventoryViewModel prepareQtyFailView(String error) {
        return null;
    }

    @Override
    public ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item) {
        ItemHistoryViewModel itemHistoryViewModel = new ItemHistoryViewModel(item.getItemHistory());

        new ItemHistoryScreen(itemHistoryViewModel);
        return itemHistoryViewModel;
    }

    @Override
    public ItemHistoryViewModel prepareHistoryFailView(String error) {
        return null;
    }
}
