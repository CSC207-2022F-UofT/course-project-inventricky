package entities;

import java.util.ArrayList;

public class Analysis {
    private final Inventory inventory;

    public Analysis(Inventory inventory){
        this.inventory = inventory;
    }

    public ArrayList<Item> getAllItems(){
        return inventory.getItems();
    }

    public void totalRevenueBreakdown(){
        for (Item item : inventory.getItems()){
            if (item.isUnit()){
                System.out.println(item.getName() + ": kg sold: " + item.getQuantitySold() +
                                   " price per kg: " + item.getSellPrice() + " total revenue for product: " +
                                   item.getQuantitySold() * item.getSellPrice());

            } else{
                System.out.println(item.getName() + ": quantity sold: " + item.getQuantitySold() +
                        " price per product: " + item.getSellPrice() + " total revenue for product: " +
                        item.getQuantitySold() * item.getSellPrice());
            }
        }

    }

    public void totalCostsBreakdown(){
        for (Item item : inventory.getItems()){
            if (item.isUnit()){
                System.out.println(item.getName() + ": kg bought: " + item.getQuantityBought() +
                                   " price per kg: " + item.getBuyPrice() + " total cost for product: " +
                                   item.getQuantityBought() * item.getBuyPrice());
            } else{
                System.out.println(item.getName() + ": quantity bought: " + item.getQuantityBought() +
                        " price per product: " + item.getBuyPrice() + " total cost for product: " +
                        item.getQuantityBought() * item.getBuyPrice());
            }
        }
    }

    public double getTotalCosts(){
        double TotalCosts = 0;
        for (Item item : inventory.getItems()){
            TotalCosts = TotalCosts + (item.getQuantityBought() * item.getBuyPrice());
        }
        return TotalCosts;
    }

    public double getTotalRevenue(){
        double TotalRevenue = 0;
        for(Item item : inventory.getItems()){
            TotalRevenue = TotalRevenue + (item.getQuantitySold() * item.getSellPrice());
        }
        return TotalRevenue;
    }

    public double calculateProfit(){
        return this.getTotalRevenue() - this.getTotalCosts();
    }

    public boolean loss(){
        return this.calculateProfit() < 0;
    }

}
