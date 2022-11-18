import entities.BarcodeGenerator;
import entities.BarcodeGenerator2;
import entities.BarcodeManagerClean;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        HashMap m = BarcodeGenerator.readBarcodes("src/main/java/exports/testbarcodes.csv");
        BarcodeManagerClean.generateBarcode(11, m, "src/main/java/exports/testbarcodes.csv");
        System.out.println(m);
//        System.out.println(Integer.parseInt("01001"));
//        System.out.println(Integer.toString(Integer.parseInt("01001", 10)));
//        String[] a = new String[3];
//        a[0] = "1";
//        a[1] = "2";
//        a[2] = "3";
//        System.out.println(String.join(", ", a));
    }
}
