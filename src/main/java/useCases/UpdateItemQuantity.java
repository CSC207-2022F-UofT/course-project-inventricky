package useCases;

import entities.InventoryItem;
import entities.Inventory;

public class UpdateItemQuantity {

    public class ItemNotFoundException extends RuntimeException {

    }
    /**
     * Update quantity of given item, with given reason. Save changes in an item log.
     *
     * @param barcode    barcode of item to be updated
     * @param newQuantity new item quantity
     * @param updateReason   reason for change in quantity (can be one of: "bought", "sold", "error")
     */
    public static void updateQty(Inventory inventory, String barcode, double newQuantity, String updateReason) {

        InventoryItem target = null;
        for (InventoryItem item : inventory.getItems()) {
            if (item.getBarcode().equals(barcode)) {
                target = item;
            }
        }
        if (target == null) { throw new RuntimeException(); }

        double diff = newQuantity - target.getQuantity(); // difference between new quantity and old quantity
        diff = diff * 100.0;
        double roundedDiff = Math.round(diff) / 100.0;

        if (updateReason.equals("bought")) {
            target.setQuantityBought(target.getQuantityBought() + roundedDiff);
            target.getItemHistory().add("b" + roundedDiff);
        } else if (updateReason.equals("sold")) {
            target.setQuantitySold(target.getQuantitySold() - roundedDiff);
            target.getItemHistory().add("s" + -roundedDiff);
        } else {
            target.getItemHistory().add("e" + roundedDiff);
        }

        target.setQuantity(newQuantity);
    }
}

