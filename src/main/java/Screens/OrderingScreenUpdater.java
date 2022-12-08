package Screens;

import generate_order_use_case.OrderingPresenter;
import generate_order_use_case.OrderingResponseModel;

import java.util.HashMap;

public class OrderingScreenUpdater implements OrderingPresenter {

    @Override
    public OrderHistoryViewModel prepareSuccessView(OrderingResponseModel order, String[][] orderHistoryTable,
                                                    HashMap controllers){
        OrderHistoryViewModel orderHistoryViewModel = new OrderHistoryViewModel(orderHistoryTable);
        new OrderHistoryUI(orderHistoryViewModel, (OrderingController) controllers.get("orderingController"),
                (ReceivingController) controllers.get("receivingController"));

        return orderHistoryViewModel;
    }



}
