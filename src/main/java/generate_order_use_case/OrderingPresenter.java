package generate_order_use_case;

import Screens.InventoryViewModel;

public interface OrderingPresenter {
        InventoryViewModel prepareSuccessView(OrderingResponseModel newOrder, String[][] inventoryTable);

    }


