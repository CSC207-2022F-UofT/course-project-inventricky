package entities.comparator;

import entities.InventoryItem;

import java.util.Comparator;

public class SortBarcode implements Comparator<InventoryItem> {
    public int compare(InventoryItem a, InventoryItem b){
        return(a.getBarcode().compareTo(b.getBarcode()));
    }
}
