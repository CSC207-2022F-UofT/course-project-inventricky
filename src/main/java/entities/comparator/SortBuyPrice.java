package entities.comparator;

import entities.InventoryItem;

import java.util.Comparator;

public class SortBuyPrice implements Comparator<InventoryItem> {
    public int compare(InventoryItem a, InventoryItem b){
        if(a.getBuyPrice() > b.getBuyPrice()){
            return 1;
        } else if (a.getBuyPrice() == b.getBuyPrice()) {
            return 0;
        }
        return -1;
    }
}
