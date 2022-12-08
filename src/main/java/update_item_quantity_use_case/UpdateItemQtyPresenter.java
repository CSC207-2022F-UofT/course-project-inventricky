package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;

public interface UpdateItemQtyPresenter {

    //item removed from database, display item details

    /** Presenters must implement this method.
     *
     *
     * @param item              selected item to be updated.
     * @param inventoryTable    2d string array representing inventory.
     * @return                  inventory view model containing inventory in table format.
     */
    InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable, String[] inventoryHistory);

    InventoryViewModel prepareQtyFailView(String error);

    /** Presenters must implement this method.
     *
     * @param item              selected item.
     * @return                  item history view model containing item history.
     */
    ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item);
    ItemHistoryViewModel prepareHistoryFailView(String error);



}
