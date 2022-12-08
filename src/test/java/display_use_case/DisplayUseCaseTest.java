package display_use_case;

import Screens.DisplayController;
import Screens.DisplayInventoryUpdater;
import Screens.InventoryViewModel;
import entities.InventoryItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class DisplayUseCaseTest {

    private final InventoryViewModel inventoryViewModel;

    private final DisplayController displayController;


    public DisplayUseCaseTest() {
        InventoryItem item1 = new InventoryItem("banana", "1", true, 10, 2,
                3, 5, "1", 10, 0);
        InventoryItem item2 = new InventoryItem("apple", "2", false, 1, 4,
                6, 11, "2", 6, 4);
        InventoryItem item3 = new InventoryItem("orange", "3", true, 7, 7,
                5, 6, "4", 4, 5);
        InventoryItem item4 = new InventoryItem("nectarine", "4", false, 12, 9,
                4, 9, "3", 2, 4);
        InventoryItem item5 = new InventoryItem("cookies", "5", true, 3, 3,
                2, 3, "1", 3, 2);
        InventoryItem item6 = new InventoryItem("bread", "6", false, 11, 1,
                1, 4, "3", 5, 8);
        InventoryItem item7 = new InventoryItem("banana", "7", true, 2, 4,
                8, 3, "1", 9, 9);
        InventoryItem item8 = new InventoryItem("computer", "8", true, 4, 1,
                6, 2, "1", 4, 7);
        InventoryItem item9 = new InventoryItem("mice", "9", false, 5, 6,
                9, 1, "1", 2, 6);
        InventoryItem item10 = new InventoryItem("bags", "10", true, 6, 4,
                4, 8, "1", 3, 8);

        ArrayList<InventoryItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);

        String[][] inventoryTable = new String[items.size()][7];
        for (int i = 0; i < items.size(); i++) {
            InventoryItem item = items.get(i);
            inventoryTable[i] = new String[]{item.getName(), item.getQuantity() + "", item.getBarcode(),
                    item.getBuyPrice() + "", item.getSellPrice() + "",
                    Integer.toString(item.getCaseQuantity()), item.getDepartment()};
        }
        this.inventoryViewModel = new InventoryViewModel(inventoryTable, new String[]{});
        DisplayPresenter displayPresenter = new DisplayInventoryUpdater();
        DisplayInputBoundary displayInteractor = new DisplayInteractor(displayPresenter);
        this.displayController = new DisplayController(displayInteractor);
    }

    @Test
    //Test the filter department feature with a variety of inputs.
    public void FilterDepartmentTest() {
        InventoryViewModel actual = this.displayController.create(this.inventoryViewModel,
                "filterDepartment", "1");
        InventoryViewModel actual2 = this.displayController.create(this.inventoryViewModel,
                "filterDepartment", "100");


        String[][] expected = new String[6][7];
        expected[0] = this.inventoryViewModel.getItemList()[0];
        expected[1] = this.inventoryViewModel.getItemList()[4];
        expected[2] = this.inventoryViewModel.getItemList()[6];
        expected[3] = this.inventoryViewModel.getItemList()[7];
        expected[4] = this.inventoryViewModel.getItemList()[8];
        expected[5] = this.inventoryViewModel.getItemList()[9];

        String[][] expected2 = new String[0][7];

        Assertions.assertArrayEquals(expected, actual.getItemList());
        Assertions.assertArrayEquals(expected2, actual2.getItemList());
    }


    @Test
    //Test the search feature with a variety of inputs.
    public void testSearch(){
        InventoryViewModel actual = this.displayController.create(this.inventoryViewModel,
                "searchResults", "Ba");
        InventoryViewModel actual2 = this.displayController.create(this.inventoryViewModel,
                "searchResults", "Apples.");
        InventoryViewModel actual3 = this.displayController.create(this.inventoryViewModel,
                "searchResults", "lkasjfdl;");


        String[][] expected = new String[3][7];
        expected[0] = this.inventoryViewModel.getItemList()[0];
        expected[1] = this.inventoryViewModel.getItemList()[6];
        expected[2] = this.inventoryViewModel.getItemList()[9];


        String[][] expected2 = new String[1][7];
        expected2[0] = this.inventoryViewModel.getItemList()[1];

        String[][] expected3 = new String[0][7];

        Assertions.assertArrayEquals(expected, actual.getItemList());
        Assertions.assertArrayEquals(expected2, actual2.getItemList());
        Assertions.assertArrayEquals(expected3, actual3.getItemList());
    }

    @Test
    //Test the sort quantity feature with a variety of inputs.
    public void testSortQuantity(){
        InventoryViewModel actual = this.displayController.create(this.inventoryViewModel,
                "sortQuantity", true);
        InventoryViewModel actual2 = this.displayController.create(this.inventoryViewModel,
                "sortQuantity", false);

        String[][] expected = new String[10][7];
        String[][] expected2 = new String[10][7];

        int[] indexes = {1, 6, 4, 7, 8, 9, 2, 0, 5, 3};
        int[] indexes2 = {3, 5, 0, 2, 9, 8, 7, 4, 6, 1};
        for(int i = 0; i<10; i++){
            expected[i] = this.inventoryViewModel.getItemList()[indexes[i]];
            expected2[i] = this.inventoryViewModel.getItemList()[indexes2[i]];
        }

        Assertions.assertArrayEquals(expected, actual.getItemList());
        Assertions.assertArrayEquals(expected2, actual2.getItemList());
    }

    @Test
    //Test the sort name feature with a variety of inputs.
    public void testSortName(){
        InventoryViewModel actual = this.displayController.create(this.inventoryViewModel,
                "sortName", true);
        InventoryViewModel actual2 = this.displayController.create(this.inventoryViewModel,
                "sortName", false);

        String[][] expected = new String[10][7];
        String[][] expected2 = new String[10][7];

        int[] indexes = {1, 9, 0, 6, 5, 7, 4, 8, 3, 2};
        int[] indexes2 = {2, 3, 8, 4, 7, 5, 0, 6, 9, 1};
        for(int i = 0; i<10; i++){
            expected[i] = this.inventoryViewModel.getItemList()[indexes[i]];
            expected2[i] = this.inventoryViewModel.getItemList()[indexes2[i]];
        }

        Assertions.assertArrayEquals(expected, actual.getItemList());
        Assertions.assertArrayEquals(expected2, actual2.getItemList());
    }

    @Test
    //Test the sort sell price feature with a variety of inputs.
    public void testSortSellPrice(){
        InventoryViewModel actual = this.displayController.create(this.inventoryViewModel,
                "sortSellPrice", true);
        InventoryViewModel actual2 = this.displayController.create(this.inventoryViewModel,
                "sortSellPrice", false);

        String[][] expected = new String[10][7];
        String[][] expected2 = new String[10][7];

        int[] indexes = {5, 4, 0, 3, 9, 2, 1, 7, 6, 8};
        int[] indexes2 = {8, 6, 1, 7, 2, 3, 9, 0, 4, 5};
        for(int i = 0; i<10; i++){
            expected[i] = this.inventoryViewModel.getItemList()[indexes[i]];
            expected2[i] = this.inventoryViewModel.getItemList()[indexes2[i]];
        }

        Assertions.assertArrayEquals(expected, actual.getItemList());
        Assertions.assertArrayEquals(expected2, actual2.getItemList());
    }

    @Test
    //Test the sort buy price feature with a variety of inputs.
    public void testSortBuyPrice(){
        InventoryViewModel actual = this.displayController.create(this.inventoryViewModel,
                "sortBuyPrice", true);
        InventoryViewModel actual2 = this.displayController.create(this.inventoryViewModel,
                "sortBuyPrice", false);

        String[][] expected = new String[10][7];
        String[][] expected2 = new String[10][7];

        int[] indexes = {5, 7, 0, 4, 1, 6, 9, 8, 2, 3};
        int[] indexes2 = {3, 2, 8, 1, 6, 9, 4, 0, 5, 7};
        for(int i = 0; i<10; i++){
            expected[i] = this.inventoryViewModel.getItemList()[indexes[i]];
            expected2[i] = this.inventoryViewModel.getItemList()[indexes2[i]];
        }

        Assertions.assertArrayEquals(expected, actual.getItemList());
        Assertions.assertArrayEquals(expected2, actual2.getItemList());
    }

    @Test
    //Test the sort barcode feature with a variety of inputs.
    public void testSortBarcode(){
        InventoryViewModel actual = this.displayController.create(this.inventoryViewModel,
                "sortBarcode", true);
        InventoryViewModel actual2 = this.displayController.create(this.inventoryViewModel,
                "sortBarcode", false);

        String[][] expected = new String[10][7];
        String[][] expected2 = new String[10][7];

        int[] indexes = {0, 9, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] indexes2 = {8, 7, 6, 5 ,4, 3, 2, 1, 9, 0};
        for(int i = 0; i<10; i++){
            expected[i] = this.inventoryViewModel.getItemList()[indexes[i]];
            expected2[i] = this.inventoryViewModel.getItemList()[indexes2[i]];
        }

        Assertions.assertArrayEquals(expected, actual.getItemList());
        Assertions.assertArrayEquals(expected2, actual2.getItemList());
    }

    @Test
    //Tests the sort case quantity with a variety of inputs
    public void testSortCaseQuantity(){
        InventoryViewModel actual = this.displayController.create(this.inventoryViewModel,
                "sortCaseQuantity", true);
        InventoryViewModel actual2 = this.displayController.create(this.inventoryViewModel,
                "sortCaseQuantity", false);

        String[][] expected = new String[10][7];
        String[][] expected2 = new String[10][7];

        int[] indexes = {8, 7, 4, 6, 5, 0, 2, 9, 3, 1};
        int[] indexes2 = {1, 3, 9, 2, 0, 5, 4, 6, 7, 8};
        for(int i = 0; i<10; i++){
            expected[i] = this.inventoryViewModel.getItemList()[indexes[i]];
            expected2[i] = this.inventoryViewModel.getItemList()[indexes2[i]];
        }

        Assertions.assertArrayEquals(expected, actual.getItemList());
        Assertions.assertArrayEquals(expected2, actual2.getItemList());
    }

}
