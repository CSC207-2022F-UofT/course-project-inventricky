package new_item_use_case;

import Screens.InventoryViewModel;

//Presenter
public interface NewItemPresenter {

    /** Presenters must implement this method
     *
     * @param newItem           Item to be added to inventory
     * @param inventoryTable    2d array representing the inventory
     * @return                  Inventory view model for the inventory view to update screen
     */
    InventoryViewModel prepareSuccessView(NewItemResponseModel newItem, String[][] inventoryTable, String[] inventoryHistory);

    /** Presenters must implement this method
     *
     * @param error error message
     * @return      name and barcode of item failed to be added
     */
    NewItemResponseModel prepareFailView(String error);
}
