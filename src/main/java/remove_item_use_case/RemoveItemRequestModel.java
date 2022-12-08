package remove_item_use_case;

public class RemoveItemRequestModel {


    private String barcode;

    /** Construct remove item request model object.
     *
     * @param barcode   barcode of item to be removed.
     */
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

