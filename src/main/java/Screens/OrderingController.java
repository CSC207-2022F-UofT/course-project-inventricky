package Screens;

import generate_order_use_case.OrderingInputBoundary;
import generate_order_use_case.OrderingRequestModel;

import javax.swing.*;

public class OrderingController {

    final OrderingInputBoundary userInput;

    public OrderingController(OrderingInputBoundary orderGateway){
        this.userInput = orderGateway;
    }

    OrderHistoryViewModel addOrder(String name, boolean isWeight, double buyPrice,
                                   double sellPrice, int caseQuantity, String department,
                                   String supplier, int cases, JFrame parent) {
        OrderingRequestModel requestModel = new OrderingRequestModel(name, isWeight, buyPrice, sellPrice, caseQuantity,
                department, supplier, cases);

        return userInput.addOrder(requestModel, parent);
    }
}
