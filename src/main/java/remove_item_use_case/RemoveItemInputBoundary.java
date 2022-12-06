package remove_item_use_case;

import Screens.InventoryViewModel;

public interface RemoveItemInputBoundary {
    /** Input boundary for remove item use case.
     *
     * @param requestModel          item to be removed from inventory.
     * @param testing               true if the use case is being called for testing.
     * @return                      inventory view model for updating inventory screen.
     * @throws RuntimeException     item to be removed not found in inventory.
     */
    InventoryViewModel removeItem(RemoveItemRequestModel requestModel, boolean testing) throws RuntimeException;
}
