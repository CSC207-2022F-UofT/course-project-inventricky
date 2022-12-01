package update_item_quantity_use_case;

import Screens.InventoryViewModel;
import entities.Inventory;
import entities.InventoryItem;
import remove_item_use_case.*;


public class UpdateItemQtyInteractor implements UpdateItemQtyInputBoundary {

    final UpdateItemQtyDsGateway updateItemQtyDsGateway;        //interactor needs an inventory, talks to database
    final UpdateItemQtyPresenter updateItemQtyPresenter;    //presenter

    private Inventory inventory;

    //pass in data access class, presenter
    public UpdateItemQtyInteractor(UpdateItemQtyDsGateway updateItemQtyDsGateway, UpdateItemQtyPresenter updateItemQtyDsPresenter, Inventory inventory) {
        this.updateItemQtyDsGateway = updateItemQtyDsGateway;
        this.updateItemQtyPresenter = updateItemQtyDsPresenter;
        this.inventory = inventory;
    }

    @Override
    public InventoryViewModel create(UpdateItemQtyRequestModel requestModel) throws RuntimeException {

        //Search for item in Inventory
        //TODO case where item is not in inventory


        for (InventoryItem candidate : inventory.getItems()) {
            if (candidate.getBarcode().equals(requestModel.getBarcode())) {
            updateQty(candidate, requestModel.getNewQuantity(), requestModel.getUpdateReason());

                UpdateItemQtyResponseModel updateItemQtyResponseModel = new UpdateItemQtyResponseModel(candidate.getName(), candidate.getBarcode());

                String[][] inventoryTable = new String[inventory.getItems().size()][7];

                for (int i = 0; i < inventory.getItems().size(); i++) {
                    InventoryItem item = inventory.getItems().get(i);
                    inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode(),
                            item.getBuyPrice() + "", item.getSellPrice() + "",
                            Integer.toString(item.getCaseQuantity()), item.getDepartment()};
                }

                return updateItemQtyPresenter.prepareSuccessView(updateItemQtyResponseModel, inventoryTable);

            }
        }

        RuntimeException RuntimeException = null;
        throw RuntimeException; //TODO exception

    }

    public static void updateQty(InventoryItem item, double newQuantity, String updateReason) {


        double diff = newQuantity - item.getQuantity(); // difference between new quantity and old quantity
        diff = diff * 100.0;
        double roundedDiff = Math.round(diff) / 100.0;

        if (updateReason.equals("bought")) {
            item.setQuantityBought(item.getQuantityBought() + roundedDiff);
            item.getItemHistory().add("b" + roundedDiff);
        } else if (updateReason.equals("sold")) {
            item.setQuantitySold(item.getQuantitySold() - roundedDiff);
            item.getItemHistory().add("s" + -roundedDiff);
        } else {
            item.getItemHistory().add("e" + roundedDiff);
        }

        item.setQuantity(newQuantity);
    }
}

