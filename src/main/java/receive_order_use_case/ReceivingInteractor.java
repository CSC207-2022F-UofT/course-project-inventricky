//package receive_order_use_case;
//
//import Screens.InventoryViewModel;
//import entities.Inventory;
//import entities.Order;
//
//public class ReceivingInteractor implements ReceivingInputBoundary {
//    final ReceivingDsGateway receivingDsGateway;
//    final ReceivingPresenter receivingPresenter;
//
//    private Inventory inventory;
//
//    public ReceivingInteractor(ReceivingDsGateway receivingDsGateway, ReceivingPresenter receivingPresenter, Inventory inventory) {
//        this.receivingDsGateway = receivingDsGateway;
//        this.receivingPresenter = receivingPresenter;
//        this.inventory = inventory;
//    }
//
//    @Override
//public InventoryViewModel create(ReceivingRequestModel requestModel) throws RuntimeException {
//
//        if (requestModel.checkShipmentStatus().equals("Inbound Order")){
//
//        }
//    for (Order candidate : inventory.getOrders()) {
//        if (candidate.checkShipmentStatus().equals(requestModel.getShipmentStatus())) {
//            inventory.removeItem(candidate);
//
//            RemoveItemResponseModel removeItemResponseModel = new RemoveItemResponseModel(candidate.getName(), candidate.getBarcode());
//
//            String[][] inventoryTable = new String[inventory.getItems().size()][7];
//
//            for (int i = 0; i < inventory.getItems().size(); i++) {
//                InventoryItem item = inventory.getItems().get(i);
//                inventoryTable[i] = new String[] {item.getName(), item.getQuantity()+"", item.getBarcode(),
//                        item.getBuyPrice()+"", item.getSellPrice()+"",
//                        Integer.toString(item.getCaseQuantity()), item.getDepartment()};
//            }
//
//            return removeItemPresenter.prepareSuccessView(removeItemResponseModel, inventoryTable);
//
//        }
//    }
//
//    RuntimeException RuntimeException = null;
//    throw RuntimeException; //TODO exception
//
//}
