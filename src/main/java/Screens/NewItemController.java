package Screens;

import new_item_use_case.NewItemInputBoundary;
import new_item_use_case.NewItemRequestModel;
import new_item_use_case.NewItemResponseModel;

//DONE
public class NewItemController {

    //userInput is an interactor that implements the methods described by the interface
    final NewItemInputBoundary userInput;

    //userInput is an interactor that implements the methods described by the interface
    public NewItemController(NewItemInputBoundary itemGateway) {
        this.userInput = itemGateway;
    }

    //take in input from the user
    InventoryViewModel create(String name, boolean isWeight, double quantity, double buyPrice,
                                double sellPrice, int caseQuantity, String department) {

        //take user input and pass into the use case interactor
        NewItemRequestModel requestModel = new NewItemRequestModel(name, isWeight, quantity,
                buyPrice, sellPrice, caseQuantity, department);

        return userInput.create(requestModel);

    }
}
