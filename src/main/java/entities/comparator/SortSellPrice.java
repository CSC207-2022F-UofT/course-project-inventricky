package entities.comparator;

import entities.InventoryItem;

import java.util.Comparator;

public class SortSellPrice implements Comparator<InventoryItem> {
    public int compare(InventoryItem a, InventoryItem b){
        if(a.getSellPrice() > b.getSellPrice()){
            return 1;
        } else if (a.getSellPrice() == b.getSellPrice()) {
            return 0;
        }
        return -1;
    }
}