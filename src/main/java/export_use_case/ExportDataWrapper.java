package export_use_case;

import java.util.ArrayList;

public class ExportDataWrapper {
    private String[][] inventorytable;
    private ArrayList<Object> items_list;
    private ArrayList<Object> orders_list;

    public ExportDataWrapper(String[][] inventorytable, ArrayList<Object> items_list, ArrayList<Object> orders_list) {
        this.inventorytable = inventorytable;
        this.items_list = items_list;
        this.orders_list = orders_list;
    }

    public ArrayList<Object> getItems_list() {
        return items_list;
    }

    public void setItems_list(ArrayList<Object> items_list) {
        this.items_list = items_list;
    }

    public ArrayList<Object> getOrders_list() {
        return orders_list;
    }

    public void setOrders_list(ArrayList<Object> orders_list) {
        this.orders_list = orders_list;
    }

    public String[][] getInventorytable() {
        return inventorytable;
    }

    public void setInventorytable(String[][] inventorytable) {
        this.inventorytable = inventorytable;
    }
}
