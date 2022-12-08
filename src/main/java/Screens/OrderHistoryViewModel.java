package Screens;

public class OrderHistoryViewModel {

    String[][] orderList; //Array of string arrays containing Name, Quantity and Barcode of item

    public OrderHistoryViewModel(String[][] orderList) {
        this.orderList = orderList;
    }

    public String[][] getOrderList() {
        return orderList;
    }

    public void setOrderList(String[][] orderList) {
        this.orderList = orderList;
    }
}
