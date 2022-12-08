package Screens;

import delete_inventory_use_case.DeleteInventoryInputBoundary;
import delete_inventory_use_case.DeleteInventoryRequestModel;

public class DeletionController {

    final DeleteInventoryInputBoundary userInput;

    public DeletionController(DeleteInventoryInputBoundary invGateway) {
        this.userInput = invGateway;
    }

    InventoryViewModel deleteInventory(String name) {
        DeleteInventoryRequestModel requestModel = new DeleteInventoryRequestModel(name);

        return userInput.deleteInventory(requestModel, false);
    }

}
