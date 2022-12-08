package update_item_quantity_use_case;

import java.util.ArrayList;

public class UpdateItemQtyResponseModel {

    String name;

    String barcode;

    ArrayList<String> itemHistory;


    /** Construct update item quantity response model.
     *
     * @param name          name of updated item.
     * @param barcode       barcode of updated item.
     * @param itemHistory   item history of updated item.
     */
    public UpdateItemQtyResponseModel(String name, String barcode, ArrayList<String> itemHistory) {
        this.name = name;
        this.barcode = barcode;
        this.itemHistory = itemHistory;
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

    public ArrayList<String> getItemHistory() {
        return itemHistory;
    }

}

