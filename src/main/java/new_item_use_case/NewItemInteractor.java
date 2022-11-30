package new_item_use_case;

import Screens.InventoryViewModel;
import entities.Inventory;
import entities.InventoryItem;

//Use case interactor
public class NewItemInteractor implements NewItemInputBoundary {

    final NewItemDsGateway newItemDsGateway;        //interactor needs an inventory, talks to database
    final NewItemPresenter newItemPresenter;    //presenter

    private Inventory inventory;

    //pass in data access class, presenter
    public NewItemInteractor(NewItemDsGateway newItemDsGateway, NewItemPresenter newItemDsPresenter, Inventory inventory) {
        this.newItemDsGateway = newItemDsGateway;
        this.newItemPresenter = newItemDsPresenter;
        this.inventory = inventory;
    }

    //returns output data, takes in input data
    @Override
    public InventoryViewModel create(NewItemRequestModel requestModel) {

        //create new InventoryItem
        //TODO right now this assumes valid input
        InventoryItem item = new InventoryItem(requestModel.getName(), requestModel.getIsWeight(),
                requestModel.getQuantity(), requestModel.getBuyPrice(), requestModel.getSellPrice(),
                requestModel.getCaseQuantity(), requestModel.getDepartment(), 0, 0);
        //add the inventory item to inventory
        inventory.addItem(item);

        //TODO implement time functionality

        //return new item's name and barcode to the presenter, along with inventory
        NewItemResponseModel itemResponseModel = new NewItemResponseModel(item.getName(), item.getBarcode());

        String[][] inventoryTable = new String[inventory.getItems().size()][3];

        for (int i = 0; i < inventory.getItems().size(); i++) {
            inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode()};
        }

        return newItemPresenter.prepareSuccessView(itemResponseModel, inventoryTable);
    }
}
