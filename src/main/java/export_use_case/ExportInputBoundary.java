package export_use_case;

import Screens.ExportViewModel;

import java.io.IOException;

public interface ExportInputBoundary {
    /**
     * Abstract interface that is implemented by ExporterInventory; needed to comunicate and relay data between layers
     * @param exportRequestModel Export Request Model; a class that connects this layer to the entities
     * @throws IOException as required by the Export Request Model
     */
    ExportViewModel create(ExportRequestModel exportRequestModel) throws IOException;

}

