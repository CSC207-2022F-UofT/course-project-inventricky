package generate_order_use_case;

import Screens.InventoryViewModel;

public interface OrderingInputBoundary {
    InventoryViewModel create(OrderingRequestModel requestModel);
}
