package Screens;

//Interface adapter
//data structure the presenter passes to the view

public class InventoryViewModel {

    String[][] itemList; //Array of string arrays containing Name, Quantity and Barcode of item

    String[] inventoryHistory;

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

    public void setItemList(String[][] itemList) {
        this.itemList = itemList;
    }
}
