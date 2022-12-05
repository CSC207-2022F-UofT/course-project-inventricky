package receive_order_use_case;

public class ReceivingRequestModel {

    private String dateReceived;
    private final String name;

    private final int casesBought;

    public ReceivingRequestModel(String name, int casesBought, String dateReceived){
        this.dateReceived = dateReceived;
        this.name = name;
        this.casesBought = casesBought;
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

    public String getName(){
        return this.name;
    }

    public String getDateReceived(){
        return this.dateReceived;
    }
}
