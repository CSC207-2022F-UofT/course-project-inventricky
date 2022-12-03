package generate_order_use_case;

public class OrderingResponseModel {
    private final String name;
    private final String barcode;
    private final String dateBought;
    private final String estimatedDate;
    private final String dateReceived;
    private final String supplier;
    private final int casesBought;

    public OrderingResponseModel(String name, String barcode, String dateBought, String estimatedDate,
                                 String dateReceived, String supplier, int casesBought){
        this.name = name;
        this.barcode = barcode;
        this.dateBought = dateBought;
        this.estimatedDate = estimatedDate;
        this.dateReceived = dateReceived;
        this.supplier = supplier;
        this.casesBought = casesBought;

    }

    public String getName(){
        return this.name;
    }

    public String getBarcode(){
        return this.barcode;
    }

    public String getDateBought(){
        return this.dateBought;
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
    public int getCasesBought(){
        return this.casesBought;
    }
}
