package entities.Ordering_Recieving;
import entities.Item;

public class Order extends Item{
    private final int orderNumber;
    private final String dateBought;
    private final String estimatedDate;
    private String dateReceived;
    private final String supplier;
    private final int cases;

    public Order(String name, String barcode, boolean isWeight, double quantity, double buyPrice,
                 double sellPrice, int caseQuantity, String department, int order_number, String date_bought, String estimated_date,
                 String supplier, int cases){
        super(name, barcode, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.orderNumber = order_number;
        this.dateBought = date_bought;
        this.estimatedDate = estimated_date;
        this.dateReceived = "";
        this.supplier = supplier;
        this.cases = cases;

    }

    public String getDateBought(){
        return this.dateBought;
    }

    public void changeToReceived(String date_received){
        if(this.dateReceived.isEmpty()){
            this.dateReceived = date_received;
        }
    }

    public String getEstimatedDate(){
        return this.estimatedDate;
    }

    public String getDateReceived(){
        return this.dateReceived;
    }

    public String getSupplier(){
        return this.supplier;
    }

    public int getOrderCases(){
        return this.cases;
    }

    public int getOrderNumber(){
        return this.orderNumber;
    }

    public String checkShipmentStatus(){
        if(this.dateReceived.isEmpty()){
            return "Inbound Order";
        }
        else{
            return "Received";
        }
    }
}


