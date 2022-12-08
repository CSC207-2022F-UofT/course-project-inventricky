package database_access;

import entities.TestResources;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BarcodeRemoverTest {

    private static final HashMap<String, List<String>> barcodes = new HashMap<>();
    private static File tempfile;

    /** Create test data for
     *
     * @throws IOException file not found.
     */
    @BeforeAll
    static void createTestData() throws IOException {
        barcodes.put("01", new ArrayList<>(List.of("01000")));
        barcodes.put("11", new ArrayList<>(Arrays.asList("11011", "11024")));
        barcodes.put("12", new ArrayList<>(Arrays.asList("12010", "12011", "12012")));

        Path pathIn = Paths.get("src/test/java/test_files/barcode_test.csv");
        tempfile = new File("src/test/java/test_files/barcode_test-copy.csv");
        Path pathOut = Paths.get("src/test/java/test_files/barcode_test-copy.csv");
        Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);
    }

    /** Given csv with multiple barcodes in a department, test if correct barcode is removed.
     *
     */
    @Test
    void givenMultipleBarcodesInDepartment_whenBarcodeRemoved_thenCorrectBarcodeRemoved() {
        BarcodeRemover.removeBarcode("12011", barcodes, "src/test/java/test_files/barcode_test-copy.csv");
        assertEquals(barcodes.get("12"), new ArrayList<>(Arrays.asList("12010", "12012")));
        Assertions.assertTrue(TestResources.checkLineEquality("src/test/java/test_files/barcode_test-copy.csv",
                "12010, 12012", 2));
    }

    /** Given a csv with a single barcode in a department, test if barcode and department is removed.
     *
     */
    @Test
    void givenSingleBarcodeInDepartment_whenBarcodeRemoved_thenDepartmentRemoved() {
        BarcodeRemover.removeBarcode("01000", barcodes, "src/test/java/test_files/barcode_test-copy.csv");
        assertFalse(barcodes.containsKey("01"));
        assertTrue(TestResources.checkLineEquality("src/test/java/test_files/barcode_test-copy.csv",
                "11, 12", 0));
        assertTrue(TestResources.checkLineEquality("src/test/java/test_files/barcode_test-copy.csv",
                "11011, 11024", 1));
    }

    /** Delete files used for testing.
     *
     */
    @AfterAll
    static void deleteTempFile() {
        tempfile.delete();
    }

}