package display_use_case;
import Screens.InventoryViewModel;

public interface DisplayInputBoundary {

    InventoryViewModel create(DisplayRequestModel displayRequestModel);
}

