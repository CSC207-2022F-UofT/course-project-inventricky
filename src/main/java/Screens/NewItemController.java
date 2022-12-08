package Screens;

import new_item_use_case.NewItemInputBoundary;
import new_item_use_case.NewItemRequestModel;

//DONE
public class NewItemController {

    //userInput is an interactor that implements the methods described by the interface
    final NewItemInputBoundary userInput;

    //userInput is an interactor that implements the methods described by the

    /** Construct a new item controller.
     *
     * @param itemGateway   use case interactor for adding new item.
     */
    public NewItemController(NewItemInputBoundary itemGateway) {
        this.userInput = itemGateway;
    }

    //take in input from the user

    /** Add a new item to the inventory
     *
     * @param name          name of item to be added.
     * @param isWeight      true if item to be added is quantified in kg.
     * @param buyPrice      buy price of item to be added.
     * @param sellPrice     sell price of item to be added.
     * @param caseQuantity  case quantity of item to be added.
     * @param department    department number of item to be added.
     * @return              inventory view model containing table representation of inventory.
     */
    InventoryViewModel addItem(String name, boolean isWeight, double buyPrice,
                               double sellPrice, int caseQuantity, String department) {

        //take user input and pass into the use case interactor
        NewItemRequestModel requestModel = new NewItemRequestModel(name, isWeight, 0,
                buyPrice, sellPrice, caseQuantity, department);

        return userInput.addItem(requestModel, false);

    }
}

