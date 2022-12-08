package receive_order_use_case;
import Screens.OrderHistoryViewModel;
import javax.swing.*;

public interface ReceivingInputBoundary {
    /**
     * Input boundary for receiving use case.
     * @param requestModel  order to be received.
     * @param parent        previous screen of order history.
     * @param testing       true if method is used for testing.
     * @return              order history view model for updating order history screen.
     */
    OrderHistoryViewModel receiveOrder(ReceivingRequestModel requestModel, JFrame parent, boolean testing);
}
