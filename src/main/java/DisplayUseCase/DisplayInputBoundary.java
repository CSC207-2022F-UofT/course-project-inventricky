package DisplayUseCase;
import Screens.InventoryViewModel;

public interface DisplayInputBoundary {

    InventoryViewModel create(DisplayRequestModel displayRequestModel);
}
