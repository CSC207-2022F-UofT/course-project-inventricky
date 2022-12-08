package Screens;
import receive_order_use_case.ReceivingPresenter;
import receive_order_use_case.ReceivingResponseModel;
import java.util.HashMap;

public class ReceivingScreenUpdater implements ReceivingPresenter {

    /**
     * Update order history screen with received order.
     * @param order                 order to be received.
     * @param orderHistoryTable     2d array representing the order history.
     * @param controllers           hashmap of controllers.
     * @return                      order history view model containing order history table.
     */
    @Override
    public OrderHistoryViewModel prepareSuccessView(ReceivingResponseModel order, String[][] orderHistoryTable,
                                                    HashMap<String, Object> controllers) {
        OrderHistoryViewModel orderHistoryViewModel = new OrderHistoryViewModel(orderHistoryTable);
        new OrderHistoryUI(orderHistoryViewModel, (OrderingController) controllers.get("orderingController"),
                (ReceivingController) controllers.get("receivingController"));

        return orderHistoryViewModel;
    }
}

