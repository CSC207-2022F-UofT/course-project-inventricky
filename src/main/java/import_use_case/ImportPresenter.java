package import_use_case;

import Screens.InventoryViewModel;
import new_item_use_case.NewItemResponseModel;

import java.util.HashMap;

public interface ImportPresenter {

    InventoryViewModel prepareSuccessView(String[][] inventoryTable, String[] inventoryHistory, HashMap controllers, String invName);

    NewItemResponseModel prepareFailView(String error);


}
