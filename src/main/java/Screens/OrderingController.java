package Screens;
import generate_order_use_case.OrderingInputBoundary;
import generate_order_use_case.OrderingRequestModel;
import javax.swing.*;

public class OrderingController {

    final OrderingInputBoundary userInput;

    /**
     * Construct a new ordering controller.
     * @param orderGateway  use case interactor for ordering a new item.
     */

    public OrderingController(OrderingInputBoundary orderGateway){
        this.userInput = orderGateway;
    }

    /**
     * Add order to inventory.
     * @param name          name of ordered item.
     * @param isWeight      true if ordered item is measured by weight.
     * @param buyPrice      buy price of ordered item.
     * @param sellPrice     sell price of ordered item.
     * @param caseQuantity  amount of items per case.
     * @param department    department of ordered item.
     * @param supplier      supplier of order.
     * @param cases         number of cases bought for order.
     * @param parent        previous order history screen.
     * @return              order history view model containing table representation of order history.
     */
    OrderHistoryViewModel addOrder(String name, boolean isWeight, double buyPrice,
                                   double sellPrice, int caseQuantity, String department,
                                   String supplier, int cases, JFrame parent) {
        OrderingRequestModel requestModel = new OrderingRequestModel(name, isWeight, buyPrice, sellPrice, caseQuantity,
                department, supplier, cases);

        return userInput.addOrder(requestModel, parent);
    }
}
