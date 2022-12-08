package display_use_case;

import Screens.InventoryViewModel;
import new_item_use_case.NewItemResponseModel;

public interface DisplayPresenter {
    InventoryViewModel prepareSuccessView(InventoryViewModel inventoryViewModel);

    NewItemResponseModel prepareFailView(String error);
}
