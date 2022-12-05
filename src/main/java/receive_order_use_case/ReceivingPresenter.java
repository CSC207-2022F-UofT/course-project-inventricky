package receive_order_use_case;

import Screens.OrderHistoryViewModel;
import generate_order_use_case.OrderingResponseModel;

import java.util.HashMap;

public interface ReceivingPresenter {

    OrderHistoryViewModel prepareSuccessView(ReceivingResponseModel order, String[][] orderHistoryTable,
                                             HashMap controllers);

}
