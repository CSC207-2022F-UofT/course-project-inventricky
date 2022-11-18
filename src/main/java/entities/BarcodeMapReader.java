package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BarcodeMapReader {
    private static final String COMMA_DELIMITER = ", ";

    public static HashMap<String, List<String>> readBarcodes(String file) {

        HashMap<String, List<String>> barcodeMap = new HashMap<>();

        //case where csv is empty
        File csv = new File(file);
        if (csv.length() == 0) {
            return barcodeMap;
        }

        try {

            //create fileReader object that takes in file as a parameter
            FileReader fileReader = new FileReader(file);

            //create CSVReader
            BufferedReader br = new BufferedReader(fileReader);

            //Store csv data in map
            String[] departments = br.readLine().split(COMMA_DELIMITER);
            for (String department : departments) {
                ArrayList<String> stringCodes = new ArrayList(Arrays.asList(br.readLine().split(COMMA_DELIMITER))); //get barcodes (string)
                barcodeMap.put(department, stringCodes); //put barcodes in barcode map
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return barcodeMap;
    }

}
