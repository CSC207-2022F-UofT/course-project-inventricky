package Screens;

import generate_order_use_case.OrderingResponseModel;
import receive_order_use_case.ReceivingPresenter;
import receive_order_use_case.ReceivingResponseModel;

import java.util.HashMap;

public class ReceivingScreenUpdater implements ReceivingPresenter {

    @Override
    public OrderHistoryViewModel prepareSuccessView(ReceivingResponseModel order, String[][] orderHistoryTable,
                                                    HashMap controllers) {
        OrderHistoryViewModel orderHistoryViewModel = new OrderHistoryViewModel(orderHistoryTable);
        new OrderHistoryUI(orderHistoryViewModel, (OrderingController) controllers.get("orderingController"),
                (ReceivingController) controllers.get("receivingController"));

        return orderHistoryViewModel;
    }
}

