package update_item_quantity_use_case;

public class UpdateItemQtyRequestModel {

    private String barcode;

    private String updateReason;

    private double newQuantity;

    public UpdateItemQtyRequestModel(String barcode, String updateReason, double newQuantity) {
        this.barcode = barcode;
        this.updateReason = updateReason;
        this.newQuantity = newQuantity;
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

    public double getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(double newQuantity) {
        this.newQuantity = newQuantity;
    }
}
