package delete_inventory_use_case;

public class DeleteInventoryRequestModel {
    String invName;

    /** A request model containing the name of the inventory.
     * @param name The name of the inventory of the files to be deleted.
     */
    public DeleteInventoryRequestModel(String name) {
        this.invName = name;
    }
}