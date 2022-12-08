package Screens;

import display_use_case.DisplayPresenter;
import new_item_use_case.NewItemResponseModel;

public class DisplayInventoryUpdater implements DisplayPresenter {
    /**
     *
     * @param inventoryViewModel Contains items that are to be displayed
     * @return items that are to be displayed
     */
    @Override
    public InventoryViewModel prepareSuccessView(InventoryViewModel inventoryViewModel) {

        new DisplayUI(inventoryViewModel);
        return inventoryViewModel;
    }

    /**
     *
     * @param error message for what error occurred
     * @return nothing
     */
    @Override
    public NewItemResponseModel prepareFailView(String error) {
        return null;
    }
}
