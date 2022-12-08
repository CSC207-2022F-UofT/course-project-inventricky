package generate_order_use_case;

public class OrderingResponseModel {
    private final String name;
    private final String barcode;

    /**
     * Construct an order response model object.
     * @param name      name of ordered item added to inventory.
     * @param barcode   barcode of ordered item added to inventory.
     */

    public OrderingResponseModel(String name, String barcode){
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
