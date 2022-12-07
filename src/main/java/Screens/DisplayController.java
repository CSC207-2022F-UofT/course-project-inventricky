package Screens;

import DisplayUseCase.DisplayInputBoundary;
import DisplayUseCase.DisplayRequestModel;

public class DisplayController {
    final DisplayInputBoundary userInput;

    /**
     *
     * @param itemGateway The DisplayInputBoundary that will become an instance variable for this class
     */
    public DisplayController(DisplayInputBoundary itemGateway) {
        this.userInput = itemGateway;
    }

    /**
     *
     * @param inventoryViewModel Contains the items in the inventory
     * @param action what you want to do. Options are searchResults, filterDepartment, sortName, sortBarcode,
     *      *               sortQuantity, sorBuyPrice, sortSellPrice, sortCaseQuantity
     *      * @param parameter boolean for sort based on normal versus reverse order, strings for filterDepartment and
     *      *                  serachResults based on what you are searching or filtering.
     * @return Updated items ready to be used by the view
     */
    InventoryViewModel create(InventoryViewModel inventoryViewModel, String action, Object Parameter) {
        DisplayRequestModel requestModel = new DisplayRequestModel(inventoryViewModel, action, Parameter);
        return userInput.create(requestModel);
    }
}
