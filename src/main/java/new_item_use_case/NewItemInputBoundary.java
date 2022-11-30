package new_item_use_case;

import Screens.InventoryViewModel;

//Input boundary
public interface NewItemInputBoundary {
    //take item data and return a message stating that item with barcode has been added
    //TODO implement case where item being added is invalid


    //use case interactor must implement this method where it takes in input data and returns output data
    InventoryViewModel create(NewItemRequestModel requestModel);

}
