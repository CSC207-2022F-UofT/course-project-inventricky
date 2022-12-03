package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;


public interface UpdateItemQtyInputBoundary {

        InventoryViewModel UpdateQty(UpdateItemQtyRequestModel requestModel);

        ItemHistoryViewModel GetItemHistory(UpdateItemQtyRequestModel requestModel);
    }

