package entities;

import java.util.ArrayList;

public class Search {


    /**
     * Returns a list of all items in the specified inventory that have a name
     * containing the keyword specified. Capitalization is ignored.
     * @param items list of items being searched
     * @param name what is being searched for
     * @return list of items in array containing name
     */
    public Item[] searchResults(ArrayList<Item> items, String name){
        ArrayList<Item> returnList = new ArrayList<Item>();
        for(Item item: items){
            if(item.getName().toLowerCase().contains(item.getName().toLowerCase())){
                returnList.add(item);
            }
        }
        Item[] returnArr = new Item[returnList.size()];
        for(int i =0; i < returnList.size(); i++){
            returnArr[i] = returnList.get(i);
        }
        return returnArr;
    }
}
