package Screens;

//Interface adapter
//data structure the presenter passes to the view

public class InventoryViewModel {

    String[][] itemList; //Array of string arrays containing Name, Quantity and Barcode of item

    String[] inventoryHistory;

    /** Construct a new invetory view model.
     *
     * @param itemList  2d string array representation of inventory.
     */
    public InventoryViewModel(String[][] itemList, String[] inventoryHistory) {
        this.itemList = itemList;
        this.inventoryHistory = inventoryHistory;
    }

    public String[][] getItemList() {
        return itemList;
    }

    public String[] getInventoryHistory() {
        return inventoryHistory;
    }
}
