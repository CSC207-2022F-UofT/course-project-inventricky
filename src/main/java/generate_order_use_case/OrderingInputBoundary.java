package generate_order_use_case;

public interface OrderingInputBoundary {
    OrderingResponseModel create(OrderingRequestModel requestModel);
}
