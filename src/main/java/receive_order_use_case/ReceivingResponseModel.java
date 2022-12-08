package receive_order_use_case;

public class ReceivingResponseModel {
    private final String name;
    private final String barcode;

    /**
     * Construct receiving response model object.
     * @param name      name of order received.
     * @param barcode   barcode of order received.
     */
    public ReceivingResponseModel(String name, String barcode){
        this.name = name;
        this.barcode = barcode;
    }

    public String getName(){
        return this.name;
    }

    public String getBarcode(){
        return this.barcode;
    }
}

