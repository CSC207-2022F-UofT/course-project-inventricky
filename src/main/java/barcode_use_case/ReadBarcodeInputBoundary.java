package barcode_use_case;

import java.util.HashMap;
import java.util.List;

public interface ReadBarcodeInputBoundary {

    HashMap<String, List<String>> readBarcode(String file);
}
