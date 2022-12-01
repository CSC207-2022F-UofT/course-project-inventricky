package entities;

import entities.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DisplayTest {

    private Inventory inventory;


    public DisplayTest(){
        Inventory inventory = new Inventory("Testing Inventory");
        InventoryItem item1 = new InventoryItem("banana", "1", true, 10, 2,
                3, 5, "1", 10, 0);
        InventoryItem item2 = new InventoryItem("apple", "2", false, 1, 4,
                6, 11, "2", 6, 4);
        InventoryItem item3 = new InventoryItem("orange", "3",true, 7, 7,
                5, 6, "4", 4, 5);
        InventoryItem item4 = new InventoryItem("nectarine", "4",false, 12, 9,
                4, 9, "3", 2, 4);
        InventoryItem item5 = new InventoryItem("cookies", "5",true, 3, 3,
                2, 3, "1", 3, 2);
        InventoryItem item6 = new InventoryItem("bread", "6",false, 11, 1,
                1, 4, "3", 5, 8);
        InventoryItem item7 = new InventoryItem("banana", "7",true, 2, 4,
                8, 3, "1", 9, 9);
        InventoryItem item8 = new InventoryItem("computer", "8",true, 4, 1,
                6, 2, "1", 4, 7);
        InventoryItem item9 = new InventoryItem("mice", "9",false, 5, 6,
                9, 1, "1", 2, 6);
        InventoryItem item10 = new InventoryItem("bags", "10",true, 6, 4,
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
        inventory.setItems(items);
        this.inventory = inventory;
    }

    @Test
    public void FilterDepartmentTest(){

        Filter filter = new Filter();

        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        expected.add(inventory.getItems().get(0));
        expected.add(inventory.getItems().get(4));
        expected.add(inventory.getItems().get(6));
        expected.add(inventory.getItems().get(7));
        expected.add(inventory.getItems().get(8));
        expected.add(inventory.getItems().get(9));
        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = filter.filterDepartment(inventory.getItems(), "1");
        ArrayList<InventoryItem> actual2 = new ArrayList<InventoryItem>();
        actual2 = filter.filterDepartment(inventory.getItems(), "100");

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        Assertions.assertArrayEquals(expected2.toArray(), actual2.toArray());
    }

    @Test
    public void testFilterByWeight(){
        Filter filter = new Filter();

        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        expected.add(inventory.getItems().get(0));
        expected.add(inventory.getItems().get(2));
        expected.add(inventory.getItems().get(4));
        expected.add(inventory.getItems().get(6));
        expected.add(inventory.getItems().get(7));
        expected.add(inventory.getItems().get(9));

        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();
        expected2.add(inventory.getItems().get(1));
        expected2.add(inventory.getItems().get(3));
        expected2.add(inventory.getItems().get(5));
        expected2.add(inventory.getItems().get(8));

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = filter.filterByWeight(inventory.getItems(), true);
        ArrayList<InventoryItem> actual2 = new ArrayList<InventoryItem>();
        actual2 = filter.filterByWeight(inventory.getItems(), false);

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        Assertions.assertArrayEquals(expected2.toArray(), actual2.toArray());
    }

    @Test
    public void testSearch(){
        Search search = new Search();

        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        expected.add(inventory.getItems().get(0));
        expected.add(inventory.getItems().get(6));
        expected.add(inventory.getItems().get(9));

        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();
        expected2.add(inventory.getItems().get(1));

        ArrayList<InventoryItem> expected3 = new ArrayList<InventoryItem>();

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = search.searchResults(inventory.getItems(), "Ba");
        ArrayList<InventoryItem> actual2 = new ArrayList<InventoryItem>();
        actual2 = search.searchResults(inventory.getItems(), "Apples.");
        ArrayList<InventoryItem> actual3 = new ArrayList<InventoryItem>();
        actual3 = search.searchResults(inventory.getItems(), "lkasjfdl;");

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        Assertions.assertArrayEquals(expected2.toArray(), actual2.toArray());
        Assertions.assertArrayEquals(expected3.toArray(), actual3.toArray());
    }

    @Test
    public void testSortQuantity(){
        Sort sort = new Sort();
        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        int[] indexes = {1, 6, 4, 7, 8, 9, 2, 0, 5, 3};
        for(int i = 0; i<10; i++){
            expected.add(inventory.getItems().get(indexes[i]));
        }
        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();
        int[] indexes2 = {3, 5, 0, 2, 9, 8, 7, 4, 6, 1};
        for(int i = 0; i<10; i++){
            expected2.add(inventory.getItems().get(indexes2[i]));
        }

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = sort.sortQuantity(inventory.getItems(), true);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        actual = sort.sortQuantity(inventory.getItems(), false);
        Assertions.assertArrayEquals(expected2.toArray(), actual.toArray());
    }

    @Test
    public void testSortName(){
        Sort sort = new Sort();
        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        int[] indexes = {1, 9, 0, 6, 5, 7, 4, 8, 3, 2};
        for(int i = 0; i<10; i++){
            expected.add(inventory.getItems().get(indexes[i]));
        }
        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();
        int[] indexes2 = {2, 3, 8, 4, 7, 5, 0, 6, 9, 1};
        for(int i = 0; i<10; i++){
            expected2.add(inventory.getItems().get(indexes2[i]));
        }

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = sort.sortName(inventory.getItems(), true);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        actual = sort.sortName(inventory.getItems(), false);
        Assertions.assertArrayEquals(expected2.toArray(), actual.toArray());
    }

    @Test
    public void testSortSellPrice(){
        Sort sort = new Sort();
        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        int[] indexes = {5, 4, 0, 3, 9, 2, 1, 7, 6, 8};
        for(int i = 0; i<10; i++){
            expected.add(inventory.getItems().get(indexes[i]));
        }
        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();
        int[] indexes2 = {8, 6, 1, 7, 2, 3, 9, 0, 4, 5};
        for(int i = 0; i<10; i++){
            expected2.add(inventory.getItems().get(indexes2[i]));
        }

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = sort.sortSellPrice(inventory.getItems(), true);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        actual = sort.sortSellPrice(inventory.getItems(), false);
        Assertions.assertArrayEquals(expected2.toArray(), actual.toArray());
    }

    @Test
    public void testSortBuyPrice(){
        Sort sort = new Sort();
        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        int[] indexes = {5, 7, 0, 4, 1, 6, 9, 8, 2, 3};
        for(int i = 0; i<10; i++){
            expected.add(inventory.getItems().get(indexes[i]));
        }
        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();
        int[] indexes2 = {3, 2, 8, 1, 6, 9, 4, 0, 5, 7};
        for(int i = 0; i<10; i++){
            expected2.add(inventory.getItems().get(indexes2[i]));
        }

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = sort.sortBuyPrice(inventory.getItems(), true);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        actual = sort.sortBuyPrice(inventory.getItems(), false);
        Assertions.assertArrayEquals(expected2.toArray(), actual.toArray());
    }

    @Test
    public void testSortBarcode(){
        Sort sort = new Sort();
        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        int[] indexes = {0, 9, 1, 2, 3, 4, 5, 6, 7, 8};
        for(int i = 0; i<10; i++){
            expected.add(inventory.getItems().get(indexes[i]));
        }
        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();
        int[] indexes2 = {8, 7, 6, 5 ,4, 3, 2, 1, 9, 0};
        for(int i = 0; i<10; i++){
            expected2.add(inventory.getItems().get(indexes2[i]));
        }

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = sort.sortBarcode(inventory.getItems(), true);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        actual = sort.sortBarcode(inventory.getItems(), false);
        Assertions.assertArrayEquals(expected2.toArray(), actual.toArray());
    }

    @Test
    public void testSortCaseQuantity(){
        Sort sort = new Sort();
        ArrayList<InventoryItem> expected = new ArrayList<InventoryItem>();
        int[] indexes = {8, 7, 4, 6, 5, 0, 2, 9, 3, 1};
        for(int i = 0; i<10; i++){
            expected.add(inventory.getItems().get(indexes[i]));
        }
        ArrayList<InventoryItem> expected2 = new ArrayList<InventoryItem>();
        int[] indexes2 = {1, 3, 9, 2, 0, 5, 4, 6, 7, 8};
        for(int i = 0; i<10; i++){
            expected2.add(inventory.getItems().get(indexes2[i]));
        }

        ArrayList<InventoryItem> actual = new ArrayList<InventoryItem>();
        actual = sort.sortCaseQuantity(inventory.getItems(), true);
        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
        actual = sort.sortCaseQuantity(inventory.getItems(), false);
        Assertions.assertArrayEquals(expected2.toArray(), actual.toArray());
    }
}




