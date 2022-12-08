package entities.comparator;

import entities.InventoryItem;

import java.util.Comparator;

public class SortCaseQuantity implements Comparator<InventoryItem> {
    public int compare(InventoryItem a, InventoryItem b){
        if(a.getCaseQuantity() > b.getCaseQuantity()){
            return 1;
        } else if (a.getCaseQuantity() == b.getCaseQuantity()) {
            return 0;
        }
        return -1;
    }
}