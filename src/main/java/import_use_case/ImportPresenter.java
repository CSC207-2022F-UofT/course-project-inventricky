package import_use_case;

import Screens.InventoryViewModel;

import java.util.HashMap;

public interface ImportPresenter {
    /**
     * Presenters must implement this method
     * @param inventoryTable table representation of inventory
     * @param controllers hashmap of controller objects
     * @param invName name of inventory
     * @return InventoryViewModel returns an inventoryViewModel
     */
    InventoryViewModel prepareSuccessView(String[][] inventoryTable, String[] inventoryHistory, HashMap<String, Object> controllers, String invName);

}





