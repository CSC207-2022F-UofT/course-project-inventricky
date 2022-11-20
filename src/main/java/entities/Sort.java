package entities;

import java.util.ArrayList;
import java.util.List;

public class Sort {




    /**
     * @param items  The items to be sorted
     * @return An array of items sorted by barcode number low to high.
     */
    public Item[] sortBarcode(ArrayList<Item> items){
        Item[] returnArr = new Item[items.size()];
        List<Integer> barcodes = new ArrayList<Integer>(items.size());
        for(int i = 0; i< items.size(); i++){
            barcodes.set(i, items.get(i).getBarcode());
        }
        for(int i=0; i< items.size(); i++){
            returnArr[i] = items.get(SortArray(barcodes)[i]);
        }
        return returnArr;
    }

    /**
     * @param items  The items to be sorted
     * @return An array of items sorted by name in alphabetical order.
     */
    public Item[] sortName(ArrayList<Item> items){
        Item[] returnArr = new Item[items.size()];
        List<String> names = new ArrayList<String>(items.size());
        for(int i = 0; i< items.size(); i++){
            names.set(i, items.get(i).getName());
        }
        for(int i=0; i< items.size(); i++){
            returnArr[i] = items.get(SortArray(names)[i]);
        }
        return returnArr;
    }

    /**
     * @param items  The items to be sorted
     * @return An array of items sorted by quantity low to high
     */
    public Item[] sortQuantity(ArrayList<Item> items){
        Item[] returnArr = new Item[items.size()];
        List<Double> quantities = new ArrayList<Double>(items.size());
        for(int i = 0; i< items.size(); i++){
            quantities.set(i, items.get(i).getQuantity());
        }
        for(int i=0; i< items.size(); i++){
            returnArr[i] = items.get(SortArray(quantities)[i]);
        }
        return returnArr;
    }

    /**
     * @param items  The items to be sorted
     * @return An array of items sorted by buy price low to high.
     */
    public Item[] sortBuyPrice(ArrayList<Item> items){
        Item[] returnArr = new Item[items.size()];
        List<Integer> prices = new ArrayList<Integer>(items.size());
        for(int i = 0; i< items.size(); i++){
            prices.set(i, items.get(i).getBuyPrice());
        }
        for(int i=0; i< items.size(); i++){
            returnArr[i] = items.get(SortArray(prices)[i]);
        }
        return returnArr;
    }

    /**
     * @param items  The items to be sorted
     * @return An array of items sorted sell price low to high.
     */
    public Item[] sortSellPrice(ArrayList<Item> items){
        Item[] returnArr = new Item[items.size()];
        List<Integer> prices = new ArrayList<Integer>(items.size());
        for(int i = 0; i< items.size(); i++){
            prices.set(i, items.get(i).getSellPrice());
        }
        for(int i=0; i< items.size(); i++){
            returnArr[i] = items.get(SortArray(prices)[i]);
        }
        return returnArr;
    }

    /**
     * @param items  The items to be sorted
     * @return An array of items sorted by case quantity low to high.
     */
    public Item[] sortCaseQuantity(ArrayList<Item> items){
        Item[] returnArr = new Item[items.size()];
        List<Integer> quantities = new ArrayList<Integer>(items.size());
        for(int i = 0; i< items.size(); i++){
            quantities.set(i, items.get(i).getCaseQuantity());
        }
        for(int i=0; i< items.size(); i++){
            returnArr[i] = items.get(SortArray(quantities)[i]);
        }
        return returnArr;
    }

    //Returns an array such that comparables[return_arr[0]] <= comparables[return_arr[1]] <= ...
    //Works for comparables as all strings or all doubles or all integers.
    public <T extends Comparable<T>> int[] SortArray(List<T> comparables){
        int[] return_arr = new int[comparables.size()];
        for(int i = 0; i< comparables.size(); i++){
            return_arr[i] = i;
        }
        for (int i = 1; i < comparables.size(); ++i) {
            int key = return_arr[i];
            int j = i - 1;

            while (j >= 0 && comparables.get(return_arr[j]).compareTo(comparables.get(key)) > 0) {
                return_arr[j + 1] = return_arr[j];
                j = j - 1;
            }
            return_arr[j + 1] = key;
        }
        return return_arr;
    }




}