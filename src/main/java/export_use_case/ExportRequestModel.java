package export_use_case;

public class ExportRequestModel {
    private String inventoryName;
    String[][] inventorytable;

    public String[][] getInventorytable() {
        return inventorytable;
    }

    public void setInventorytable(String[][] inventorytable) {
        this.inventorytable = inventorytable;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public ExportRequestModel(String inventoryName, String[][] inventorytable) {
        this.inventoryName = inventoryName;
        this.inventorytable = inventorytable;
    }
}
