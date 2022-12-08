package receive_order_use_case;

import Screens.InventoryViewModel;
import Screens.OrderHistoryViewModel;

import javax.swing.*;

public interface ReceivingInputBoundary {
    OrderHistoryViewModel receiveOrder(ReceivingRequestModel requestModel, JFrame parent);
}
