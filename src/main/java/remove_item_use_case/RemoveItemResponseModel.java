package remove_item_use_case;

public class RemoveItemResponseModel {

    String name;

    String barcode;

    /** Construct remove item response model.
     *
     * @param name      name of removed item.
     * @param barcode   barcode of removed item.
     */
    public RemoveItemResponseModel(String name, String barcode) {
        this.name = name;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}

