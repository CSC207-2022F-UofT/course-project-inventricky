
import entities.*;
import useCases.UpdateItemQuantity;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        HashMap m = BarcodeMapReader.readBarcodes("src/main/java/exports/testbarcodes.csv");
        //BarcodeGenerator.generateBarcode("01", m, "src/main/java/exports/testbarcodes.csv");
        BarcodeRemover.removeBarcode("11002", m, "src/main/java/exports/testbarcodes.csv");
        System.out.println(m);
        InventoryItem banana = new InventoryItem("banana", "123" ,
                true,
                0.6,
                0.54,
                0.88,
                100,
                "12",
                100,
                200);
//        UpdateItemQuantity.updateQty(banana, 1.43, "bought");
//        UpdateItemQuantity.updateQty(banana, 1.1, "sold");
//        UpdateItemQuantity.updateQty(banana, 0.1, "error");


        System.out.println(banana.getItemHistory());
//        new InventoryItem("banana",
//                true,
//                0.6,
//                0.54,
//                0.88,
//                100,
//                13,
//                100,
//                200);
//        System.out.println(Integer.parseInt("01001"));
//        System.out.println(Integer.toString(Integer.parseInt("01001", 10)));
//        String[] a = new String[3];
//        a[0] = "1";
//        a[1] = "2";
//        a[2] = "3";
//        System.out.println(String.join(", ", a));
    }
}
