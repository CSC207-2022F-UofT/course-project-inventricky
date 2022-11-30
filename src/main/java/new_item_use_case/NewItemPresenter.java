package new_item_use_case;

import Screens.InventoryViewModel;

//Presenter
public interface NewItemPresenter {

    //item added to database, display item details
    InventoryViewModel prepareSuccessView(NewItemResponseModel newItem, String[][] inventoryTable);

    NewItemResponseModel prepareFailView(String error); //TODO more speicific errors
}
