package generate_order_use_case;

import Screens.InventoryViewModel;
import Screens.OrderHistoryViewModel;
import Screens.OrderingController;

import java.util.HashMap;

public interface OrderingPresenter {
    OrderHistoryViewModel prepareSuccessView(OrderingResponseModel order, String[][] orderHistoryTable,
                                             HashMap controllers);
}


