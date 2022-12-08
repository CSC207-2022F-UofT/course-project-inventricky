package generate_order_use_case;

import Screens.InventoryViewModel;
import Screens.OrderHistoryViewModel;

import javax.swing.*;

public interface OrderingInputBoundary {
    OrderHistoryViewModel addOrder(OrderingRequestModel requestModel, JFrame parent);
}
