package Screens;

import update_item_quantity_use_case.UpdateItemQtyPresenter;
import update_item_quantity_use_case.UpdateItemQtyResponseModel;

import java.util.Objects;

public class UpdateItemQtyInventoryUpdater implements UpdateItemQtyPresenter {

    /** Update inventory screen with updated item quantity.
     *
     * @param item              updated item.
     * @param inventoryTable    2d string array representing inventory.
     * @return                  inventory view model containing inventory table.
     */
    @Override
    public InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable, String[] inventoryHistory) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable, inventoryHistory);


        //if item history is open
        if (ItemHistoryScreen.getOpenScreen(item.getBarcode()) != null) {
            //dispose screen
            Objects.requireNonNull(ItemHistoryScreen.getOpenScreen(item.getBarcode())).dispose();
            //update history screen
            ItemHistoryViewModel itemHistoryViewModel = new ItemHistoryViewModel(item.getItemHistory());
            new ItemHistoryScreen(itemHistoryViewModel);
        }


        InventoryUI invUI = new InventoryUI(inventoryViewModel);
        OrderHistoryUI.setParent(invUI);
        return inventoryViewModel;
    }

    /** Show error message on fail.
     *
     * @param error error message
     * @return      error message
     */
    @Override
    public InventoryViewModel prepareQtyFailView(String error) {
        return null;
    }

    /** Show item history screen
     *
     * @param item      selected item
     * @return          item history view model
     */
    @Override
    public ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item) {
        ItemHistoryViewModel itemHistoryViewModel = new ItemHistoryViewModel(item.getItemHistory());


        //if item history is open
        if (ItemHistoryScreen.getOpenScreen(item.getBarcode()) != null) {
            //dispose screen
            Objects.requireNonNull(ItemHistoryScreen.getOpenScreen(item.getBarcode())).dispose();
        }
        new ItemHistoryScreen(itemHistoryViewModel);
        return itemHistoryViewModel;
    }

    /** Show error message on fail
     *
     * @param error error message
     * @return      error message
     */
    @Override
    public ItemHistoryViewModel prepareHistoryFailView(String error) {
        return null;
    }
}

