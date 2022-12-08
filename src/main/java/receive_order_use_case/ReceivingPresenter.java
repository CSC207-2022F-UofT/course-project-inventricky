package receive_order_use_case;
import Screens.OrderHistoryViewModel;
import java.util.HashMap;

public interface ReceivingPresenter {

    /**
     * Presenters must implement this method.
     * @param order                 order to be received.
     * @param orderHistoryTable     2d array representing the order history.
     * @param controllers           hashmap of controllers.
     * @return                      order history view model for the order history view to update screen.
     */
    OrderHistoryViewModel prepareSuccessView(ReceivingResponseModel order, String[][] orderHistoryTable,
                                             HashMap<String, Object> controllers);

}
