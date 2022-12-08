package delete_inventory_use_case;

import Screens.InventoryViewModel;
import database_access.Deleter;

import java.util.HashMap;

public class DeleteInventoryInteractor implements DeleteInventoryInputBoundary{

    private final DeleteInventoryPresenter deleteInventoryPresenter;
    private final HashMap controllers;

    public DeleteInventoryInteractor(DeleteInventoryPresenter deleteInventoryPresenter, HashMap controllers) {
        this.deleteInventoryPresenter = deleteInventoryPresenter;
        this.controllers = controllers;
    }
    @Override
    public InventoryViewModel deleteInventory(DeleteInventoryRequestModel requestModel, boolean testing) {
        Deleter deleter = new Deleter();
        deleter.deleteInventory(requestModel.invName);
        return deleteInventoryPresenter.prepareSuccessView(controllers);
    }
}
