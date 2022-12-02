package new_item_use_case;

//Data access interface
public interface NewItemDsGateway {

    void addItem(NewItemDsRequestModel requestModel); //add item to database, add barcode to barcode file
}
