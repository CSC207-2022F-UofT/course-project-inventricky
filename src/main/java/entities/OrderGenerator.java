package entities;

import java.time.LocalDate;

public class OrderGenerator {

    /**
     * Registers an order to the Inventory. Creates a new Order object using the given name, supplier, cases,
     * isWeight, buyPrice, sellPrice, caseQuantity, and department. If the order is of an item that does not
     * exist in the Inventory, create an InventoryItem for the ordered item.
     * @param name      The name of the ordered item.
     * @param supplier  The supplier of the order.
     * @param cases     The number of cases being ordered.
     * @param inventory The inventory the order is being registered to.
     * @param isWeight  Whether the item is quantified by weight.
     * @param buyPrice  The buy price of the item.
     * @param sellPrice The selling price of the item.
     * @param caseQuantity The amount of product within one case of an item.
     * @param department   The department of the item.
     * @return  The ordered item.
     */
    public Order registerOrder(String name, String supplier, int cases, Inventory inventory,
                               boolean isWeight, double buyPrice, double sellPrice, int caseQuantity,
                               String department){
        LocalDate dateToday = LocalDate.now();

        for(InventoryItem item: inventory.getItems()){
            if(item.getName().equals(name)){
                Order newExistingOrder = new Order(name, item.getBarcode(), item.getIsWeight(), item.getQuantity(),
                        item.getBuyPrice(), item.getSellPrice(), item.getCaseQuantity(), item.getDepartment(),
                        dateToday.toString(), dateToday.plusDays(5).toString(),
                        supplier, cases);
                inventory.addOrder(newExistingOrder);
                return newExistingOrder;
            }
        }

        InventoryItem newItem = new InventoryItem(name, isWeight, 0.0, buyPrice, sellPrice, caseQuantity, department,
                (cases * caseQuantity), 0.0);
        inventory.addItem(newItem);

        Order newOrder = new Order(name, newItem.getBarcode(), newItem.getIsWeight(), newItem.getQuantity(),
                newItem.getBuyPrice(), newItem.getSellPrice(), newItem.getCaseQuantity(), newItem.getDepartment(),
                dateToday.toString(), dateToday.plusDays(5).toString(),
                supplier, cases);
        inventory.addOrder(newOrder);
        return newOrder;
    }
}
