package database_access;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BarcodeRemover {

    private static final String COMMA_DELIMITER = ", ";

    /**
     *  Removes a barcode from mapping of departments to barcode and
     *  csv storing this mapping. Should only be called when InventoryItem is being removed
     *  from inventory.
     *
     * @param barcode       Barcode to be removed from mapping and csv
     * @param barcodes      Current barcode mapping of item
     * @param file          Filepath of csv containing barcode mapping
     */
    public static void removeBarcode(String barcode, HashMap<String, List<String>> barcodes, String file) {

        String department = barcode.substring(0, 2);
        //remove barcode from map and csv


        String tempFileName = file.substring(0, file.lastIndexOf('.')) + ".temp";
        try {
            FileWriter fileWriter = new FileWriter(tempFileName); //create temporary csv file
            FileReader fileReader = new FileReader(file);

            BufferedWriter bw = new BufferedWriter(fileWriter);
            BufferedReader br = new BufferedReader(fileReader);

            //store departments as arrayList
            ArrayList<String> departmentsString = new ArrayList<String>(Arrays.asList(br.readLine().split(COMMA_DELIMITER)));

            //get index of department with deleted barcode in csv
            int depIndex = departmentsString.indexOf(department);

            //single barcode in department
            if (barcodes.get(department).size() == 1) {

                barcodes.remove(department); //remove key-value pair from map

                //case where only one department
                if (barcodes.isEmpty()) {

                    bw.close();
                    File original = new File(file);
                    original.delete();
                    new File(tempFileName).renameTo(original);
                    return;

                }

                departmentsString.remove(depIndex); //remove department from departments

                //write departments to csv
                bw.write(String.join(", ", departmentsString.stream().map(Object::toString).collect(Collectors.joining(", "))) +
                        System.lineSeparator());


                String line;
                int lineIndex = 0;
                while (lineIndex <= departmentsString.size()) {
                    line = br.readLine();
                    if (lineIndex != depIndex) { //Write line only if not the line containing deleted barcode
                        bw.write(line + System.lineSeparator());
                    }
                    lineIndex++;
                }

                bw.close();

            } else { //more than one barcode in department

                //remove barcode from map
                barcodes.get(department).remove(barcode);
                //write departments to csv
                bw.write(String.join(", ", departmentsString.stream().map(Object::toString).collect(Collectors.joining(", "))) +
                        System.lineSeparator());

                String line;
                int lineIndex = 0;
                while (lineIndex < departmentsString.size()) {
                    line = br.readLine();
                    if (lineIndex == depIndex) {
                        //store barcodes as arrayList
                        ArrayList<String> barcodesString = new ArrayList<String>(Arrays.asList(line.split(COMMA_DELIMITER)));
                        barcodesString.remove(barcode); //remove barcode from line
                        //write barcodes to csv
                        bw.write(String.join(", ", barcodesString.stream().map(Object::toString).collect(Collectors.joining(", "))) +
                                System.lineSeparator());

                    } else {
                        bw.write(line + System.lineSeparator());

                    }
                    lineIndex++;
                }
                bw.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        File original = new File(file);
        original.delete();
        new File(tempFileName).renameTo(original);


    }
}
