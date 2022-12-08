package new_item_use_case;

import Screens.InventoryViewModel;

//Input boundary
public interface NewItemInputBoundary {

    /** Input boundary for new item use case.
     *
     * @param requestModel  item to be added to inventory.
     * @param testing       true if the use case is being called for testing.
     * @return              inventory view model for updating inventory screen.
     */
    InventoryViewModel addItem(NewItemRequestModel requestModel, boolean testing);
}

