package entities;

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
     * Prints a revenue breakdown line by line
     * Each line should contain the item's name, quantity sold, selling price, total revenue for that product
     * Check if each item is quantified by weight, if so print the information accordingly
     * Print out the total revenue of the inventory
     */
    public void totalRevenueBreakdown(){
        System.out.println("Revenue:");
        for (InventoryItem item : inventory.getItems()){
            if (item.getIsWeight()){
                System.out.println(item.getName() + ": kg sold: " + item.getQuantitySold() +
                                   " price per kg: " + item.getSellPrice() + " total revenue for product: " +
                                   item.getQuantitySold() * item.getSellPrice());

            } else{
                System.out.println(item.getName() + ": quantity sold: " + item.getQuantitySold() +
                        " price per product: " + item.getSellPrice() + " total revenue for product: " +
                        item.getQuantitySold() * item.getSellPrice());
            }
        }
        System.out.println("Total Revenue: " + this.getTotalRevenue());

    }

    /**
     * Prints a cost breakdown line by line
     * Each line should contain the item's name, quantity bought, buy price, total cost for that product
     * Check if each item is quantified by weight, if so print the information accordingly
     * Print out the total cost of the inventory
     */
    public void totalCostsBreakdown(){
        System.out.println("Costs: ");
        for (InventoryItem item : inventory.getItems()){
            if (item.getIsWeight()){
                System.out.println(item.getName() + ": kg bought: " + item.getQuantityBought() +
                                   " price per kg: " + item.getBuyPrice() + " total cost for product: " +
                                   item.getQuantityBought() * item.getBuyPrice());
            } else{
                System.out.println(item.getName() + ": quantity bought: " + item.getQuantityBought() +
                        " price per product: " + item.getBuyPrice() + " total cost for product: " +
                        item.getQuantityBought() * item.getBuyPrice());
            }
        }
        for (Order order : inventory.getOrders()){
            if (order.getIsWeight()){
                System.out.println(order.getName() + ": kg per case: " + order.getCaseQuantity() +
                        " number of cases: " + order.getOrderCases() + " price per kg: " + order.getBuyPrice() +
                        " total cost for product: " + order.getCaseQuantity() * order.getOrderCases()
                        * order.getBuyPrice());
            } else{
                System.out.println(order.getName() + ": quantity per case: " + order.getCaseQuantity() +
                        " number of cases: " + order.getOrderCases() + " price per item: " + order.getBuyPrice() +
                        " total cost for product: " + order.getCaseQuantity() * order.getOrderCases()
                        * order.getBuyPrice());
            }
        }
        System.out.println("Total Costs: " + this.getTotalCosts());
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
