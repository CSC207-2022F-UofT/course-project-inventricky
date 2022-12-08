package Screens;
import generate_order_use_case.OrderingPresenter;
import generate_order_use_case.OrderingResponseModel;
import java.util.HashMap;

public class OrderingScreenUpdater implements OrderingPresenter {

    /**
     * Update order history screen with new order.
     * @param order                 order to be added into inventory.
     * @param orderHistoryTable     2d array representing the order history.
     * @param controllers           hashmap of controllers.
     * @return                      order history view model containing order history table.
     */
    @Override
    public OrderHistoryViewModel prepareSuccessView(OrderingResponseModel order, String[][] orderHistoryTable,
                                                    HashMap<String, Object> controllers){
        OrderHistoryViewModel orderHistoryViewModel = new OrderHistoryViewModel(orderHistoryTable);
        new OrderHistoryUI(orderHistoryViewModel, (OrderingController) controllers.get("orderingController"),
                (ReceivingController) controllers.get("receivingController"));

        return orderHistoryViewModel;
    }



}
