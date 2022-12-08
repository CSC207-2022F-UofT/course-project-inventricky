package barcode_use_case;

import java.util.HashMap;
import java.util.List;

public interface ReadBarcodeInputBoundary {
    /** Classes must implement this method to use barcode reader.
     *
     */
    HashMap<String, List<String>> readBarcode(String file);
}

