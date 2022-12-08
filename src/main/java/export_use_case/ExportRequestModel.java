package export_use_case;

public class ExportRequestModel {
    private final String inventoryName;
    String[][] inventorytable;

    /**
     * Getter for inventorytable
     * @return the contents of the inventory in the form of a table - inventorytable
     */
    public String[][] getInventorytable() {
        return inventorytable;
    }

    /**
     * Getter for inventoryName
     * @return the name of the inventory - inventoryName
     */
    public String getInventoryName() {
        return inventoryName;
    }

    /**
     * Constructor for the Export Requsest Model
     * @param inventoryName name of the inventory to be exported
     * @param inventorytable contents of the inventory in the form of a 2D array of strings
     */
    public ExportRequestModel(String inventoryName, String[][] inventorytable) {
        this.inventoryName = inventoryName;
        this.inventorytable = inventorytable;
    }
}
