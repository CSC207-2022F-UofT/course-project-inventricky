package receive_order_use_case;

import Screens.InventoryDatabase;
import Screens.OrderHistoryViewModel;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import update_item_quantity_use_case.*;
import useCases.UpdateItemQuantity;

import javax.swing.*;
import java.time.LocalDate;
import java.util.HashMap;

public class ReceivingInteractor implements ReceivingInputBoundary {
    final ReceivingDsGateway receivingDsGateway;
    final ReceivingPresenter receivingPresenter;

    private final UpdateItemQtyPresenter updateQtyPresenter;
    private final Inventory inventory;
    private final HashMap controllers;

    private Order receivedOrder = null;

    private ReceivingResponseModel receivingResponseModel;



    LocalDate dateToday = LocalDate.now();

    public ReceivingInteractor(ReceivingDsGateway receivingDsGateway, ReceivingPresenter receivingPresenter,
                               Inventory inventory, HashMap controllers, UpdateItemQtyPresenter presenter) {
        this.receivingDsGateway = receivingDsGateway;
        this.receivingPresenter = receivingPresenter;
        this.inventory = inventory;
        this.controllers = controllers;
        this.updateQtyPresenter = presenter;
    }


    @Override
    public OrderHistoryViewModel receiveOrder(ReceivingRequestModel requestModel, JFrame parent) {

        for(Order order: inventory.getOrders()){
            if(order.getName().equals(requestModel.getName())){
                order.changeToReceived(requestModel.getDateReceived());
                receivedOrder = order;

                receivingResponseModel = new ReceivingResponseModel(order.getName(),
                        order.getBarcode(), order.getDateBought(), order.getEstimatedDate(), order.getDateReceived(),
                        order.getSupplier(), order.getOrderCases());
            }
        }

        for (InventoryItem item: inventory.getItems()){
            if(item.getName().equals(requestModel.getName())){
                // found item in inventory, updateqty in inventory
                UpdateItemQtyDsGateway updateQtyGateway = new InventoryDatabase();
                UpdateItemQtyRequestModel inputData = new UpdateItemQtyRequestModel(item.getBarcode(), "bought",
                        (receivedOrder.getOrderCases() * item.getCaseQuantity()));
                UpdateItemQtyInputBoundary updateItemQtyInteractor = new UpdateItemQtyInteractor(updateQtyGateway,
                        updateQtyPresenter, inventory);
                updateItemQtyInteractor.updateQty(inputData);
            }
        }
        parent.dispose();

        String[][] orderTable = new String[inventory.getOrders().size()][7];

        for (int i = 0; i < inventory.getOrders().size(); i++) {
            Order order = inventory.getOrders().get(i);
            orderTable[i] = new String[] {order.getName(), order.getBarcode(), order.getDateBought(),
                    order.getEstimatedDate(), order.getDateReceived(), order.getSupplier(), Integer.toString(order.getOrderCases())};
        }
        return receivingPresenter.prepareSuccessView(receivingResponseModel, orderTable, controllers);
    }
}
