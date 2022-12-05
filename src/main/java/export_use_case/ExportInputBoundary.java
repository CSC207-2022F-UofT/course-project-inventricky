package export_use_case;

import Screens.ExportViewModel;

import java.io.IOException;

public interface ExportInputBoundary {
    ExportViewModel create(ExportRequestModel exportRequestModel) throws IOException;

}

