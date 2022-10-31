package Ordering_Recieving;

public class Orders extends Items{
    private final double ordering_price;
    private final String date_bought;
    private final String estimated_date;
    private String date_recieved;
    private final String supplier;
    private final int cases;

//    public Orders(){
//
//    }

    public Orders(double orderprice, String datebought, String estimateddate, String datereceived, String supplier, int quantity){
        this.ordering_price = orderprice;
        this.date_bought = datebought;
        this.estimated_date = estimateddate;
        this.date_recieved = datereceived;
        this.supplier = supplier;
        this.cases = quantity;

    }

    public String getDateBought(){
        return this.date_bought;
    }

    public void changeToRecieved(){

    }

    public double getOrderPrice(){
        return this.ordering_price;
    }

    public String getEstimatedDate(){
        return this.estimated_date;
    }

    public String getDateRecieved(){
        return this.date_recieved;
    }

    public String getSupplier(){
        return this.supplier;
    }

    public int getOrderQuantity(){
        return this.cases;
    }

    public boolean checkShipmentStatus(){

    }
}
