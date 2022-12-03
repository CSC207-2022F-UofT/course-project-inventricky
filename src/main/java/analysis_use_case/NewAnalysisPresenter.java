package analysis_use_case;

import Screens.InventoryViewModel;
import remove_item_use_case.RemoveItemResponseModel;
import update_item_quantity_use_case.UpdateItemQtyResponseModel;

public interface NewAnalysisPresenter {
    /**
     * This is the interface the presenter screen updater implements
     * @param list the list contains the data to be updated
     */
    public void showArray(String[] list);
}
