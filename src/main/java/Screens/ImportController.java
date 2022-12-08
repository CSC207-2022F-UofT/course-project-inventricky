package Screens;

import import_use_case.ImportInputBoundary;
import import_use_case.ImportInventory;
import import_use_case.ImportRequestModel;
import new_item_use_case.NewItemInputBoundary;
import new_item_use_case.NewItemRequestModel;

public class ImportController {
    //userInput is an interactor that implements the methods described by the interface
    final ImportInputBoundary userInput;

    //userInput is an interactor that implements the methods described by the interface
    public ImportController(ImportInputBoundary importGateway) {
        this.userInput = importGateway;
    }

    //take in input from the user
    InventoryViewModel create(String invName, String fileName) {

        //take user input and pass into the use case interactor
        ImportRequestModel importRequestModel = new ImportRequestModel(invName, fileName);

        return userInput.create(importRequestModel);

    }
}



