package generate_order_use_case;
import Screens.OrderHistoryViewModel;
import javax.swing.*;

public interface OrderingInputBoundary {
    /**
     * Input boundary for ordering use case.
     * @param requestModel  order to be added to inventory.
     * @param parent        previous screen of order history.
     * @return              order history view model for updating order history screen.
     */
    OrderHistoryViewModel addOrder(OrderingRequestModel requestModel, JFrame parent);
}
