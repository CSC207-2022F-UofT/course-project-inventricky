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
    public ArrayList<InventoryItem> searchResults(ArrayList<InventoryItem> items, String name){
        ArrayList<InventoryItem> returnList = new ArrayList<InventoryItem>();
        for(InventoryItem item: items){
            if(item.getName().toLowerCase().contains(name.toLowerCase()) ||
            name.toLowerCase().contains(item.getName().toLowerCase())){
                returnList.add(item);
            }
        }

        return returnList;
    }
}
