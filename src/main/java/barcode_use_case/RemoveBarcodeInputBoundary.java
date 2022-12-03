package barcode_use_case;

import java.util.HashMap;
import java.util.List;

public interface RemoveBarcodeInputBoundary {

    void removeBarcode(String barcode, HashMap<String, List<String>> barcodes, String file);
}
