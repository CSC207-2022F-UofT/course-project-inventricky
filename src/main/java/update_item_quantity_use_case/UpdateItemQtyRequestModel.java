package update_item_quantity_use_case;

public class UpdateItemQtyRequestModel {

    private String barcode;

    private final String updateReason;


    private final double qtyInput;

    /** Construct update item quantity request model object.
     *
     *
     * @param barcode           selected item to be updated.
     * @param updateReason      reason for updating item.
     * @param qtyInput          quantity input for updating item.
     */
    public UpdateItemQtyRequestModel(String barcode, String updateReason, double qtyInput) {
        this.barcode = barcode;
        this.updateReason = updateReason;
        this.qtyInput = qtyInput;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getUpdateReason() {
        return updateReason;
    }

    public double getQtyInput() {
        return qtyInput;
    }

}
