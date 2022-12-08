package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;


public interface UpdateItemQtyInputBoundary {

    /** Input boundary for updating item quantity
     *
     * @param requestModel      request model containing selected item and what action to perform.
     * @return                  inventory view model containing inventory table.
     */
    InventoryViewModel updateQty(UpdateItemQtyRequestModel requestModel);

    /** Input boundary for getting item history.
     *
     * @param requestModel      request model containing selected item.
     * @return                  item history view model containing item history.
     */
    ItemHistoryViewModel GetItemHistory(UpdateItemQtyRequestModel requestModel);
}

