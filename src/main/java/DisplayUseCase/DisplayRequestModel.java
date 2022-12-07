package DisplayUseCase;

import Screens.InventoryViewModel;
import entities.InventoryItem;

import java.util.ArrayList;

public class DisplayRequestModel {
    private ArrayList<InventoryItem> items;
    private String action;

    private Object parameter;

    /**
     *
     * @param inventoryViewModel contains the items in some form
     * @param action what you want to do. Options are searchResults, filterDepartment, sortName, sortBarcode,
     *               sortQuantity, sorBuyPrice, sortSellPrice, sortCaseQuantity
     * @param parameter boolean for sort based on normal versus reverse order, strings for filterDepartment and
     *                  serachResults based on what you are searching or filtering.
     */
    public DisplayRequestModel(InventoryViewModel inventoryViewModel, String action, Object parameter){
        this.action = action;
        this.items = new ArrayList<InventoryItem>();
        this.parameter = parameter;
        for(int i =0; i< inventoryViewModel.getItemList().length; i++){
            InventoryItem inventoryItem = new InventoryItem(inventoryViewModel.getItemList()[i][0],
                    inventoryViewModel.getItemList()[i][2], true,
                    Double.parseDouble(inventoryViewModel.getItemList()[i][1]),
                    Double.parseDouble(inventoryViewModel.getItemList()[i][3]),
                    Double.parseDouble(inventoryViewModel.getItemList()[i][4]),
                    Integer.parseInt(inventoryViewModel.getItemList()[i][5]),
                    inventoryViewModel.getItemList()[i][6],  0, 0);
            items.add(inventoryItem);
        }
    }

    public void setItems(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ArrayList<InventoryItem> getItems() {
        return items;
    }

    public String getAction() {
        return action;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

}
