package Screens;

import update_item_quantity_use_case.UpdateItemQtyInputBoundary;
import update_item_quantity_use_case.UpdateItemQtyRequestModel;

public class UpdateItemQtyController {

    //userInput is an interactor that implements the methods described by the interface
    final UpdateItemQtyInputBoundary userInput;

    //userInput is an interactor that implements the methods described by the interface

    /** Construct a new update item qty controller.
     *
     * @param operationGateway      use case interactor for adding a new item.
     */
    public UpdateItemQtyController(UpdateItemQtyInputBoundary operationGateway) {
        this.userInput = operationGateway;
    }

    //take in input from the user

    /** Update selected item quantity.
     *
     * @param barcode       barcode of selected item.
     * @param reason        reason for updating item; can be one of {"Bought", "Sold", "Error"}
     * @param newQuantity   quantity input for updating item.
     * @return              inventory view model or item history view model.
     */
    Object update(String barcode, String reason, double newQuantity) {

        //take user input and pass into the use case interactor
        UpdateItemQtyRequestModel requestModel = new UpdateItemQtyRequestModel(barcode, reason, newQuantity);

        if (reason.equals("history")) {
            return userInput.GetItemHistory(requestModel);
        }
        return userInput.updateQty(requestModel);

    }
}

