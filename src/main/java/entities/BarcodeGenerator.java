package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BarcodeGenerator {

    private static final String COMMA_DELIMITER = ", ";

    public static HashMap<Integer, List<Integer>> readBarcodes(String file) {

        HashMap<Integer, List<Integer>> barcodeMap = new HashMap<>();

        try {

            //create fileReader object that takes in file as a parameter
            FileReader fileReader = new FileReader(file);

            //create CSVReader
            BufferedReader br = new BufferedReader(fileReader);

            //Store csv data in map
            String[] departments = br.readLine().split(COMMA_DELIMITER);
            for (String department : departments) {
                String[] stringCodes = br.readLine().split(COMMA_DELIMITER); //get barcodes (string)
                ArrayList<Integer> intCodes = new ArrayList(); //create arrayList for storing barcodes (int)
                for (String stringCode : stringCodes) { //store barcodes in array
                    intCodes.add(Integer.parseInt(stringCode, 10)); //parseInt with base 10 to keep leading zeros
                }
                barcodeMap.put(Integer.parseInt(department, 10), intCodes); //but barcodes in barcode map
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return barcodeMap;
    }


    public static int generateBarcode(int department, HashMap barcodes) {


        return 1; //TODO implement barcode generator
    }


}
