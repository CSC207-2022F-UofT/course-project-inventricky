package remove_item_use_case;

import Screens.InventoryViewModel;
import entities.Inventory;
import entities.InventoryItem;

public class RemoveItemInteractor implements RemoveItemInputBoundary {

    final RemoveItemPresenter removeItemPresenter;    //presenter

    private final Inventory inventory;

    //pass in data access class, presenter

    /** Construct use case interactor
     *
     * @param removeItemPresenter   presenter for updating inventory screen.
     * @param inventory             current inventory.
     */
    public RemoveItemInteractor(RemoveItemPresenter removeItemPresenter, Inventory inventory) {
        this.removeItemPresenter = removeItemPresenter;
        this.inventory = inventory;
    }

    /** Remove item from inventory.
     *
     * @param requestModel          item to be removed from inventory.
     * @param testing               true if the use case is being called for testing.
     * @return                      inventory view model containing inventory in table format.
     * @throws RuntimeException     failed to remove item from inventory.
     */
    @Override
    public InventoryViewModel removeItem(RemoveItemRequestModel requestModel, boolean testing) throws RuntimeException {



        //Search for item in Inventory
            for (InventoryItem candidate : inventory.getItems()) {
                if (candidate.getBarcode().equals(requestModel.getBarcode())) {
                    inventory.removeItem(candidate, testing);

                    RemoveItemResponseModel removeItemResponseModel = new RemoveItemResponseModel(candidate.getName(), candidate.getBarcode());

                    String[][] inventoryTable = new String[inventory.getItems().size()][7];
                    String[] inventoryHistory = inventory.getHistory().toArray(new String[0]);

                    for (int i = 0; i < inventory.getItems().size(); i++) {
                        InventoryItem item = inventory.getItems().get(i);
                        inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode(),
                                item.getBuyPrice()+"", item.getSellPrice()+"",
                                Integer.toString(item.getCaseQuantity()), item.getDepartment()};
                    }

                    return removeItemPresenter.prepareSuccessView(removeItemResponseModel, inventoryTable, inventoryHistory);

                }
            }

        throw new RuntimeException("Failed to remove item from inventory; Item not found error.");

    }
}
