package remove_item_use_case;

import Screens.InventoryViewModel;

public interface RemoveItemInputBoundary {

    InventoryViewModel removeItem(RemoveItemRequestModel requestModel, boolean testing) throws RuntimeException;
}
