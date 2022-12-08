package Screens;
import receive_order_use_case.ReceivingInputBoundary;
import receive_order_use_case.ReceivingRequestModel;
import javax.swing.*;

public class ReceivingController {
    final ReceivingInputBoundary userInput;

    /**
     * Construct a new receiving controller.
     * @param receivingGateway      use case interactor for receiving item.
     */
    public ReceivingController(ReceivingInputBoundary receivingGateway){
        this.userInput = receivingGateway;
    }

    /**
     * Update shipment status of order.
     * @param name          name of ordered item to be received.
     * @param dateReceived  date received of ordered item.
     * @param parent        previous order history screen.
     * @return              order history view model containing table representation of order history.
     */

    OrderHistoryViewModel updateShipmentStatus(String name, String dateReceived, JFrame parent){
        ReceivingRequestModel requestModel = new ReceivingRequestModel(name, dateReceived);

        return userInput.receiveOrder(requestModel, parent, false);
    }
}
