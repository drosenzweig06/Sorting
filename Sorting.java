import java.util.*;
/**
 * Write a description of class Sorting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorting
{
    // instance variables - replace the example below with your own
    private static long countswap = 0;
    private static long countcomp = 0;

    /**
     * Constructor for objects of class Sorting
     */
    public static void test()
    {
        int[] array1 = {5, 9, 13, 8, 4, 5};
        mergeSort(array1);
        System.out.println(Arrays.toString(array1));
    }
    public static void bubbleSort(int[] array)
    {
        long countswap = 0;
        long countcomp = 0;
        for(int i = 0; i < array.length - 1; i++)
        {
            for(int j = 0; j < array.length - 1; j++)
            {
                countcomp++;
                if(array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    countswap++;
                }
            }
        }
        System.out.print("," + countcomp + "," + countswap);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void selectionSort(int[] array)
    {
        long countswap = 0;
        long countcomp = 0;
        for(int i = 0; i < array.length - 1; i++)
        {
            int min = array[i];
            int minlocation = i;
            for(int j = i+1; j < array.length; j++)
            {
                countcomp++;
                if(array[j] < min)
                {
                    min = array[j];
                    minlocation = j;
                }
            }
            int temp = array[i];
            array[i] = array[minlocation];
            array[minlocation] = temp;
            countswap++;
        }
        System.out.print("," + countcomp + "," + countswap);

    }
    public static void insertionSort(int[] array)
    {
        long countswap = 0;
        long countcomp = 0;
        for(int i = 1; i < array.length; i++)
        {
            int value = array[i];
            int place = i;
            countswap++;
            while(place > 0 && array[place-1] > value)
            {
                array[place] = array[place-1];
                place--;
                countcomp++;
                countswap++;
            }
            array[place] = value;
            countswap++;
        }
        countswap = countswap/3;
        System.out.print("," + countcomp + "," + countswap);
    }
    public static void mergeSort(int[] array)
    {
        mergeSort(0, array.length-1, array);
        System.out.print("," + countcomp + "," + countswap);
    }
    public static void mergeSort(int beg,int end, int[] array)
    {
        if(beg == end)
        {
            return;
        }
        else
        {
            int midpoint = (beg+end)/2;
            mergeSort(beg, midpoint, array);
            mergeSort(midpoint+1, end, array);
            merge(beg, midpoint, end, array);
        }
    }
    public static void merge(int beg,int mid,int end, int[] array)
    {
        int cursor1 = beg;
        int cursor2 = mid + 1;
        int[] temp = new int[(end - beg)+1];
        int i = 0;
        while(cursor1 <= mid && cursor2 <= end)
        {
                countcomp++;
                if(array[cursor1] < array[cursor2])
                {
                    temp[i] = array[cursor1];
                    cursor1++;
                    i++;
                    countswap++;
                }
                else
                {
                    temp[i] = array[cursor2];
                    cursor2++;
                    i++;
                    countswap++;
                }
        }
        while(cursor1 <= mid)
        {
              temp[i] = array[cursor1];
              cursor1++;
              i++;
              countswap++;
        }
        while(cursor2 <= end)
        {
            temp[i] = array[cursor2];
            cursor2++;
            i++;
            countswap++;
        }
        for(int k = 0; k < temp.length; k++)
        {
            array[beg + k] = temp[k];
            countswap++;
        }
        countswap = countswap/3;
    }
}
