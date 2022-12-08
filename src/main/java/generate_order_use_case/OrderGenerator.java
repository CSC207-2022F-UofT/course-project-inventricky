package generate_order_use_case;
import entities.Inventory;
import entities.InventoryItem;
import entities.Order;
import java.time.LocalDate;

public class OrderGenerator {

    Order newOrder;

    /**
     * Registers an order to the Inventory. Creates a new Order object using the given name, supplier, cases,
     * isWeight, buyPrice, sellPrice, caseQuantity, and department. If the order is of an item that does not
     * exist in the Inventory, create an InventoryItem for the ordered item.
     *
     * @param name      The name of the ordered item.
     * @param supplier  The supplier of the order.
     * @param cases     The number of cases being ordered.
     * @param inventory The inventory the order is being registered to.
     * @return          The ordered item.
     */
    public Order registerOrderManual(String name, String supplier, int cases, Inventory inventory) {
        LocalDate dateToday = LocalDate.now();

        for (InventoryItem item : inventory.getItems()) {
            if (item.getName().equals(name)) {
                newOrder = new Order(name, item.getBarcode(), item.getIsWeight(), item.getQuantity(),
                        item.getBuyPrice(), item.getSellPrice(), item.getCaseQuantity(), item.getDepartment(),
                        dateToday.toString(), dateToday.plusDays(5).toString(),
                        supplier, cases);
                inventory.addOrder(newOrder);

            }
        }

        return newOrder;
    }
}

