package import_use_case;

import Screens.InventoryViewModel;

public interface ImportInputBoundary {
    /**
     * Presenters must implement this method
     */
    InventoryViewModel create(ImportRequestModel importRequestModel);
}





