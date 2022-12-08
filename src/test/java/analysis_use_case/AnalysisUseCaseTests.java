package analysis_use_case;

import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalysisUseCaseTests {

    private static Inventory inv;

    @BeforeAll
    static void createTestData() {
        ArrayList<InventoryItem> stuff = new ArrayList<>();
        ArrayList<Order> stuff2 = new ArrayList<>();
        InventoryItem item1 = new InventoryItem("Apple", "11000", false, 5, 2, 5,
                25, "11", 25, 20);
        InventoryItem item2 = new InventoryItem("Banana", "11001",false, 13, 1, 3,
                25, "11", 35, 22);
        InventoryItem item3 = new InventoryItem("Orange", "11002", false, 50, 2, 6,
                25, "11", 80, 30);
        Order order1 = new Order("Pineapple", "11008", false, 35, 2.50, 3.50,
                3, "11", "2022-06-20", "2022-06-25",
                "Fruit and Co", 5);
        Order order2 = new Order("blueberries", "11008", false, 20, 1.25, 3,
                5, "11", "2022-06-20", "2022-06-25",
                "Fruit and Co", 3);
        stuff.add(item1);
        stuff.add(item2);
        stuff.add(item3);
        stuff2.add(order1);
        stuff2.add(order2);
        inv = new Inventory("fruits", stuff, stuff2);
    }

    @Test
    public void revenueBreakdown(){
        NewAnalysisPresenter presenter = list -> {
            assertEquals("Revenue:", list[0]);
            assertEquals("Apple: quantity sold: 20.0 price per product: 5.0 total revenue for product: 100.0", list[1]);
            assertEquals("Banana: quantity sold: 22.0 price per product: 3.0 total revenue for product: 66.0", list[2]);
            assertEquals("Orange: quantity sold: 30.0 price per product: 6.0 total revenue for product: 180.0", list[3]);
            assertEquals("Total Revenue: 346.0", list[4]);
        };
        presenter.showArray(new Analysis(inv).totalRevenueBreakdown().toArray(new String[0]));

    }

    @Test
    public void costsBreakdown(){
        NewAnalysisPresenter presenter = list -> {
            assertEquals("Costs:", list[0]);
            assertEquals("Apple: quantity bought: 25.0 price per product: 2.0 total cost for product: 50.0", list[1]);
            assertEquals("Banana: quantity bought: 35.0 price per product: 1.0 total cost for product: 35.0", list[2]);
            assertEquals("Orange: quantity bought: 80.0 price per product: 2.0 total cost for product: 160.0", list[3]);
            assertEquals("Current Orders:", list[4]);
            assertEquals("Pineapple: quantity per case: 3 number of cases: 5 price per item: 2.5 total cost for product: 37.5", list[5]);
            assertEquals("blueberries: quantity per case: 5 number of cases: 3 price per item: 1.25 total cost for product: 18.75", list[6]);
            assertEquals("Total Costs: 301.25", list[7]);
        };
        presenter.showArray(new Analysis(inv).totalCostsBreakdown().toArray(new String[0]));
    }

    @Test
    public void calculateProfit(){
        NewAnalysisPresenter presenter = list -> {
            assertEquals("Revenue: 346.0", list[0]);
            assertEquals("Costs: 301.25", list[1]);
            assertEquals("Profit: 44.75", list[2]);
        };
        Analysis analysis = new Analysis(inv);
        String revenue = "Revenue: " + analysis.getTotalRevenue();
        String costs = "Costs: " + analysis.getTotalCosts();
        var profit_loss = "";
        if (analysis.loss()){
            profit_loss = "Loss: " + (analysis.calculateProfit() * -1);
        } else{
            profit_loss = "Profit: " + analysis.calculateProfit();
        }
        String[] info = {revenue, costs, profit_loss};
        presenter.showArray(info);
    }
}
