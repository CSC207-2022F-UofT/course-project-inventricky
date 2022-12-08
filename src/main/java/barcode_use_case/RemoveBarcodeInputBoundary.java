package barcode_use_case;

import java.util.HashMap;
import java.util.List;

public interface RemoveBarcodeInputBoundary {
    /** Classes must implement this method to use barcode remover.
     *
     */
    void removeBarcode(String barcode, HashMap<String, List<String>> barcodes, String file);
}
