package Screens;

import java.util.ArrayList;

public class ItemHistoryViewModel {

    ArrayList<String> itemHistory;

    public ItemHistoryViewModel(ArrayList<String> itemHistory) { this.itemHistory = itemHistory; }

    public ArrayList<String> getItemHistory() {
        return itemHistory;
    }

}
