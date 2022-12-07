package remove_item_use_case;

import Screens.InventoryViewModel;

public interface RemoveItemPresenter {

    //item removed from database, display item details
    InventoryViewModel prepareSuccessView(RemoveItemResponseModel oldItem, String[][] inventoryTable);

    RemoveItemResponseModel prepareFailView(String error); //TODO more speicific errors
}
