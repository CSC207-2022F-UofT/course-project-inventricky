package generate_order_use_case;
public class OrderingRequestModel {
    private final String name;
    private final boolean isWeight;
    private final double buyPrice;
    private final double sellPrice;
    private final int caseQuantity;
    private final String department;
    private final String supplier;
    private final int cases;

    /**
     * Construct new order request model object.
     * @param name              name of order to be added.
     * @param isWeight          true if order is measured by weight.
     * @param buyPrice          buy price of the ordered item.
     * @param sellPrice         sell price of the ordered item.
     * @param caseQuantity      quantity per case of ordered item.
     * @param department        department of ordered item.
     * @param supplier          supplier of order.
     * @param cases             amount of cases bought.
     */
    public OrderingRequestModel(String name, boolean isWeight, double buyPrice,
                 double sellPrice, int caseQuantity, String department,
                 String supplier, int cases){
        this.name = name;
        this.isWeight = isWeight;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.caseQuantity = caseQuantity;
        this.department = department;
        this.supplier = supplier;
        this.cases = cases;
    }

    public String getName(){
        return this.name;
    }

    public boolean getIsWeight(){
        return this.isWeight;
    }

    public double getBuyPrice(){
        return this.buyPrice;
    }

    public double getSellPrice(){
        return this.sellPrice;
    }

    public int getCaseQuantity(){
        return this.caseQuantity;
    }

    public String getDepartment(){
        return this.department;
    }

    public String getSupplier(){
        return this.supplier;
    }

    public int getOrderCases(){
        return this.cases;
    }

}
