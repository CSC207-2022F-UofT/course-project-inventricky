package delete_inventory_use_case;

import Screens.InventoryViewModel;

public interface DeleteInventoryInputBoundary {

    InventoryViewModel deleteInventory(DeleteInventoryRequestModel requestModel, boolean testing);
}
