package Screens;

import generate_order_use_case.OrderingInputBoundary;
import generate_order_use_case.OrderingRequestModel;
import receive_order_use_case.ReceivingInputBoundary;
import receive_order_use_case.ReceivingRequestModel;

import javax.swing.*;

public class ReceivingController {
    final ReceivingInputBoundary userInput;

    public ReceivingController(ReceivingInputBoundary receivingGateway){
        this.userInput = receivingGateway;
    }

    OrderHistoryViewModel updateShipmentStatus(String name, int casesBought, String dateReceived, JFrame parent){
        ReceivingRequestModel requestModel = new ReceivingRequestModel(name, casesBought, dateReceived);

        return userInput.receiveOrder(requestModel, parent);
    }
}
