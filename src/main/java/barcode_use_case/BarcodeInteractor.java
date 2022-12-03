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

    @Override
    public String generateBarcode(String department, HashMap<String, List<String>> barcodes, String file) {
        return BarcodeGenerator.generateBarcode(department, barcodes, file);
    }

    @Override
    public void removeBarcode(String barcode, HashMap<String, List<String>> barcodes, String file) {
        BarcodeRemover.removeBarcode(barcode, barcodes, file);
    }

    @Override
    public HashMap<String, List<String>> readBarcode(String file) {
        return BarcodeMapReader.readBarcodes(file);
    }

}

