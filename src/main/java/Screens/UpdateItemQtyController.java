package Screens;

import update_item_quantity_use_case.UpdateItemQtyInputBoundary;
import update_item_quantity_use_case.UpdateItemQtyRequestModel;

public class UpdateItemQtyController {

    //userInput is an interactor that implements the methods described by the interface
    final UpdateItemQtyInputBoundary userInput;

    //userInput is an interactor that implements the methods described by the interface
    public UpdateItemQtyController(UpdateItemQtyInputBoundary operationGateway) {
        this.userInput = operationGateway;
    }

    //take in input from the user
    Object Update(String barcode, String reason, double newQuantity) {

        //take user input and pass into the use case interactor
        UpdateItemQtyRequestModel requestModel = new UpdateItemQtyRequestModel(barcode, reason, newQuantity);

        if (reason.equals("history")) {
            return userInput.GetItemHistory(requestModel);
        }
        return userInput.updateQty(requestModel);

    }
}
