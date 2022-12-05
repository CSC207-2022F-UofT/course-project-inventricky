package generate_order_use_case;

import Screens.*;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import new_item_use_case.*;
import useCases.OrderGenerator;

import javax.swing.*;
import java.util.HashMap;

public class OrderingInteractor implements OrderingInputBoundary {

    private final OrderingDsGateway orderingDsGateway;
    private final OrderingPresenter orderingPresenter;
    private final NewItemPresenter newItemPresenter;
    private final Inventory inventory;
    private final HashMap controllers;


    public OrderingInteractor(OrderingDsGateway orderGateway, OrderingPresenter orderPresenter, Inventory inventory,
                              HashMap controllers, NewItemPresenter newItemPresenter){
        this.orderingDsGateway = orderGateway;
        this.orderingPresenter = orderPresenter;
        this.inventory = inventory;
        this.controllers = controllers;
        this.newItemPresenter = newItemPresenter;
    }

    @Override
    public OrderHistoryViewModel addOrder(OrderingRequestModel requestModel, JFrame parent){
        OrderGenerator newOrder = new OrderGenerator();
        boolean ifFound = false;
        for(InventoryItem item: inventory.getItems()) {
            if (item.getName().equals(requestModel.getName())) {
                ifFound = true;
                break;
            }
        }

        Order createdOrder = newOrder.registerOrderManual(requestModel.getName(), requestModel.getSupplier(), requestModel.getOrderCases(),
                inventory, requestModel.getIsWeight(), requestModel.getBuyPrice(), requestModel.getSellPrice(),
                requestModel.getCaseQuantity(), requestModel.getDepartment());
        OrderingResponseModel orderingResponseModel = new OrderingResponseModel(createdOrder.getName(),
                createdOrder.getBarcode(), createdOrder.getDateBought(), createdOrder.getEstimatedDate(),
                createdOrder.getDateReceived(), createdOrder.getSupplier(), createdOrder.getOrderCases());
        // item doesnt exist in inventory
        if(!ifFound){
            NewItemDsGateway newItemGateway = new InventoryDatabase();
            NewItemRequestModel inputData = new NewItemRequestModel(createdOrder.getName(), createdOrder.getIsWeight(),
                    createdOrder.getQuantity(), createdOrder.getBuyPrice(), createdOrder.getSellPrice(),
                    createdOrder.getCaseQuantity(), createdOrder.getDepartment());
            NewItemInputBoundary newItemInteractor = new NewItemInteractor(newItemGateway, newItemPresenter, inventory);
            newItemInteractor.addItem(inputData, false);
            parent.dispose();
        }

        String[][] orderTable = new String[inventory.getOrders().size()][7];

        for (int i = 0; i < inventory.getOrders().size(); i++) {
            Order order = inventory.getOrders().get(i);
            orderTable[i] = new String[] {order.getName(), order.getBarcode(), order.getDateBought(),
                    order.getEstimatedDate(), order.getDateReceived(), order.getSupplier(), Integer.toString(order.getOrderCases())};
        }
        return orderingPresenter.prepareSuccessView(orderingResponseModel, orderTable, controllers);
    }

}
