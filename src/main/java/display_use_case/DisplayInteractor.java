package display_use_case;

import Screens.InventoryViewModel;
import entities.InventoryItem;
import entities.comparator.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class DisplayInteractor implements DisplayInputBoundary {

    final DisplayPresenter displayPresenter;

    public DisplayInteractor(DisplayPresenter displayPresenter) {
        this.displayPresenter = displayPresenter;
    }

    /**
     *
     * @param displayRequestModel Data structure that contains information needed to do search, sort, and filter.
     * @return A data structure the view can use that contains the search, sorted, or filtered inventoryItems.
     */
    @Override
    public InventoryViewModel create(DisplayRequestModel displayRequestModel) {
        ArrayList<InventoryItem> items = new ArrayList<>();

        if(Objects.equals(displayRequestModel.getAction(), "searchResults")){
            items = searchResults(displayRequestModel.getItems(), (String) displayRequestModel.getParameter());
        }
        else if(Objects.equals(displayRequestModel.getAction(), "filterDepartment")){
            items = filterDepartment(displayRequestModel.getItems(), (String) displayRequestModel.getParameter());
        }
        else if(Objects.equals(displayRequestModel.getAction(), "sortBarcode")){
            items = sortBarcode(displayRequestModel.getItems(), (Boolean) displayRequestModel.getParameter());
        }
        else if(Objects.equals(displayRequestModel.getAction(), "sortName")){
            items = sortName(displayRequestModel.getItems(), (Boolean) displayRequestModel.getParameter());
        }
        else if(Objects.equals(displayRequestModel.getAction(), "sortBuyPrice")){
            items = sortBuyPrice(displayRequestModel.getItems(), (Boolean) displayRequestModel.getParameter());
        }
        else if(Objects.equals(displayRequestModel.getAction(), "sortQuantity")){
            items = sortQuantity(displayRequestModel.getItems(), (Boolean) displayRequestModel.getParameter());
        }
        else if(Objects.equals(displayRequestModel.getAction(), "sortCaseQuantity")){
            items = sortCaseQuantity(displayRequestModel.getItems(), (Boolean) displayRequestModel.getParameter());
        }
        else if(Objects.equals(displayRequestModel.getAction(), "sortSellPrice")){
            items = sortSellPrice(displayRequestModel.getItems(), (Boolean) displayRequestModel.getParameter());
        }
        String[][] inventoryTable = new String[items.size()][7];
        for (int i = 0; i < items.size(); i++) {
            InventoryItem item = items.get(i);
            inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode(),
                    item.getBuyPrice()+"", item.getSellPrice()+"",
                    Integer.toString(item.getCaseQuantity()), item.getDepartment()};
        }
        return displayPresenter.prepareSuccessView(new InventoryViewModel(inventoryTable, new String[]{}));
    }

    /**
     * Returns a list of all items in the specified inventory that have a name
     * containing the keyword specified. Capitalization is ignored.
     * @param items list of items being searched
     * @param name what is being searched for
     * @return list of items in array containing name
     */
    public ArrayList<InventoryItem> searchResults(ArrayList<InventoryItem> items, String name){
        ArrayList<InventoryItem> returnList = new ArrayList<>();
        for(InventoryItem item: items){
            if(item.getName().toLowerCase().contains(name.toLowerCase()) ||
                    name.toLowerCase().contains(item.getName().toLowerCase())){
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
        ArrayList<InventoryItem> returnList = new ArrayList<>();
        for(InventoryItem item: items){
            if(Objects.equals(item.getDepartment(), department)){
                returnList.add(item);
            }
        }
        return returnList;
    }

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