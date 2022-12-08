package entities.comparator;

import entities.InventoryItem;

import java.util.Comparator;

public class SortName implements Comparator<InventoryItem> {
    public int compare(InventoryItem a, InventoryItem b) {
        return a.getName().compareTo(b.getName());
    }
}