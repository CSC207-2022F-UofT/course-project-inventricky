package remove_item_use_case;

import Screens.InventoryViewModel;
import entities.Inventory;
import entities.InventoryItem;
import new_item_use_case.NewItemDsGateway;
import new_item_use_case.NewItemPresenter;

import java.io.IOException;

public class RemoveItemInteractor implements RemoveItemInputBoundary {

    final RemoveItemDsGateway removeItemDsGateway;        //interactor needs an inventory, talks to database
    final RemoveItemPresenter removeItemPresenter;    //presenter

    private Inventory inventory;

    //pass in data access class, presenter
    public RemoveItemInteractor(RemoveItemDsGateway removeItemDsGateway, RemoveItemPresenter removeItemDsPresenter, Inventory inventory) {
        this.removeItemDsGateway = removeItemDsGateway;
        this.removeItemPresenter = removeItemDsPresenter;
        this.inventory = inventory;
    }

    @Override
    public InventoryViewModel create(RemoveItemRequestModel requestModel) throws RuntimeException {

        //Search for item in Inventory
        //TODO case where item is not in inventory
            
            


            for (InventoryItem candidate : inventory.getItems()) {
                if (candidate.getBarcode().equals(requestModel.getBarcode())) {
                    inventory.removeItem(candidate);

                    RemoveItemResponseModel removeItemReponseModel = new RemoveItemResponseModel(candidate.getName(), candidate.getBarcode());

                    String[][] inventoryTable = new String[inventory.getItems().size()][3];

                    for (int i = 0; i < inventory.getItems().size(); i++) {
                        InventoryItem item = inventory.getItems().get(i);
                        inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode()};
                    }

                    return removeItemPresenter.prepareSuccessView(removeItemReponseModel, inventoryTable);

                }
            }

        RuntimeException RuntimeException = null;
        throw RuntimeException; //TODO exception

    }
}
