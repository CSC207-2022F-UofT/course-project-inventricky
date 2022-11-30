package generate_order_use_case;

public class OrderingInteractor implements OrderingInputBoundary {

    final OrderingGateway orderingGateway;
    final OrderingPresenter orderingPresenter;

    public OrderingInteractor(OrderingGateway orderGateway, OrderingPresenter orderPresenter){
        this.orderingGateway = orderGateway;
        this.orderingPresenter = orderPresenter;
    }

    @Override
    public OrderingResponseModel create(OrderingRequestModel requestModel){

    }

}
