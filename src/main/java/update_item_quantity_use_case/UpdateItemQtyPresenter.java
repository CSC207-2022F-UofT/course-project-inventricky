package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;

public interface UpdateItemQtyPresenter {

    //item removed from database, display item details
    InventoryViewModel prepareQtySuccessView(UpdateItemQtyResponseModel item, String[][] inventoryTable);


    InventoryViewModel prepareQtyFailView(String error);

    ItemHistoryViewModel prepareHistorySuccessView(UpdateItemQtyResponseModel item);
    ItemHistoryViewModel prepareHistoryFailView(String error);



}
