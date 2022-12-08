package receive_order_use_case;

public class ReceivingRequestModel {
    private final String dateReceived;
    private final String name;

    /**
     * Construct new receiving request model object.
     * @param name          name of order to be received.
     * @param dateReceived  date received of order.
     */
    public ReceivingRequestModel(String name, String dateReceived){
        this.dateReceived = dateReceived;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public String getDateReceived(){
        return this.dateReceived;
    }
}
