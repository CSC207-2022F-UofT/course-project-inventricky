package remove_item_use_case;

import Screens.InventoryViewModel;
import new_item_use_case.NewItemRequestModel;

public interface RemoveItemInputBoundary {

    InventoryViewModel create(RemoveItemRequestModel requestModel);
}
