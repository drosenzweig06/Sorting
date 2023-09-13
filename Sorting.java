import java.util.*;
/**
 * This contains four sorting algorithms(bubble sort, insertion sort, merge sort,
 * and selection sort). Each of these algorithms contains one method(besides merge sort)
 * along with a testing method that tests each algorithm. This class contains two instance
 * variables that count the amount of swaps and comparisons in each sorting algorithm.
 *
 * -Daniel Rosenzweig
 */

public class Sorting
{
    private static long countComp = 0;
    private static long countSwap = 0;
    
    // Test the mergeSort method to check if the sort works
    public static void test() {
        int[] array1 = {5, 9, 13, 8, 4, 5};
        mergeSort(array1);
        System.out.println(Arrays.toString(array1));
    }
    
    // Sorts the passed in int array using the bubble sort algorithm
    public static void bubbleSort(int[] array) {
        long countSwap = 0;
        long countComp = 0;
        
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                countComp++;
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    countSwap++;
                }
            }
        }
        System.out.print("," + countComp + "," + countSwap);
    }

    /**
     * Sorts the passed in int array using the selection sort algorithm
     */
    public static void selectionSort(int[] array) {
        long countSwap = 0;
        long countComp = 0;
        
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minlocation = i;
            for (int j = i + 1; j < array.length; j++) {
                countComp++;
                if (array[j] < min) {
                    min = array[j];
                    minlocation = j;
                }
            }
            int temp = array[i];
            array[i] = array[minlocation];
            array[minlocation] = temp;
            countSwap++;
        }
        System.out.print("," + countComp + "," + countSwap);

    }
    
    /**
     * Sorts the passed in int array using the insertion sort algorithm
     */
    public static void insertionSort(int[] array) {
        long countSwap = 0;
        long countComp = 0;
        
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int place = i;
            countSwap++;
            while (place > 0 && array[place-1] > value) {
                array[place] = array[place-1];
                place--;
                countComp++;
                countSwap++;
            }
            array[place] = value;
            countSwap++;
        }
        countSwap = countSwap/3;
        System.out.print("," + countComp + "," + countSwap);
    }
    
    /**
     * Sorts the passed in int array using the selection sort algorithm
     */
    public static void mergeSort(int[] array) {
        mergeSort(0, array.length - 1, array);
        System.out.print("," + countComp + "," + countSwap);
    }
    
    public static void mergeSort(int beg, int end, int[] array) {
        if (beg == end){ // base case for recursion
            return;
        } else {         // recursive case
            int midpoint = (beg + end) / 2;
            mergeSort(beg, midpoint, array);
            mergeSort(midpoint + 1, end, array);
            merge(beg, midpoint, end, array);
        }
    }
    
    /**
     * Sorts using the passed in int array, index of the beginning, index of the middle,
     * and index of the end using the merge sort algorithm
     */
    public static void merge(int beg, int mid, int end, int[] array) {
        int cursor1 = beg;
        int cursor2 = mid + 1;
        int[] temp = new int[(end - beg) + 1];
        int i = 0;
        
        // runs through both halves of the array simultaneuosly
        while (cursor1 <= mid && cursor2 <= end) {
                countComp++;
                if (array[cursor1] < array[cursor2]) {
                    temp[i] = array[cursor1];
                    cursor1++;
                    i++;
                    countSwap++;
                } else {
                    temp[i] = array[cursor2];
                    cursor2++;
                    i++;
                    countSwap++;
                }
        }
        
        // Takes whats left of the first array and add it to the new arrray
        while (cursor1 <= mid) {
              temp[i] = array[cursor1];
              cursor1++;
              i++;
              countSwap++;
        }
        
        // Takes whats left of the second array and add it to the new arrray
        while (cursor2 <= end) {
            temp[i] = array[cursor2];
            cursor2++;
            i++;
            countSwap++;
        }
        for (int k = 0; k < temp.length; k++) {
            array[beg + k] = temp[k];
            countSwap++;
        }
        countSwap = countSwap / 3;
    }
}
