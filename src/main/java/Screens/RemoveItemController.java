package Screens;

import remove_item_use_case.RemoveItemInputBoundary;
import remove_item_use_case.RemoveItemRequestModel;

public class RemoveItemController {

    final RemoveItemInputBoundary userInput;

    /** Construct a new remove item controller.
     *
     * @param itemGateway       use case interactor for adding a new item.
     */
    public RemoveItemController(RemoveItemInputBoundary itemGateway) { this.userInput = itemGateway; }

    /** Remove item from inventory.
     *
     * @param barcode       barcode of item to be removed from inventory.
     * @return              inventory view model containing table representation of inventory.
     */
    InventoryViewModel removeItem(String barcode) {

        RemoveItemRequestModel requestModel = new RemoveItemRequestModel(barcode);

        return userInput.removeItem(requestModel, false);
    }
}
