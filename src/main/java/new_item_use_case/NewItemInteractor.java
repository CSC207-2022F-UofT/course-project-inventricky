package new_item_use_case;

import entities.InventoryItem;

//Use case interactor
public class NewItemInteractor implements NewItemInputBoundary {

    final NewItemDsGateway newItemDsGateway;        //interactor needs an inventory, talks to database
    final NewItemPresenter newItemPresenter;    //presenter

    //pass in data access class, presenter
    public NewItemInteractor(NewItemDsGateway newItemDsGateway, NewItemPresenter newItemDsPresenter) {
        this.newItemDsGateway = newItemDsGateway;
        this.newItemPresenter = newItemDsPresenter;
    }

    //returns output data, takes in input data
    @Override
    public NewItemResponseModel create(NewItemRequestModel requestModel) {

        //create new InventoryItem
        //TODO right now this assumes valid input
        InventoryItem item = new InventoryItem(requestModel.getName(), requestModel.getIsWeight(),
                requestModel.getQuantity(), requestModel.getBuyPrice(), requestModel.getSellPrice(),
                requestModel.getCaseQuantity(), requestModel.getDepartment(), 0, 0);

        //TODO implement time functionality

        //return new item's name and barcode to the presenter
        NewItemResponseModel itemResponseModel = new NewItemResponseModel(item.getName(), item.getBarcode());
        return newItemPresenter.prepareSuccessView(itemResponseModel);
    }
}
