package Screens;

import new_item_use_case.NewItemPresenter;
import new_item_use_case.NewItemResponseModel;

//TODO implement methods
public class NewItemInventoryUpdater implements NewItemPresenter {
    /** Update inventory screen with new item.
     *
     * @param item              Item to be added to inventory.
     * @param inventoryTable    2d array representing the inventory.
     * @return                  inventory view model containing inventory table.
     */
    @Override
    public InventoryViewModel prepareSuccessView(NewItemResponseModel item, String[][] inventoryTable, String[] inventoryHistory) {
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable, inventoryHistory);

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
    public NewItemResponseModel prepareFailView(String error) {
        return null;
    }
}
