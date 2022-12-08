package new_item_use_case;

import Screens.InventoryViewModel;
import entities.Inventory;
import entities.InventoryItem;

//Use case interactor
public class NewItemInteractor implements NewItemInputBoundary {

    final NewItemPresenter newItemPresenter;    //presenter

    private final Inventory inventory;


    /** Concstruct use case interactor for adding new items.
     *
     * @param newItemPresenter      presenter for updating view model.
     * @param inventory             inventory for new item to be added to.
     */
    public NewItemInteractor(NewItemPresenter newItemPresenter, Inventory inventory) {
        this.newItemPresenter = newItemPresenter;
        this.inventory = inventory;
    }

    /** Add item to inventory.
     *
     * @param requestModel      request model contatining data of item to be added to inventory.
     * @param testing           true if method is being called during tests.
     * @return                  a 2d string array representing the inventory.
     */
    @Override
    public InventoryViewModel addItem(NewItemRequestModel requestModel, boolean testing) {

        //create new InventoryItem
        InventoryItem newItem;

        if (testing) {
            newItem = new InventoryItem(requestModel.getName(), "12345", requestModel.getIsWeight(),
                    requestModel.getQuantity(), requestModel.getBuyPrice(), requestModel.getSellPrice(),
                    requestModel.getCaseQuantity(), requestModel.getDepartment(), 0, 0);
        } else {
            newItem = new InventoryItem(requestModel.getName(), requestModel.getIsWeight(),
                    requestModel.getQuantity(), requestModel.getBuyPrice(), requestModel.getSellPrice(),
                    requestModel.getCaseQuantity(), requestModel.getDepartment(), 0, 0);
        }

        //add the inventory item to inventory
        inventory.addItem(newItem);

        //return new item's name and barcode to the presenter, along with inventory
        NewItemResponseModel newItemResponseModel = new NewItemResponseModel(newItem.getName(), newItem.getBarcode());

        String[][] inventoryTable = new String[inventory.getItems().size()][7];
        String[] inventoryHistory = inventory.getHistory().toArray(new String[0]);

        for (int i = 0; i < inventory.getItems().size(); i++) {
            InventoryItem item = inventory.getItems().get(i);
            inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode(),
                    item.getBuyPrice() + "", item.getSellPrice() + "",
                    Integer.toString(item.getCaseQuantity()), item.getDepartment()};
        }

        return newItemPresenter.prepareSuccessView(newItemResponseModel, inventoryTable, inventoryHistory);
    }
}

