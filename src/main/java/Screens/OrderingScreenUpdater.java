package Screens;

import Screens.InventoryViewModel;
import entities.Order;
import generate_order_use_case.OrderingPresenter;
import generate_order_use_case.OrderingResponseModel;

public class OrderingScreenUpdater implements OrderingPresenter {

    @Override
    public InventoryViewModel prepareSuccessView(OrderingResponseModel order, String[][] inventoryTable){
        InventoryViewModel inventoryViewModel = new InventoryViewModel(inventoryTable);

        new InventoryUI(inventoryViewModel);
        return inventoryViewModel;
    }

    @Override


}
