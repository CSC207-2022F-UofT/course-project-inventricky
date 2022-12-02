package import_use_case;

import Screens.InventoryViewModel;

public interface ImportInputBoundary {
    InventoryViewModel create(ImportRequestModel importRequestModel);
}
