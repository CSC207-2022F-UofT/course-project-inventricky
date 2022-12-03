package update_item_quantity_use_case;

import java.util.ArrayList;

public class UpdateItemQtyResponseModel {

    String name;

    String barcode;

    ArrayList<String> itemHistory;



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

    public void setItemHistory(ArrayList<String> itemHistory) {
        this.itemHistory = itemHistory;
    }
}
