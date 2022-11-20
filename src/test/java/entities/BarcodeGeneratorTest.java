package entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BarcodeGeneratorTest {

    private static HashMap<String, List<String>> barcodes = new HashMap<String, List<String>>();
    private static File tempfile;
    private static File emptyTempfile;

    @BeforeAll
    static void createTestData() throws IOException {
        barcodes.put("01", new ArrayList<>(List.of("01000")));
        barcodes.put("11", new ArrayList<>(Arrays.asList("11011", "11024")));
        barcodes.put("12", new ArrayList<>(Arrays.asList("12010", "12011", "12012")));

        Path pathIn = Paths.get("src/test/java/test_files/barcode_test.csv");
        tempfile = new File("src/test/java/test_files/barcode_test-copy.csv");
        Path pathOut = Paths.get("src/test/java/test_files/barcode_test-copy.csv");
        Files.copy(pathIn, pathOut, StandardCopyOption.REPLACE_EXISTING);

        Path pathInEmpty = Paths.get("src/test/java/test_files/empty.csv");
        emptyTempfile = new File("src/test/java/test_files/empty-copy.csv");
        Path pathOutEmpty = Paths.get("src/test/java/test_files/empty-copy.csv");
        Files.copy(pathInEmpty, pathOutEmpty, StandardCopyOption.REPLACE_EXISTING);


    }

    @Test
    void givenDepartmentInCsv_whenBarcodeGenerated_thenCorrectBarcodeAdded() {
        BarcodeGenerator.generateBarcode("11", barcodes, "src/test/java/test_files/barcode_test-copy.csv");
        assertEquals(barcodes.get("11"), new ArrayList<>(Arrays.asList("11011", "11024", "11025")));
        assertTrue (TestResources.checkLineEquality("src/test/java/test_files/barcode_test-copy.csv",
                "11011, 11024, 11025", 2));

    }

    @Test
    void givenDepartmentNotInCsv_whenBarcodeGenerated_thenCorrectBarcodeAdded() {
        BarcodeGenerator.generateBarcode("13", barcodes, "src/test/java/test_files/barcode_test-copy.csv");
        assertEquals(barcodes.get("13"), new ArrayList<>(List.of("13000")));
        assertTrue (TestResources.checkLineEquality("src/test/java/test_files/barcode_test-copy.csv",
                "01, 11, 12, 13", 0));
        assertTrue (TestResources.checkLineEquality("src/test/java/test_files/barcode_test-copy.csv",
                "13000", 4));

    }

    @Test
    void givenEmptyCsv_whenBarcodeGenerated_thenCorrectBarcodeAdded() {
        barcodes.clear();
        BarcodeGenerator.generateBarcode("02", barcodes, "src/test/java/test_files/empty-copy.csv");
        assertEquals(barcodes.get("02"), new ArrayList<>(List.of("02000")));
        assertTrue (TestResources.checkLineEquality("src/test/java/test_files/empty-copy.csv",
                "02", 0));
        assertTrue (TestResources.checkLineEquality("src/test/java/test_files/empty-copy.csv",
                "02000", 1));


    }

    @AfterAll
    static void deleteTempFile() {
        tempfile.delete();
        emptyTempfile.delete();
    }
}