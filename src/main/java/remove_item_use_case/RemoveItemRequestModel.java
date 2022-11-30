package remove_item_use_case;

public class RemoveItemRequestModel {

    private String barcode;

    public RemoveItemRequestModel(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
