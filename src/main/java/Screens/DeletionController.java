package Screens;

import delete_inventory_use_case.DeleteInventoryInputBoundary;
import delete_inventory_use_case.DeleteInventoryRequestModel;

public class DeletionController {

    final DeleteInventoryInputBoundary userInput;

    /** Initializes DeletionController.
     * @param invGateway Input boundary.
     */
    public DeletionController(DeleteInventoryInputBoundary invGateway) {
        this.userInput = invGateway;
    }

    /**
     * @param name Name of inventory to be deleted.
     * @return New InventoryViewModel.
     */
    InventoryViewModel deleteInventory(String name) {
        DeleteInventoryRequestModel requestModel = new DeleteInventoryRequestModel(name);

        return userInput.deleteInventory(requestModel, false);
    }

}
