package entities.comparator;

import entities.InventoryItem;

import java.util.Comparator;

public class SortQuantity implements Comparator<InventoryItem> {

    public int compare(InventoryItem a, InventoryItem b){
        if(a.getQuantity() > b.getQuantity()){
            return 1;
        } else if (a.getQuantity() == b.getQuantity()) {
            return 0;
        }
        return -1;
    }
}
