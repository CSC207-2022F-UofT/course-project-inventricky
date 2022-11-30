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
    public InventoryViewModel create(RemoveItemRequestModel requestModel) {

        //Search for item in Inventory
        //TODO case where item is not in inventory




            for (InventoryItem item : inventory.getItems()) {
                if (item.getBarcode().equals(requestModel.getBarcode())) {
                    inventory.removeItem(item);

                    RemoveItemResponseModel removeItemReponseModel = new RemoveItemResponseModel(item.getName(), item.getBarcode());

                    String[][] inventoryTable = new String[inventory.getItems().size()][3];

                    for (int i = 0; i < inventory.getItems().size(); i++) {
                        inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode()};
                    }

                    return removeItemPresenter.prepareSuccessView(removeItemReponseModel, inventoryTable);

                }
            }

        return null; //TODO exception

    }
}
