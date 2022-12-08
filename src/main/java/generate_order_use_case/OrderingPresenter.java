package generate_order_use_case;
import Screens.OrderHistoryViewModel;
import java.util.HashMap;

public interface OrderingPresenter {
    /**
     * Presenters must implement this method.
     * @param order                 order to be added into inventory.
     * @param orderHistoryTable     2d array representing the order history.
     * @param controllers           hashmap of controllers.
     * @return                      order history view model for the order history view to update screen.
     */
    OrderHistoryViewModel prepareSuccessView(OrderingResponseModel order, String[][] orderHistoryTable,
                                             HashMap<String, Object> controllers);
}


