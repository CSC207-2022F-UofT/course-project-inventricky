package entities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

public class Importer {
    private Inventory inventory;
    private final String filename;
    private String delimiter = ";";

    public Importer(String fileToImport, Inventory givenInventory) {
        this.filename = fileToImport;
        this.inventory = givenInventory;
    }

    public Importer(String fileToImport, Inventory givenInventory, String delimiter) {
        this.filename = fileToImport;
        this.inventory = givenInventory;
        this.delimiter = delimiter;
    }

    private List<List> importToList() {
        List<List> importList = new ArrayList<>();
        // Converting path string to path
        Path filePath = Paths.get(this.filename);

        // Creating a BufferedReader and using an Exception to catch an IOException
        try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.US_ASCII)) {
            // First Line
            String line = reader.readLine();
            // Breaks when there is no next line
            while (line != null) {
                // Splits line of csv file into array based on given delimiter
                String[] readStuff = line.split(delimiter);
                // Temporary list to store line and copy into what is to be returned
                List<String> copyList = new ArrayList<>();
                for (String str : readStuff) {
                    copyList.add(str);
                }
                importList.add(copyList);
                // Goes to next line
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return importList;
    }

    public static void main(String[] args) {
        // Demo of the import functionality
        Inventory inv = new Inventory("Dario");
        Importer importer = new Importer("src\\main\\java\\exports\\test.csv", inv);
        System.out.println(importer.importToList());
    }
}
