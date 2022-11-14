package entities;

import java.util.ArrayList;

public class Filter {

    /**
     *
     * @param items Items that are being filtered.
     * @param byWeight True if you want the items that are by weight, false if you want items that aren't by weight
     * @return array of items that are either by weight or aren't by weight, depending on byWeight
     */
    public Item[] filterWeight(ArrayList<Item> items, boolean byWeight){
        ArrayList<Item> returnList = new ArrayList<Item>();
        for(Item item: items){
            if(item.getIsWeight == byWeight){
                returnList.add(item);
            }
        }
        Item[] returnArr = new Item[returnList.size()];
        for(int i =0; i < returnList.size(); i++){
            returnArr[i] = returnList.get(i);
        }
        return returnArr;
    }

    /**
     *
     * @param items Items that are being filtered.
     * @param departmentNum What department you want to filter by
     * @return array of items that are in the specified department
     */
    public Item[] filterDepartment(ArrayList<Item> items, int departmentNum){
        ArrayList<Item> returnList = new ArrayList<Item>();
        for(Item item: items){
            if(item.getDepartment == departmentNum){
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
