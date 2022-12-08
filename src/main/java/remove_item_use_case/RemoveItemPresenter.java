package remove_item_use_case;

import Screens.InventoryViewModel;

public interface RemoveItemPresenter {

    //item removed from database, display item details

    /** Presenters must implement this method.
     *
     * @param oldItem           item removed from inventory.
     * @param inventoryTable    2d string array representing inventory.
     * @return                  inventory view model contatining inventory in table format.
     */
    InventoryViewModel prepareSuccessView(RemoveItemResponseModel oldItem, String[][] inventoryTable, String[] inventoryHistor);

    RemoveItemResponseModel prepareFailView(String error);
}
