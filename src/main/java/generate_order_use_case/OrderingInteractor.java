package generate_order_use_case;
import Screens.*;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import new_item_use_case.*;
import javax.swing.*;
import java.util.HashMap;

public class OrderingInteractor implements OrderingInputBoundary {
    private final OrderingPresenter orderingPresenter;
    private final NewItemPresenter newItemPresenter;
    private final Inventory inventory;
    private final HashMap controllers;

    /**
     * Construct use case interactor for ordering items.
     * @param orderPresenter    presenter for updating order history view model.
     * @param inventory         inventory for order to be added to.
     * @param controllers       hashmap of controllers.
     * @param newItemPresenter  presenter for adding a new item.
     */
    public OrderingInteractor(OrderingPresenter orderPresenter, Inventory inventory,
                              HashMap controllers, NewItemPresenter newItemPresenter){
        this.orderingPresenter = orderPresenter;
        this.inventory = inventory;
        this.controllers = controllers;
        this.newItemPresenter = newItemPresenter;
    }

    /**
     * Add order to inventory and update order history screen.
     * @param requestModel  order to be added to inventory.
     * @param parent    previous screen of order history.
     * @return      updated view model for the order history screen.
     */
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
        // item doesnt exist in inventory
        if(!ifFound) {
            NewItemRequestModel inputData = new NewItemRequestModel(requestModel.getName(), requestModel.getIsWeight(),
                    0, requestModel.getBuyPrice(), requestModel.getSellPrice(),
                    requestModel.getCaseQuantity(), requestModel.getDepartment());
            NewItemInputBoundary newItemInteractor = new NewItemInteractor(newItemPresenter, inventory);
            newItemInteractor.addItem(inputData, false);
            parent.dispose();
        }
            Order createdOrder = newOrder.registerOrderManual(requestModel.getName(), requestModel.getSupplier(), requestModel.getOrderCases(),
                    inventory);
            OrderingResponseModel orderingResponseModel = new OrderingResponseModel(createdOrder.getName(),
                    createdOrder.getBarcode(), createdOrder.getDateBought(), createdOrder.getEstimatedDate(),
                    createdOrder.getDateReceived(), createdOrder.getSupplier(), createdOrder.getOrderCases());

        // update UI with the updated table
        String[][] orderTable = new String[inventory.getOrders().size()][7];

        for (int i = 0; i < inventory.getOrders().size(); i++) {
            Order order = inventory.getOrders().get(i);
            orderTable[i] = new String[] {order.getName(), order.getBarcode(), order.getDateBought(),
                    order.getEstimatedDate(), order.getDateReceived(), order.getSupplier(), Integer.toString(order.getOrderCases())};
        }
        return orderingPresenter.prepareSuccessView(orderingResponseModel, orderTable, controllers);
    }

}
