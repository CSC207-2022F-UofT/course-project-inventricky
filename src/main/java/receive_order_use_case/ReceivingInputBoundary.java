package receive_order_use_case;

import Screens.InventoryViewModel;

public interface ReceivingInputBoundary {
    InventoryViewModel create(ReceivingRequestModel requestModel);
}
