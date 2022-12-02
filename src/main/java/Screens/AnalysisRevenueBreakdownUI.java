package Screens;

import entities.*;

import javax.swing.*;
import java.util.ArrayList;

public class AnalysisRevenueBreakdownUI extends JFrame {
    /**
     * This UI calls the controller to do the revenue breakdown feature
     * @param controller this UI takes the AnalysisController as a parameter
     */
    public AnalysisRevenueBreakdownUI(AnalysisController controller){
        controller.makeRevenueArray();
    }

    public static void main(String[] args) {
        ArrayList<InventoryItem> stuff = new ArrayList<InventoryItem>();
        ArrayList<Order> stuff2 = new ArrayList<Order>();
        InventoryItem item1 = new InventoryItem("Apple", "11000", false, 5, 2, 5,
                25, "11", 25, 20);
        InventoryItem item2 = new InventoryItem("Banana", "11001",false, 13, 1, 3,
                25, "11", 35, 22);
        InventoryItem item3 = new InventoryItem("Orange", "11002", false, 50, 2, 6,
                25, "11", 80, 30);
        InventoryItem item4 = new InventoryItem("Kiwi", "11003",false, 20, 2, 4,
                25, "11", 25, 5);
        InventoryItem item5 = new InventoryItem("Mango", "11004",true, 10, 1, 5,
                25, "11", 25, 15);
        InventoryItem item6 = new InventoryItem("Strawberries", "11005",true, 15, 2, 4,
                25, "11", 50, 35);
        Order order1 = new Order("Pineapple", "11008", false, 35, 2.50, 3.50,
                3, "11", "2022-06-20", "2022-06-25",
                "Fruit and Co", 5);
        Order order2 = new Order("blueberries", "11008", false, 20, 1.25, 3,
                5, "11", "2022-06-20", "2022-06-25",
                "Fruit and Co", 3);
        stuff.add(item1);
        stuff.add(item2);
        stuff.add(item3);
        stuff.add(item4);
        stuff.add(item5);
        stuff.add(item6);
        stuff2.add(order1);
        stuff2.add(order2);
        Inventory fruits = new Inventory("fruits", stuff, stuff2);
        // new AnalysisRevenueBreakdownUI(fruits);
    }

}
