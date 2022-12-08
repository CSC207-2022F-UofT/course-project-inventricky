package Screens;

import remove_item_use_case.RemoveItemPresenter;
import remove_item_use_case.RemoveItemResponseModel;

public class RemoveItemInventoryUpdater implements RemoveItemPresenter {

    /** Update inventory screen with removed item.
     *
     * @param oldItem           item removed from inventory.
     * @param inventoryTable    2d string array representing inventory.
     * @return                  inventory view model containing inventory table.
     */
    @Override
    public InventoryViewModel prepareSuccessView(RemoveItemResponseModel oldItem, String[][] inventoryTable, String[] inventoyryHistory) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable, inventoyryHistory);

        new InventoryUI(inventoryViewModel);
        return inventoryViewModel;
    }

    /** Show error message on fail.
     *
     * @param error error message
     * @return      error message
     */
    @Override
    public RemoveItemResponseModel prepareFailView(String error) {
        return null;
    }
}

