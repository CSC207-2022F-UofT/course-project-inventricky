package useCases;

import entities.InventoryItem;

public class UpdateItemQuantity {

    /**
     * Update quantity of given item, with given reason. Save changes in an item log.
     *
     * @param item     item to be updated
     * @param quantity new item quantity
     * @param reason   reason for change in quantity (can be one of: "bought", "sold", "error")
     */
    public void updateQty(InventoryItem item, double quantity, String reason) {

        double diff = quantity - item.getQuantity(); // difference between new quantity and old quantity


        if (reason.equals("bought")) {
            item.setQuantityBought(quantity);
        } else if (reason.equals("sold")) {
            item.setQuantitySold(quantity);
        }

        item.setQuantity(quantity);
    }
}

