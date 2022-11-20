package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class BarcodeMapReaderTest {

    private static HashMap<String, List<String>> barcodes = new HashMap<String, List<String>>();

    @BeforeAll
    static void createTestData() {
        barcodes.put("01", new ArrayList<>(List.of("01000")));
        barcodes.put("11", new ArrayList<>(Arrays.asList("11011", "11024")));
        barcodes.put("12", new ArrayList<>(Arrays.asList("12010", "12011", "12012")));
    }

    @Test
    void givenEmptyCsv_returnEmptyMap() {
        assert BarcodeMapReader.readBarcodes("src/test/java/test_files/empty.csv").isEmpty();
    }

    @Test
    void givenCsv_returnCorrectMap() {
        assert BarcodeMapReader.readBarcodes("src/test/java/test_files/barcode_test.csv").equals(barcodes);
    }


    }

