package database_access;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BarcodeGenerator {

    private static final String COMMA_DELIMITER = ", ";

    /**
     *  Generates a barcode based on department number. Stores
     *  department and barcode mapping in a map and csv file. Item must not be in the inventory.
     *  Should be called only when InventoryItem constructed.
     *
     * @param department        String representation of department number of item.
     * @param barcodes          Current barcode mapping of item
     * @param file              Filepath of csv to store barcode map
     * @return                  String representation of barcode of item
     */
    public static String generateBarcode(String department, HashMap<String, List<String>> barcodes, String file) {


        try {
            String tempFileName = file.substring(0, file.lastIndexOf('.')) + ".temp";
            FileWriter fileWriter = new FileWriter(tempFileName); //create temporary csv file
            FileReader fileReader = new FileReader(file);

            BufferedWriter bw = new BufferedWriter(fileWriter);
            BufferedReader br = new BufferedReader(fileReader);

            //department in csv file
            if (barcodes.containsKey(department)) {
                ArrayList<Integer> departmentsInt = new ArrayList<>(); //create arrayList for storing departments (int)
                for(int i = 0; i < barcodes.get(department).size(); i++) {
                    departmentsInt.add(Integer.parseInt(barcodes.get(department).get(i)));
                }
                int barcodeMax = Collections.max(departmentsInt); //get max barcode
                barcodes.get(department).add(String.format("%05d", (barcodeMax + 1))); //add new barcode to map

                bw.write(br.readLine() + System.lineSeparator()); //skip first line

                String line;
                while ((line = br.readLine()) != null) {
                    if (line.substring(0, 2).equals(department)) { //if department line reached, add barcode to line
                        bw.write(line + COMMA_DELIMITER + String.format("%05d", (barcodeMax + 1)) + System.lineSeparator());
                    } else {
                        bw.write(line + System.lineSeparator());
                    }

                }

                bw.close();
                File original = new File(file);
                original.delete();
                new File(tempFileName).renameTo(original);
                return String.format("%05d", barcodeMax + 1);
            } else { //department not in csv file
                //case where csv is empty
                if (new File(file).length() == 0) {
                    bw.write(department + System.lineSeparator());
                    bw.write(department + "000" + System.lineSeparator());


                } else {

                    //store departments as arrayList
                    ArrayList<String> departmentsString = new ArrayList<>(Arrays.asList(br.readLine().split(COMMA_DELIMITER)));


                    ArrayList<Integer> departmentsInt = new ArrayList<>(); //create arrayList for storing departments (int)
                    for (String depStr : departmentsString) { //store barcodes in array
                        departmentsInt.add(Integer.parseInt(depStr)); //add integer representation of strings to list
                    }
                    //Precondition: departmentsInt is sorted, department is not in departmentsInt
                    //returns (-index - 1), where index is the index where department should be inserted
                    int depIndex = Collections.binarySearch(departmentsInt, Integer.parseInt(department));
                    depIndex = -depIndex - 1;
                    //add department to list of departments (int)
                    departmentsInt.add(depIndex, Integer.parseInt(department));
                    departmentsString.add(depIndex, String.format(department));


                    bw.write(String.join(", ", departmentsString.stream().map(Object::toString).collect(Collectors.joining(", "))) +
                            System.lineSeparator()); //write departments to csv

                    String line;
                    int lineIndex = 0; //(line number) - 1
                    while (lineIndex < departmentsInt.size()) { //departmentsInt.size >= 2
                        line = br.readLine();
                        if (lineIndex == depIndex) {
                            bw.write(department + "000" + System.lineSeparator());
                            if (line != null) {
                                bw.write(line + System.lineSeparator());
                            }
                            lineIndex += 2;
                        } else {
                            bw.write(line + System.lineSeparator());
                            lineIndex++;
                        }
                    }


                }

                //add department to barcodeMap
                ArrayList<String> newCodes = new ArrayList<>();
                newCodes.add(department + "000");
                barcodes.put(department, newCodes);

                bw.close();
                File original = new File(file);
                original.delete();
                new File(tempFileName).renameTo(original);
                return department + "000";
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }


    }
}

