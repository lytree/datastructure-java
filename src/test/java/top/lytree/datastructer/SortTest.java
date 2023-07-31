package top.lytree.datastructer;

import org.junit.jupiter.api.Test;
import top.lytree.datastructure.SortingAlgorithm;
import top.lytree.lang.RandomUtils;

import java.util.Arrays;

public class SortTest {
    public int[] getNumArray() {
        return RandomUtils.randomInts(10);
    }

    @Test
    public void selectSort() {
        int[] numArray = getNumArray();
        System.out.println(Arrays.toString(numArray));
        int[] sort = SortingAlgorithm.selectSort(numArray);
        System.out.println(Arrays.toString(sort));
    }

    @Test
    public void bubbleSort() {
        int[] numArray = getNumArray();
        System.out.println(Arrays.toString(numArray));
        int[] sort = SortingAlgorithm.bubbleSort(numArray);
        System.out.println(Arrays.toString(sort));
    }

    @Test
    public void insertionSort() {
        int[] numArray = getNumArray();
        System.out.println(Arrays.toString(numArray));
        int[] sort = SortingAlgorithm.insertionSort(numArray);
        System.out.println(Arrays.toString(sort));
    }

    @Test
    public void quickSort() {
        int[] numArray = getNumArray();
        System.out.println(Arrays.toString(numArray));
        int[] sort = SortingAlgorithm.quickSort(numArray);
        System.out.println(Arrays.toString(sort));
    }
}
