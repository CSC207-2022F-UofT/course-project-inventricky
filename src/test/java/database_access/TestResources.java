package database_access;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestResources {

    //read line at index i in csv, given a non-empty csv, and check if it equals provided string
    public static boolean checkLineEquality(String file, String checkLine, int i) {

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            int lineIndex = 0;
            while((line = br.readLine()) != null){
                if (lineIndex == i) {
                    return line.equals(checkLine);
                } else {
                    lineIndex++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
