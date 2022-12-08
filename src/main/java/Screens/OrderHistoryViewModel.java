package Screens;

public class OrderHistoryViewModel {
    String[][] orderList;

    /**
     * Construct a new order history view model.
     * @param orderList     2d string array representation of order history.
     */
    public OrderHistoryViewModel(String[][] orderList) {
        this.orderList = orderList;
    }
    public String[][] getOrderList() {
        return orderList;
    }
}
