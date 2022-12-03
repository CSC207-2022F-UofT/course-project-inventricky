package update_item_quantity_use_case;

import Screens.InventoryItemMenu;
import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;
import remove_item_use_case.RemoveItemResponseModel;

public interface UpdateItemQtyPresenter {

    //item removed from database, display item details
    InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable);


    InventoryViewModel prepareQtyFailView(String error); //TODO more speciific errors

    ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item);
    ItemHistoryViewModel prepareHistoryFailView(String error);



}
