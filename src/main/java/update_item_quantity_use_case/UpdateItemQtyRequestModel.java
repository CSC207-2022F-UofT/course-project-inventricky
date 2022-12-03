package update_item_quantity_use_case;

public class UpdateItemQtyRequestModel {

    private String barcode;

    private String updateReason;


    private double qtyInput;

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

    public void setUpdateReason(String updateReason) {
        this.updateReason = updateReason;
    }

    public double getQtyInput() {
        return qtyInput;
    }

    public void setQtyInput(double newQuantity) {
        this.qtyInput = newQuantity;
    }
}
