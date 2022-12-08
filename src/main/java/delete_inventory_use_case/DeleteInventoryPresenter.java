package delete_inventory_use_case;

import Screens.InventoryViewModel;
import remove_item_use_case.RemoveItemResponseModel;

import java.util.HashMap;

public interface DeleteInventoryPresenter {

    InventoryViewModel prepareSuccessView(HashMap controllers);

}
