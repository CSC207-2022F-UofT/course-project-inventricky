package entities;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BarcodeManagerClean {

    private static final String COMMA_DELIMITER = ", ";

    public static HashMap<Integer, List<Integer>> readBarcodes(String file) {

        HashMap<Integer, List<Integer>> barcodeMap = new HashMap<>();

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
                String[] stringCodes = br.readLine().split(COMMA_DELIMITER); //get barcodes (string)
                ArrayList<Integer> intCodes = new ArrayList(); //create arrayList for storing barcodes (int)
                for (String stringCode : stringCodes) { //store barcodes in array
                    intCodes.add(Integer.parseInt(stringCode, 10)); //parseInt with base 10 to keep leading zeros
                }
                barcodeMap.put(Integer.parseInt(department, 10), intCodes); //but barcodes in barcode map
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return barcodeMap;
    }


    public static int generateBarcode(int department, HashMap<Integer, List<Integer>> barcodes, String file) {


        try {
            FileWriter fileWriter = new FileWriter("src/main/java/exports/testbarcodes.temp"); //create temporary csv file
            FileReader fileReader = new FileReader(file);

            BufferedWriter bw = new BufferedWriter(fileWriter);
            BufferedReader br = new BufferedReader(fileReader);

            //department in csv file
            if (barcodes.containsKey(department)) {
                int barcodeMax = Collections.max(barcodes.get(department)); //get max barcode
                barcodes.get(department).add(barcodeMax + 1); //add new barcode to csv

                bw.write(br.readLine() + System.lineSeparator()); //skip first line

                String line;
                while ((line = br.readLine()) != null) {
                    if (line.substring(0, 2).equals(String.format("%02d", department))) { //if department line reached, add barcode to line
                        bw.write(line + COMMA_DELIMITER + String.format("%05d", (barcodeMax + 1)) + System.lineSeparator());
                    } else {
                        bw.write(line + System.lineSeparator());
                    }

                }

                bw.close();
                File original = new File(file);
                original.delete();
                new File("src/main/java/exports/testbarcodes.temp").renameTo(original);
                return barcodeMax + 1;
            } else { //department not in csv file
                //case where csv is empty
                if (new File(file).length() == 0) {
                    bw.write(String.format("%02d", department) + System.lineSeparator());
                    bw.write(String.format("%02d", department) + "001" + System.lineSeparator());


                } else {

                    //store departments as arrayList
                    ArrayList<String> departmentsString = new ArrayList<String>(Arrays.asList(br.readLine().split(COMMA_DELIMITER)));


                    ArrayList<Integer> departmentsInt = new ArrayList<>(); //create arrayList for storing departments (int)
                    for (String depStr : departmentsString) { //store barcodes in array
                        departmentsInt.add(Integer.parseInt(depStr)); //add integer representation of strings to list
                    }
                    //Precondition: departmentsInt is sorted, department is not in departmentsInt
                    //returns (-index - 1), where index is the index where department should be inserted
                    int depIndex = Collections.binarySearch(departmentsInt, department);
                    depIndex = -depIndex - 1;
                    //add department to list of departments (int)
                    departmentsInt.add(depIndex, department);
                    departmentsString.add(depIndex, String.format("%02d", department));


                    bw.write(String.join(", ", departmentsString.stream().map(Object::toString).collect(Collectors.joining(", "))) +
                            System.lineSeparator()); //write departments to csv

                    String line;
                    int lineIndex = 0; //(line number) - 1
                    while (lineIndex < departmentsInt.size()) { //departmentsInt.size >= 2
                        line = br.readLine();
                        if (lineIndex == depIndex) {
                            bw.write(String.format("%02d", department) + "001" + System.lineSeparator());
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
                ArrayList<Integer> newCodes = new ArrayList();
                newCodes.add(department * 1000);
                barcodes.put(department, newCodes);

                bw.close();
                File original = new File(file);
                original.delete();
                new File("src/main/java/exports/testbarcodes.temp").renameTo(original);
                return department * 1000;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }


    }


    public static void removeBarcode(int barcode, HashMap<Integer, List<Integer>> barcodes, String file) {

        int department;
        //department 1-9
        if (Integer.toString(barcode).length() == 4) {
            department = Integer.parseInt(Integer.toString(barcode).substring(0, 1));
        } else { //department 10+
            department = Integer.parseInt(Integer.toString(barcode).substring(0, 2));
        }
        //remove barcode from map and csv


        try {
            FileWriter fileWriter = new FileWriter("src/main/java/exports/testbarcodes.temp"); //create temporary csv file
            FileReader fileReader = new FileReader(file);

            BufferedWriter bw = new BufferedWriter(fileWriter);
            BufferedReader br = new BufferedReader(fileReader);

            //store departments as arrayList
            ArrayList<String> departmentsString = new ArrayList<String>(Arrays.asList(br.readLine().split(COMMA_DELIMITER)));

            //get index of department with deleted barcode in csv
            String test = String.format("%02d", department);
            int depIndex = departmentsString.indexOf(String.format("%02d", department));

            //single barcode in department
            if (barcodes.get(department).size() == 1) {

                barcodes.remove(department); //remove key-value pair from map

                //case where only one department
                if (barcodes.isEmpty()) {

                    bw.close();
                    File original = new File(file);
                    original.delete();
                    new File("src/main/java/exports/testbarcodes.temp").renameTo(original);
                    return;

                }

                departmentsString.remove(depIndex); //remove department from departments

                //write departments to csv
                bw.write(String.join(", ", departmentsString.stream().map(Object::toString).collect(Collectors.joining(", "))) +
                        System.lineSeparator());


                String line;
                int lineIndex = 0;
                while (lineIndex < departmentsString.size() + 1) {
                    line = br.readLine();
                    if (lineIndex != depIndex) { //Write line only if not the line containing deleted barcode
                        bw.write(line + System.lineSeparator());
                    }
                    lineIndex++;
                }

                bw.close();

            } else { //more than one barcode in department

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
                        barcodesString.remove(String.format("%05d", barcode)); //remove barcode from line
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
        new File("src/main/java/exports/testbarcodes.temp").renameTo(original);


    }
}
