package entities;

import java.util.ArrayList;
import java.util.Objects;

public class Filter {

    /**
     *
     * @param items Items that are being filtered.
     * @param byWeight True if you want the items that are by weight, false if you want items that aren't by weight
     * @return array of items that are either by weight or aren't by weight, depending on byWeight
     */
    public ArrayList<InventoryItem> filterByWeight(ArrayList<InventoryItem> items, boolean byWeight){
        ArrayList<InventoryItem> returnList = new ArrayList<InventoryItem>();
        for(InventoryItem item: items){
            if(item.getIsWeight() == byWeight){
                returnList.add(item);
            }
        }
        return returnList;
    }

    /**
     *
     * @param items Items that are being filtered.
     * @param department What department you want to filter by
     * @return array of items that are in the specified department
     */
    public ArrayList<InventoryItem> filterDepartment(ArrayList<InventoryItem> items, String department){
        ArrayList<InventoryItem> returnList = new ArrayList<InventoryItem>();
        for(InventoryItem item: items){
            if(Objects.equals(item.getDepartment(), department)){
                returnList.add(item);
            }
        }
        return returnList;
    }


}
