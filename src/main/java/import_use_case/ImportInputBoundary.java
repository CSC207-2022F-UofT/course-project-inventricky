package import_use_case;

public interface ImportInputBoundary {
    /**
     * Presenters must implement this method
     */
    InventoryViewModel create(ImportRequestModel importRequestModel);
}
