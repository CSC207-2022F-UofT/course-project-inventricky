package remove_item_use_case;

import Screens.InventoryViewModel;
import new_item_use_case.NewItemResponseModel;

public interface RemoveItemPresenter {

    //item removed from database, display item details
    InventoryViewModel prepareSuccessView(RemoveItemResponseModel oldItem, String[][] inventoryTable, String[] inventoryHistory);

    RemoveItemResponseModel prepareFailView(String error); //TODO more speicific errors
}
