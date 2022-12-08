package generate_order_use_case;
import java.time.LocalDate;
public class OrderingRequestModel {
    // use case layer
    private final String name;

    private final boolean isWeight;

    private final double buyPrice;

    private final double sellPrice;

    private final int caseQuantity;

    private final String department;
    private final String supplier;
    private final int cases;

    LocalDate dateToday = LocalDate.now();
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
    public String getDateBought(){
        return dateToday.toString();
    }

    public String getEstimatedDate(){

        return dateToday.plusDays(5).toString();
    }

    public String getDateReceived(){
        return "";
    }

    public String getSupplier(){
        return this.supplier;
    }

    public int getOrderCases(){
        return this.cases;
    }


}
