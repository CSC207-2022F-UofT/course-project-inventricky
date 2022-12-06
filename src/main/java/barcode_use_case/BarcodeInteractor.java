package barcode_use_case;

import database_access.BarcodeGenerator;
import database_access.BarcodeMapReader;
import database_access.BarcodeRemover;
import entities.InventoryItem;

import java.util.HashMap;
import java.util.List;



public class BarcodeInteractor implements GenerateBarcodeInputBoundary, ReadBarcodeInputBoundary, RemoveBarcodeInputBoundary {
    public BarcodeInteractor() {
    }

    /** Calls barcode generator to generate barcode for a new item.
     *
     * @param department    department of new item.
     * @param barcodes      Mapping of departments to their existing barcodes.
     * @param file          filepath of csv storing barcodes.
     * @return              Barcode generated.
     */
    @Override
    public String generateBarcode(String department, HashMap<String, List<String>> barcodes, String file) {
        return BarcodeGenerator.generateBarcode(department, barcodes, file);
    }

    /** Calls barcode remover to remove barcode for existing item.
     *
     * @param barcode       department of removed item
     * @param barcodes      barcode to be removed
     * @param file          filepath of csv storing barcodes.
     */
    @Override
    public void removeBarcode(String barcode, HashMap<String, List<String>> barcodes, String file) {
        BarcodeRemover.removeBarcode(barcode, barcodes, file);
    }

    /** Calls barcode reader to read barcode csv file and store it in a HashMap.
     *
     * @param file          filepath of csv storing barcodes.
     * @return              Mapping of departments to their existing barcodes.
     */
    @Override
    public HashMap<String, List<String>> readBarcode(String file) {
        return BarcodeMapReader.readBarcodes(file);
    }

}

