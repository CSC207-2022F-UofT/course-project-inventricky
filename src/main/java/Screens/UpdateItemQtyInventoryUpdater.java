package Screens;

import remove_item_use_case.RemoveItemResponseModel;
import update_item_quantity_use_case.UpdateItemQtyPresenter;
import update_item_quantity_use_case.UpdateItemQtyResponseModel;

public class UpdateItemQtyInventoryUpdater implements UpdateItemQtyPresenter {
    @Override
    public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable, String[] inventoryHistory) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable, inventoryHistory);


        //if item history is open
        if (ItemHistoryScreen.getOpenScreen(item.getBarcode()) != null) {
            //dispose screen
            ItemHistoryScreen.getOpenScreen(item.getBarcode()).dispose();
            //update history screen
            ItemHistoryViewModel itemHistoryViewModel = new ItemHistoryViewModel(item.getItemHistory());
            new ItemHistoryScreen(itemHistoryViewModel);
        }


        InventoryUI invUI = new InventoryUI(inventoryViewModel);
        OrderHistoryUI.setParent(invUI);
        return inventoryViewModel;
    }

    @Override
    public InventoryViewModel prepareQtyFailView(String error) {
        return null;
    }

    @Override
    public ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item) {
        ItemHistoryViewModel itemHistoryViewModel = new ItemHistoryViewModel(item.getItemHistory());


        //if item history is open
        if (ItemHistoryScreen.getOpenScreen(item.getBarcode()) != null) {
            //dispose screen
            ItemHistoryScreen.getOpenScreen(item.getBarcode()).dispose();
        }
        new ItemHistoryScreen(itemHistoryViewModel);
        return itemHistoryViewModel;
    }

    @Override
    public ItemHistoryViewModel prepareHistoryFailView(String error) {
        return null;
    }
}
