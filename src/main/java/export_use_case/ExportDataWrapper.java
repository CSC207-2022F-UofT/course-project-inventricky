package export_use_case;

import java.util.ArrayList;

public class ExportDataWrapper {
    private String[][] inventorytable;
    private final ArrayList<Object> items_list;

    /**
     * Wraps the inventory data (its items) into a format that is later used by the exporter to write the data to files
     * @param inventorytable inventory items stored in a 2-D array of strings
     * @param items_list a list of all the inventory items in the form of an Array list of objects
     */
    public ExportDataWrapper(String[][] inventorytable, ArrayList<Object> items_list) {
        this.inventorytable = inventorytable;
        this.items_list = items_list;
    }

    /**
     *  Getter for items_list
     * @return items_list
     */
    public ArrayList<Object> getItems_list() {
        return items_list;
    }

    /**
     * Getter for inventorytable
     * @return inventorytable
     */
    public String[][] getInventorytable() {
        return inventorytable;
    }

    /**
     * Setter for inventorytable
     * @param inventorytable invenotry items stored in a 2D array of strings
     */
    public void setInventorytable(String[][] inventorytable) {
        this.inventorytable = inventorytable;
    }
}
