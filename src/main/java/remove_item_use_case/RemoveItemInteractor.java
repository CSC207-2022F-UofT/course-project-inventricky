package remove_item_use_case;

import Screens.InventoryViewModel;
import entities.Inventory;
import entities.InventoryItem;

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
    public InventoryViewModel removeItem(RemoveItemRequestModel requestModel, boolean testing) throws RuntimeException {

        //Search for item in Inventory
        //TODO case where item is not in inventory
            
            


            for (InventoryItem candidate : inventory.getItems()) {
                if (candidate.getBarcode().equals(requestModel.getBarcode())) {
                    inventory.removeItem(candidate, testing);

                    RemoveItemResponseModel removeItemResponseModel = new RemoveItemResponseModel(candidate.getName(), candidate.getBarcode());

                    String[][] inventoryTable = new String[inventory.getItems().size()][7];

                    for (int i = 0; i < inventory.getItems().size(); i++) {
                        InventoryItem item = inventory.getItems().get(i);
                        inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode(),
                                item.getBuyPrice()+"", item.getSellPrice()+"",
                                Integer.toString(item.getCaseQuantity()), item.getDepartment()};
                    }

                    return removeItemPresenter.prepareSuccessView(removeItemResponseModel, inventoryTable);

                }
            }

        RuntimeException RuntimeException = null;
        throw RuntimeException; //TODO exception

    }
}
