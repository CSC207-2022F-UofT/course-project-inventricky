package receive_order_use_case;

public class ReceivingRequestModel {

    private String dateReceived;

    public ReceivingRequestModel(){
        this.dateReceived = "";
    }

    public String checkShipmentStatus(){
        if(this.dateReceived.isEmpty()){
            return "Inbound Order";
        }
        else{
            return "Received";
        }
    }

    public void changeToReceived(String date_received){
        if(this.dateReceived.isEmpty()){
            this.dateReceived = date_received;
        }
    }
}
