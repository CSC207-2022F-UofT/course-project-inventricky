package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import Screens.ItemHistoryViewModel;
import entities.Inventory;
import entities.InventoryItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class UpdateItemQtyInteractor implements UpdateItemQtyInputBoundary {
    final UpdateItemQtyPresenter updateItemQtyPresenter;    //presenter

    private Inventory inventory;

    //pass in data access class, presenter
    public UpdateItemQtyInteractor(UpdateItemQtyPresenter updateItemQtyDsPresenter, Inventory inventory) {
        this.updateItemQtyPresenter = updateItemQtyDsPresenter;
        this.inventory = inventory;
    }

    @Override
    public InventoryViewModel updateQty(UpdateItemQtyRequestModel requestModel) throws RuntimeException {

        //Search for item in Inventory
        //TODO case where item is not in inventory


        for (InventoryItem candidate : inventory.getItems()) {
            if (candidate.getBarcode().equals(requestModel.getBarcode())) {
            updateQtyHelper(inventory, candidate, requestModel.getQtyInput(), requestModel.getUpdateReason());

                UpdateItemQtyResponseModel updateItemQtyResponseModel = new UpdateItemQtyResponseModel(candidate.getName(), candidate.getBarcode(), candidate.getItemHistory());

                String[][] inventoryTable = new String[inventory.getItems().size()][7];

                for (int i = 0; i < inventory.getItems().size(); i++) {
                    InventoryItem item = inventory.getItems().get(i);
                    inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode(),
                            item.getBuyPrice() + "", item.getSellPrice() + "",
                            Integer.toString(item.getCaseQuantity()), item.getDepartment()};
                }

                return updateItemQtyPresenter.prepareQtySuccessView(updateItemQtyResponseModel, inventoryTable);

            }
        }

        RuntimeException RuntimeException = null;
        throw RuntimeException; //TODO exception

    }

    @Override
    public ItemHistoryViewModel GetItemHistory(UpdateItemQtyRequestModel requestModel) {

        for (InventoryItem candidate : inventory.getItems()) {
            if (candidate.getBarcode().equals(requestModel.getBarcode())) {

                UpdateItemQtyResponseModel updateItemQtyResponseModel = new UpdateItemQtyResponseModel(candidate.getName(), candidate.getBarcode(), candidate.getItemHistory());

                return updateItemQtyPresenter.prepareHistorySuccessView(updateItemQtyResponseModel);
            }
        }
        RuntimeException RuntimeException = null;
        throw RuntimeException; //TODO exception
    }

    public static void updateQtyHelper(Inventory inventory, InventoryItem item, double qtyInput, String updateReason) {


        qtyInput = qtyInput * 100.0;
        double roundedQtyInput = Math.round(qtyInput) / 100.0;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        if (updateReason.equals("Bought")) {
            item.setQuantityBought(item.getQuantityBought() + roundedQtyInput);
            item.getItemHistory().add(dtf.format(LocalDateTime.now()) + " Bought " + roundedQtyInput);
            item.setQuantity(item.getQuantity() + roundedQtyInput);
        } else if (updateReason.equals("Sold")) {
            item.setQuantitySold(item.getQuantitySold() + roundedQtyInput);
            item.getItemHistory().add(dtf.format(LocalDateTime.now()) + " Sold " + roundedQtyInput);
            item.setQuantity(item.getQuantity() - roundedQtyInput);
        } else {
            item.getItemHistory().add(dtf.format(LocalDateTime.now()) + " Error: Adjusted quantity to " + roundedQtyInput);
            item.setQuantity(roundedQtyInput);
        }
    }
}

