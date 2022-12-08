package analysis_use_case;

import entities.Inventory;
import entities.InventoryItem;
import entities.Order;

import java.util.ArrayList;

public class Analysis {
    private final Inventory inventory;

    /**
     * This the Constructor
     * @param inventory set the Inventory object to the inventory instance variable
     */
    public Analysis(Inventory inventory){
        this.inventory = inventory;
    }

    /**
     * Return a revenue breakdown
     * Each index should contain the item's name, quantity sold, selling price, total revenue for that product
     * Check if each item is quantified by weight, if so present the information accordingly
     * The last index should have the total revenue of the inventory
     */
    public ArrayList<String> totalRevenueBreakdown() {
        ArrayList<String> RevenueItems = new ArrayList<>();
        RevenueItems.add("Revenue:");
        for (InventoryItem item : inventory.getItems()) {
            String ItemBreakdown;
            if (item.getIsWeight()) {
                ItemBreakdown = item.getName() + ": kg sold: " + item.getQuantitySold() +
                        " price per kg: " + item.getSellPrice() + " total revenue for product: " +
                        item.getQuantitySold() * item.getSellPrice();

            } else{
                ItemBreakdown = item.getName() + ": quantity sold: " + item.getQuantitySold() +
                        " price per product: " + item.getSellPrice() + " total revenue for product: " +
                        item.getQuantitySold() * item.getSellPrice();
            }
            RevenueItems.add(ItemBreakdown);

        }
        RevenueItems.add("Total Revenue: " + this.getTotalRevenue());
        return RevenueItems;
    }

    /**
     * Returns a cost breakdown
     * Each index should contain the item's name, quantity bought, buy price, total cost for that product
     * Check if each item is quantified by weight, if so present the information accordingly
     * The last index should have the total cost of the inventory
     */
    public ArrayList<String> totalCostsBreakdown(){
        ArrayList<String> CostItems = new ArrayList<>();
        CostItems.add("Costs:");
        for (InventoryItem item : inventory.getItems()){
            String ItemBreakdown;
            if (item.getIsWeight()){
                ItemBreakdown = item.getName() + ": kg bought: " + item.getQuantityBought() +
                        " price per kg: " + item.getBuyPrice() + " total cost for product: " +
                        item.getQuantityBought() * item.getBuyPrice();
            } else{
                ItemBreakdown = item.getName() + ": quantity bought: " + item.getQuantityBought() +
                        " price per product: " + item.getBuyPrice() + " total cost for product: " +
                        item.getQuantityBought() * item.getBuyPrice();
            }
            CostItems.add(ItemBreakdown);
        }
        CostItems.add("Current Orders:");
        for (Order order : inventory.getOrders()){
            String OrderBreakdown;
            if (order.getIsWeight()){
                OrderBreakdown = order.getName() + ": kg per case: " + order.getCaseQuantity() +
                        " number of cases: " + order.getOrderCases() + " price per kg: " + order.getBuyPrice() +
                        " total cost for product: " + order.getCaseQuantity() * order.getOrderCases()
                        * order.getBuyPrice();
            } else{
                OrderBreakdown = order.getName() + ": quantity per case: " + order.getCaseQuantity() +
                        " number of cases: " + order.getOrderCases() + " price per item: " + order.getBuyPrice() +
                        " total cost for product: " + order.getCaseQuantity() * order.getOrderCases()
                        * order.getBuyPrice();
            }
            CostItems.add(OrderBreakdown);
        }
        CostItems.add("Total Costs: " + this.getTotalCosts());
        return CostItems;
    }

    /**
     * This method Calculates the total cost of the inventory
     * @return the total cost of the inventory
     */
    public double getTotalCosts(){
        double TotalCosts = 0;
        for (InventoryItem item : inventory.getItems()){
            TotalCosts = TotalCosts + (item.getQuantityBought() * item.getBuyPrice());
        }
        for (Order order: inventory.getOrders()){
            TotalCosts = TotalCosts + ((order.getCaseQuantity() * order.getOrderCases()) * order.getBuyPrice());
        }
        return TotalCosts;
    }

    /**
     * This method Calculates the total revenue of the inventory
     * @return the total revenue of the inventory
     */
    public double getTotalRevenue(){
        double TotalRevenue = 0;
        for(InventoryItem item : inventory.getItems()){
            TotalRevenue = TotalRevenue + (item.getQuantitySold() * item.getSellPrice());
        }
        return TotalRevenue;
    }

    /**
     * This method Calculates the profit or loss the inventory is making
     * @return the profit or loss of the inventory
     */
    public double calculateProfit(){
        return this.getTotalRevenue() - this.getTotalCosts();
    }

    /**
     * This method returns whether you are making a loss (true) or profit (false)
     * @return true or false if the inventory is making a loss
     */
    public boolean loss(){
        return this.calculateProfit() < 0;
    }

}
