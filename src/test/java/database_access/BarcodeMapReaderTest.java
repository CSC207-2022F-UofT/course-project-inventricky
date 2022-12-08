package database_access;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class BarcodeMapReaderTest {

    private static final HashMap<String, List<String>> barcodes = new HashMap<>();

    /** Create test data for barcode reader testing.
     *
     */
    @BeforeAll
    static void createTestData() {
        barcodes.put("01", new ArrayList<>(List.of("01000")));
        barcodes.put("11", new ArrayList<>(Arrays.asList("11011", "11024")));
        barcodes.put("12", new ArrayList<>(Arrays.asList("12010", "12011", "12012")));
    }

    /** Given an empty csv, returns an empty Hashmap.
     *
     */
    @Test
    void givenEmptyCsv_returnEmptyMap() {
        assert BarcodeMapReader.readBarcodes("src/test/java/test_files/empty.csv").isEmpty();
    }

    /** Given a csv, returns HashMap with departments mapped to corresponding barcodes.
     *
     */
    @Test
    void givenCsv_returnCorrectMap() {
        assert BarcodeMapReader.readBarcodes("src/test/java/test_files/barcode_test.csv").equals(barcodes);
    }


    }


