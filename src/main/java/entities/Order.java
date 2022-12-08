package entities;

public class Order extends Item{
    private final String dateBought;
    private final String estimatedDate;
    private String dateReceived;
    private final String supplier;
    private final int cases;

    /**
     * Construct a new Order object.
     * @param name  name of ordered item.
     * @param barcode   barcode of ordered item.
     * @param isWeight  true if item is measured by weight.
     * @param quantity  quantity of ordered item.
     * @param buyPrice  buy price of ordered item.
     * @param sellPrice sell price of ordered item.
     * @param caseQuantity  quantity of ordered item in one case.
     * @param department    department of ordered item.
     * @param date_bought   date bought of order.
     * @param estimated_date    estimated date of order.
     * @param supplier  supplier of order.
     * @param cases     number of cases bought for order.
     */
    public Order(String name, String barcode, boolean isWeight, double quantity, double buyPrice,
                 double sellPrice, int caseQuantity, String department, String date_bought, String estimated_date,
                 String supplier, int cases){
        super(name, barcode, isWeight, quantity, buyPrice, sellPrice, caseQuantity, department);
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
}


