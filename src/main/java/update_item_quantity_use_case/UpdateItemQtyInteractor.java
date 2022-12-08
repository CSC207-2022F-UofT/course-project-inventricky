package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;
import entities.Inventory;
import entities.InventoryItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class UpdateItemQtyInteractor implements UpdateItemQtyInputBoundary {
    final UpdateItemQtyPresenter updateItemQtyPresenter;    //presenter

    private final Inventory inventory;

    //pass in data access class, presenter

    /** Construct use case interactor.
     *
     * @param updateItemQtyPresenter    presenter for updating inventory screen.
     * @param inventory                 current inventory.
     */
    public UpdateItemQtyInteractor(UpdateItemQtyPresenter updateItemQtyPresenter, Inventory inventory) {
        this.updateItemQtyPresenter = updateItemQtyPresenter;
        this.inventory = inventory;
    }

    /** Update selected item quantity.
     *
     * @param requestModel      request model containing selected item and what action to perform.
     * @return                  inventory view model containing inventory in table format.
     * @throws RuntimeException error with updating item quantity.
     */
    @Override
    public InventoryViewModel updateQty(UpdateItemQtyRequestModel requestModel) throws RuntimeException {

        //Search for item in Inventory
        //TODO case where item is not in inventory


        for (InventoryItem candidate : inventory.getItems()) {
            if (candidate.getBarcode().equals(requestModel.getBarcode())) {
            updateQtyHelper(inventory, candidate, requestModel.getQtyInput(), requestModel.getUpdateReason());

                UpdateItemQtyResponseModel updateItemQtyResponseModel = new UpdateItemQtyResponseModel(candidate.getName(), candidate.getBarcode(), candidate.getItemHistory());

                String[][] inventoryTable = new String[inventory.getItems().size()][7];
                String[] inventoryHistory = inventory.getHistory().toArray(new String[0]); //CHECK


                for (int i = 0; i < inventory.getItems().size(); i++) {
                    InventoryItem item = inventory.getItems().get(i);
                    inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode(),
                            item.getBuyPrice() + "", item.getSellPrice() + "",
                            Integer.toString(item.getCaseQuantity()), item.getDepartment()};
                }

                return updateItemQtyPresenter.prepareQtySuccessView(updateItemQtyResponseModel, inventoryTable, inventoryHistory);

            }
        }

        throw new RuntimeException("error with updating item quantity");

    }

    /** Get selected item history.
     *
     * @param requestModel      request model containing selected item.
     * @return                  item history view model containing item history.
     */
    @Override
    public ItemHistoryViewModel GetItemHistory(UpdateItemQtyRequestModel requestModel) {

        for (InventoryItem candidate : inventory.getItems()) {
            if (candidate.getBarcode().equals(requestModel.getBarcode())) {

                UpdateItemQtyResponseModel updateItemQtyResponseModel = new UpdateItemQtyResponseModel(candidate.getName(), candidate.getBarcode(), candidate.getItemHistory());

                return updateItemQtyPresenter.prepareHistorySuccessView(updateItemQtyResponseModel);
            }
        }
        throw new RuntimeException("error with getting item history");
    }

    /** Helper function for updating item quantity.
     *
     * @param inventory     current inventory.
     * @param item          selected item.
     * @param qtyInput      quantity input for selected item.
     * @param updateReason  update reason for selected item.
     */
    public static void updateQtyHelper(Inventory inventory, InventoryItem item, double qtyInput, String updateReason) {


        qtyInput = qtyInput * 100.0;
        double roundedQtyInput = Math.round(qtyInput) / 100.0;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        if (updateReason.equals("Bought")) {
            item.setQuantityBought(item.getQuantityBought() + roundedQtyInput);
            item.getItemHistory().add(dtf.format(LocalDateTime.now()) + " Bought " + roundedQtyInput);
            inventory.updateHistory(dtf.format(LocalDateTime.now()) + " Bought " + roundedQtyInput + " " + item.getName());
            item.setQuantity(item.getQuantity() + roundedQtyInput);
        } else if (updateReason.equals("Sold")) {
            item.setQuantitySold(item.getQuantitySold() + roundedQtyInput);
            item.getItemHistory().add(dtf.format(LocalDateTime.now()) + " Sold " + roundedQtyInput);
            inventory.updateHistory(dtf.format(LocalDateTime.now()) + " Sold " + roundedQtyInput + " " + item.getName());
            item.setQuantity(item.getQuantity() - roundedQtyInput);
        } else {
            item.getItemHistory().add(dtf.format(LocalDateTime.now()) + " Error: Adjusted quantity to " + roundedQtyInput);
            inventory.updateHistory(dtf.format(LocalDateTime.now()) + " Error: Adjusted quantity of " + item.getName() + " to " + roundedQtyInput);
            item.setQuantity(roundedQtyInput);
        }
    }
}

