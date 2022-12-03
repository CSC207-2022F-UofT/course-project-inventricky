package Screens;

import remove_item_use_case.RemoveItemInputBoundary;
import remove_item_use_case.RemoveItemRequestModel;

public class RemoveItemController {

    final RemoveItemInputBoundary userInput;

    public RemoveItemController(RemoveItemInputBoundary itemGateway) { this.userInput = itemGateway; }

    InventoryViewModel create(String barcode) {

        RemoveItemRequestModel requestModel = new RemoveItemRequestModel(barcode);

        return userInput.create(requestModel);
    }
}
