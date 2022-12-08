package new_item_use_case;

//DONE
//Output data
public class NewItemResponseModel {

    String name; //name of item
    String barcode; //5 digit barcode

    /** Construct new item response model object
     *
     * @param name      name of item added to inventory.
     * @param barcode   barcode of item added to inventory.
     */
    public NewItemResponseModel(String name, String barcode) {
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

