package Screens;

import generate_order_use_case.OrderingDsGateway;
import generate_order_use_case.OrderingDsRequestModel;
import new_item_use_case.NewItemDsGateway;
import new_item_use_case.NewItemDsRequestModel;
import remove_item_use_case.RemoveItemDsGateway;
import remove_item_use_case.RemoveItemDsRequestModel;
import update_item_quantity_use_case.UpdateItemQtyDsGateway;

//Data access
public class InventoryDatabase implements NewItemDsGateway, RemoveItemDsGateway, UpdateItemQtyDsGateway, OrderingDsGateway {

    @Override
    public void addItem(NewItemDsRequestModel requestModel) {

    }

    @Override
    public void removeItem(RemoveItemDsRequestModel requestModel) {

    }

    @Override
    public void placeOrder(OrderingDsRequestModel requestModel) {

    }
}
