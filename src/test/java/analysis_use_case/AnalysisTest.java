package analysis_use_case;


import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AnalysisTest {
    private Inventory fruits;

    public void makeInventory(){
        ArrayList<InventoryItem> stuff = new ArrayList<>();
        ArrayList<Order> stuff2 = new ArrayList<>();
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
        this.fruits = new Inventory("fruits", stuff, stuff2);
    }

    @Test
    public void testCalculateProfit(){
        makeInventory();
        Analysis AnalysisTest = new Analysis(this.fruits);
        double RealProfit = 104.75;
        double CalculatedProfit = AnalysisTest.calculateProfit();
        assert (RealProfit == CalculatedProfit);
    }

    @Test
    public void testGetTotalRevenue(){
        makeInventory();
        Analysis AnalysisTest = new Analysis(this.fruits);
        double RealRevenue = 581;
        double CalculatedRevenue = AnalysisTest.getTotalRevenue();
        assert (RealRevenue == CalculatedRevenue);
    }

    @Test
    public void testGetTotalCosts() {
        makeInventory();
        Analysis AnalysisTest = new Analysis(this.fruits);
        double RealCosts = 476.25;
        double CalculatedCosts = AnalysisTest.getTotalCosts();
        assert (RealCosts == CalculatedCosts);
    }

    @Test
    public void testLoss(){
        makeInventory();
        Analysis AnalysisTest = new Analysis(this.fruits);
        assert (!AnalysisTest.loss());
    }

}
