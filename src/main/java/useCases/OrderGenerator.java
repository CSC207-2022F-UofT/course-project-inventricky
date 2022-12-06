package useCases;

import entities.Inventory;
import entities.InventoryItem;
import entities.Order;

import java.time.LocalDate;

public class OrderGenerator{

    Order newOrder;
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
    public Order registerOrderManual(String name, String supplier, int cases, Inventory inventory,
                                     boolean isWeight, double buyPrice, double sellPrice, int caseQuantity,
                                     String department){
        LocalDate dateToday = LocalDate.now();

        for(InventoryItem item: inventory.getItems()){
            if(item.getName().equals(name)){
                newOrder = new Order(name, item.getBarcode(), item.getIsWeight(), item.getQuantity(),
                        item.getBuyPrice(), item.getSellPrice(), item.getCaseQuantity(), item.getDepartment(),
                        dateToday.toString(), dateToday.plusDays(5).toString(),
                        supplier, cases);
                inventory.addOrder(newOrder);

            }
        }

        return newOrder;

//        InventoryItem newItem = new InventoryItem(name, isWeight, 0.0, buyPrice, sellPrice, caseQuantity, department,
//                (cases * caseQuantity), 0.0);
//        inventory.addItem(newItem);

//        Order newOrder = new Order(name, newItem.getBarcode(), newItem.getIsWeight(), newItem.getQuantity(),
//                newItem.getBuyPrice(), newItem.getSellPrice(), newItem.getCaseQuantity(), newItem.getDepartment(),
//                dateToday.toString(), dateToday.plusDays(5).toString(),
//                supplier, cases);
//        inventory.addOrder(newOrder);
//        return newOrder;
    }

    /**
     * Auto register an order using the given name. The name of the item will allow the user to fill in the order
     * information automatically, while only inputting the amount of cases they want to order and the supplier they
     * want to order from. Register the order to the given inventory.
     * Precondition: item is already in inventory.
     * @param name      The name of the item.
     * @param inventory    The inventory the order is being added to.
     * @param cases      The number of cases being ordered.
     * @param supplier  The supplier of the order.
     * @return      The ordered item.
     */
    public Order registerOrderAuto(String name, Inventory inventory, int cases, String supplier){
        for(InventoryItem item: inventory.getItems()) {
            if (item.getName().equals(name)){
                return registerOrderManual(name, supplier, cases, inventory, item.getIsWeight(),
                        item.getBuyPrice(), item.getSellPrice(), item.getCaseQuantity(), item.getDepartment());
            }
        }
        return null;
    }
}

