package Screens;

//Interface adapter
//data structure the presenter passes to the view

public class InventoryViewModel {

    String[][] itemList; //Array of string arrays containing Name, Quantity and Barcode of item

    public InventoryViewModel(String[][] itemList) {
        this.itemList = itemList;
    }

    public String[][] getItemList() {
        return itemList;
    }

}
