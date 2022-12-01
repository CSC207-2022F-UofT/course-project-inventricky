package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import remove_item_use_case.RemoveItemResponseModel;

public interface UpdateItemQtyPresenter {

    //item removed from database, display item details
    InventoryViewModel prepareSuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable);

    RemoveItemResponseModel prepareFailView(String error); //TODO more speicific errors
}
