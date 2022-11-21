/* package entities.Ordering_Recieving;
import entities.Item;
public class Order extends Item{
    private final int order_number;
    private final String date_bought;
    private final String estimated_date;
    private String date_received;
    private final String supplier;
    private final int cases;

    public Order(String name, int barcode, boolean isWeight, double quantity, int buyPrice,
                 int sellPrice, int caseQuantity, int department, int order_number, String datebought, String estimateddate,
                 String supplier, int cases){
        super(name, barcode, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
        this.order_number = order_number;
        this.date_bought = datebought;
        this.estimated_date = estimateddate;
        this.date_received = "";
        this.supplier = supplier;
        this.cases = cases;

    }

    public int getOrder_number(){return this.order_number;}
    public String getDateBought(){
        return this.date_bought;
    }

    public void changeToReceived(String datereceived){
        if(this.date_received.isEmpty()){
            this.date_received = datereceived;
        }
    }

    public double getOrderPrice(){
        return this.getBuyPrice();
    }

    public String getEstimatedDate(){
        return this.estimated_date;
    }

    public String getDateReceived(){
        return this.date_received;
    }

    public String getSupplier(){
        return this.supplier;
    }

    public int getOrderQuantity(){
        return this.cases;
    }

    public String checkShipmentStatus(){
        if(this.date_received.isEmpty()){
            return "Inbound Order";
        }
        else{
            return "Received";
        }
    }
}


*/