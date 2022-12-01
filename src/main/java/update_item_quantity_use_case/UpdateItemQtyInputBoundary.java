package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import remove_item_use_case.RemoveItemRequestModel;



    public interface UpdateItemQtyInputBoundary {

        InventoryViewModel create(UpdateItemQtyRequestModel requestModel);
    }

