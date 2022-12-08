package Screens;

import java.util.ArrayList;

public class ItemHistoryViewModel {

    ArrayList<String> itemHistory;

    /** Construct a new item history view model object.
     *
     * @param itemHistory   item quantity history.
     */
    public ItemHistoryViewModel(ArrayList<String> itemHistory) { this.itemHistory = itemHistory; }

    public ArrayList<String> getItemHistory() {
        return itemHistory;
    }

}
