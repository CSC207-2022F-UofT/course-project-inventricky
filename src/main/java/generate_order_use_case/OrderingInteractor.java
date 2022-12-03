//package generate_order_use_case;
//
//import Screens.InventoryViewModel;
//import entities.Inventory;
//import entities.Order;
//import useCases.OrderGenerator;
//
//public class OrderingInteractor implements OrderingInputBoundary {
//
//    final OrderingDsGateway orderingDsGateway;
//    final OrderingScreenUpdater orderingPresenter;
//    private final Inventory inventory;
//
//    public OrderingInteractor(OrderingDsGateway orderGateway, OrderingScreenUpdater orderPresenter, Inventory inventory){
//        this.orderingDsGateway = orderGateway;
//        this.orderingPresenter = orderPresenter;
//        this.inventory = inventory;
//    }
//
//    @Override
//    public InventoryViewModel create(OrderingRequestModel requestModel){
//        OrderGenerator newOrder = new OrderGenerator();
//        Order createdOrder = newOrder.registerOrderManual(requestModel.getName(), requestModel.getSupplier(), requestModel.getOrderCases(),
//                inventory, requestModel.getIsWeight(), requestModel.getBuyPrice(), requestModel.getSellPrice(),
//                requestModel.getCaseQuantity(), requestModel.getDepartment());
//
//        OrderingResponseModel orderingResponseModel = new OrderingResponseModel(createdOrder.getName(),
//                createdOrder.getBarcode(), createdOrder.getDateBought(), createdOrder.getEstimatedDate(),
//                createdOrder.getDateReceived(), createdOrder.getSupplier(), createdOrder.getOrderCases());
//
//        String[][] inventoryTable = new String[inventory.getOrders().size()][3];
//
//        for (int i = 0; i < inventory.getOrders().size(); i++) {
//            Order order = inventory.getOrders().get(i);
//            inventoryTable[i] = new String[] {order.getName(), order.getQuantity()+"", order.getBarcode()};
//        }
//        return OrderingScreenUpdater.prepareSuccessView(OrderingResponseModel, inventoryTable);
//    }
//
//}
