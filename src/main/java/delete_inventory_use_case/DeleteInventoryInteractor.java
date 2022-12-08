package delete_inventory_use_case;

import Screens.InventoryViewModel;
import database_access.Deleter;

import java.util.HashMap;

public class DeleteInventoryInteractor implements DeleteInventoryInputBoundary{

    private final DeleteInventoryPresenter deleteInventoryPresenter;
    private final HashMap controllers;

    /** The Interactor for Inventory deletion.
     * @param deleteInventoryPresenter The presenter.
     * @param controllers The associated controllers.
     */
    public DeleteInventoryInteractor(DeleteInventoryPresenter deleteInventoryPresenter, HashMap controllers) {
        this.deleteInventoryPresenter = deleteInventoryPresenter;
        this.controllers = controllers;
    }

    /** Makes the call for the inventory to be deleted.
     * @param requestModel Request model for deletion.
     * @param testing Boolean for testing.
     * @return The InventoryViewModel after deletion.
     */
    @Override
    public InventoryViewModel deleteInventory(DeleteInventoryRequestModel requestModel, boolean testing) {
        Deleter deleter = new Deleter();
        deleter.deleteInventory(requestModel.invName);
        return deleteInventoryPresenter.prepareSuccessView(controllers);
    }
}
