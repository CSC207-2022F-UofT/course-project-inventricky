package entities;

import entities.comparator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {




    /**
     * @param items  The items to be sorted
     * @param lowToHigh True if want to sort low to high, false if want to sort high to low
     * @return The sorted items
     */
    public ArrayList<InventoryItem> sortBarcode(ArrayList<InventoryItem> items, boolean lowToHigh){
        if(lowToHigh) {
            items.sort(new SortBarcode());
        }
        else{
            items.sort(Collections.reverseOrder(new SortBarcode()));
        }
        return items;
    }

    /**
     * @param items  The items to be sorted
     * @param alphabetical True if want to sort alphabetically, false if want to sort reverse alphabetically
     * @return An array of items sorted by name in alphabetical order.
     */
    public ArrayList<InventoryItem> sortName(ArrayList<InventoryItem> items, boolean alphabetical){
        if(alphabetical) {
            items.sort(new SortName());
        }
        else{
            items.sort(Collections.reverseOrder(new SortName()));
        }
        return items;
    }

    /**
     * @param items  The items to be sorted
     * @param lowToHigh True if want to sort low to high, false if want to sort high to low
     * @return An array of items sorted by quantity low to high
     */
    public ArrayList<InventoryItem> sortQuantity(ArrayList<InventoryItem> items, boolean lowToHigh){
        if(lowToHigh) {
            items.sort(new SortQuantity());
        }
        else{
            items.sort(Collections.reverseOrder(new SortQuantity()));
        }
        return items;
    }

    /**
     * @param items  The items to be sorted
     * @param lowToHigh True if want to sort low to high, false if want to sort high to low
     * @return An array of items sorted by buy price low to high.
     */
    public ArrayList<InventoryItem> sortBuyPrice(ArrayList<InventoryItem> items, boolean lowToHigh){
        if(lowToHigh) {
            items.sort(new SortBuyPrice());
        }
        else{
            items.sort(Collections.reverseOrder(new SortBuyPrice()));
        }
        return items;
    }

    /**
     * @param items  The items to be sorted
     * @param lowToHigh True if want to sort low to high, false if want to sort high to low
     * @return An array of items sorted sell price low to high.
     */
    public ArrayList<InventoryItem> sortSellPrice(ArrayList<InventoryItem> items, boolean lowToHigh){
        if(lowToHigh) {
            items.sort(new SortSellPrice());
        }
        else{
            items.sort(Collections.reverseOrder(new SortSellPrice()));
        }
        return items;
    }

    /**
     * @param items  The items to be sorted
     * @param lowToHigh True if want to sort low to high, false if want to sort high to low
     * @return An array of items sorted by case quantity low to high.
     */
    public ArrayList<InventoryItem> sortCaseQuantity(ArrayList<InventoryItem> items, boolean lowToHigh){
        if(lowToHigh) {
            items.sort(new SortCaseQuantity());
        }
        else{
            items.sort(Collections.reverseOrder(new SortCaseQuantity()));
        }
        return items;
    }






}