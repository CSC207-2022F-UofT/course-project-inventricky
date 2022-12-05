package useCases;

import Screens.InventoryDatabase;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import update_item_quantity_use_case.UpdateItemQtyDsGateway;
import update_item_quantity_use_case.UpdateItemQtyInteractor;
import update_item_quantity_use_case.UpdateItemQtyPresenter;
import useCases.UpdateItemQuantity;

public class OrderReceiver {
    /**
     * Receive the inbound order. Update the quantity of the ordered item within inventory.
     * Change the shipping status of the order to "Received".
     *
     * @param order     The order being received.
     * @param inventory The inventory the order is being received to.
     * @param date      The date the order was received.
     */

    public Order receiveOrder(Order order, Inventory inventory, String date) {
//        UpdateItemQtyDsGateway database = new InventoryDatabase();
//        UpdateItemQtyPresenter updateQty = new UpdateItemQtyInteractor(database);

        for (InventoryItem item : inventory.getItems()) {
            if (item.getBarcode().equals(order.getBarcode())) {

                UpdateItemQuantity.updateQty(inventory, order.getBarcode(),
                        (item.getQuantity() + (order.getCaseQuantity() * order.getOrderCases())), "bought");
                order.changeToReceived(date);
                return order;
            }

        }
        return null;
    }
}
