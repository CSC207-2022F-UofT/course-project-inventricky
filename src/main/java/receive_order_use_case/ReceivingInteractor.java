package receive_order_use_case;
import Screens.OrderHistoryViewModel;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import update_item_quantity_use_case.*;
import javax.swing.*;
import java.util.HashMap;

public class ReceivingInteractor implements ReceivingInputBoundary {
    final ReceivingPresenter receivingPresenter;
    private final UpdateItemQtyPresenter updateQtyPresenter;
    private final Inventory inventory;
    private final HashMap<String, Object> controllers;
    private Order receivedOrder = null;
    private ReceivingResponseModel receivingResponseModel;

    /**
     * Construct use case interactor for receiving items.
     * @param receivingPresenter    presenter for updating order history view model.
     * @param inventory             inventory for order to be received in.
     * @param controllers           hashmap of controllers.
     * @param presenter             presenter for updating item quantity.
     */

    public ReceivingInteractor(ReceivingPresenter receivingPresenter,
                               Inventory inventory, HashMap<String, Object> controllers, UpdateItemQtyPresenter presenter) {
        this.receivingPresenter = receivingPresenter;
        this.inventory = inventory;
        this.controllers = controllers;
        this.updateQtyPresenter = presenter;
    }

    /**
     * Receive order and update order history screen.
     * @param requestModel  order to be received.
     * @param parent        previous screen of order history.
     * @param testing       true if method is being called for tests.
     * @return              updated view model for the order history screen.
     */

    @Override
    public OrderHistoryViewModel receiveOrder(ReceivingRequestModel requestModel, JFrame parent, boolean testing) {

        // find order to receive within inventory
        for(Order order: inventory.getOrders()){
            if(order.getName().equals(requestModel.getName())){
                order.changeToReceived(requestModel.getDateReceived());
                receivedOrder = order;

                receivingResponseModel = new ReceivingResponseModel(order.getName(),
                        order.getBarcode());
            }
        }
        //find item in inventory and update its quantity if it exists
        for (InventoryItem item: inventory.getItems()){
            if(item.getName().equals(requestModel.getName())){
                // found item in inventory, update quantity in inventory
                UpdateItemQtyRequestModel inputData = new UpdateItemQtyRequestModel(item.getBarcode(), "Bought",
                        (receivedOrder.getOrderCases() * item.getCaseQuantity()));
                UpdateItemQtyInputBoundary updateItemQtyInteractor = new UpdateItemQtyInteractor(updateQtyPresenter, inventory);
                updateItemQtyInteractor.updateQty(inputData);
            }
        }
        if(!testing) {
            parent.dispose();
        }

        // update UI with the updated table
        String[][] orderTable = new String[inventory.getOrders().size()][7];

        for (int i = 0; i < inventory.getOrders().size(); i++) {
            Order order = inventory.getOrders().get(i);
            orderTable[i] = new String[] {order.getName(), order.getBarcode(), order.getDateBought(),
                    order.getEstimatedDate(), order.getDateReceived(), order.getSupplier(), Integer.toString(order.getOrderCases())};
        }
        return receivingPresenter.prepareSuccessView(receivingResponseModel, orderTable, controllers);
    }
}
