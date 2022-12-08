package barcode_use_case;

import java.util.HashMap;
import java.util.List;

public interface GenerateBarcodeInputBoundary {
    /** Classes must implement this method to use barcode generator.
     *
     */
    String generateBarcode(String department, HashMap<String, List<String>> barcodes, String file);
}

