import java.util.*;
/**
 * Write a description of class Sorting here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortingBenchmark
{
    public String bubbleSorting(int[] array)
    {
        int countswap = 0;
        int countcomp = 0;
        for(int i = 0; i < array.length - 1; i++)
        {
            for(int j = 0; j < array.length - 1; j++)
            {
                if(array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    countcomp++;
                    countswap++;
                }
            }
        }
        String Stringarray = Arrays.toString(array);
        return Stringarray;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String SelectionSort(int[] array)
    {
        int countswap = 0;
        int countcomp = 0;
        for(int i = 0; i < array.length - 1; i++)
        {
            int min = array[i];
            int minlocation = i;
            for(int j = i+1; j < array.length; j++)
            {
                if(array[j] < min)
                {
                    min = array[j];
                    minlocation = j;
                    countcomp++;
                }
            }
            int temp = array[i];
            array[i] = array[minlocation];
            array[minlocation] = temp;
            countswap++;
        }
        String Stringarray = Arrays.toString(array);
        return Stringarray;

    }
    public String InsertionSort(int[] array)
    {
        int countswap = 0;
        int countcomp = 0;
        for(int i = 1; i < array.length; i++)
        {
            int value = array[i];
            int place = i - 1;
            while(place > 0 && array[place]  > value)
            {
                array[place + 1] = array[place];
                place--;
                countcomp++;
            }
            array[place + 1] = value;
            countswap++;
        }
        String Stringarray = Arrays.toString(array);
        return Stringarray;

    }
    public void mergeSort(int[] array)
    {
        mergeSort(0, array.length-1, array);
    }
    public void mergeSort(int beg,int end, int[] array)
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
    public void merge(int beg,int mid,int end, int[] array)
    {
        int countswap = 0;
        int countcomp = 0;
        int cursor1 = beg;
        int cursor2 = mid + 1;
        int[] temp = new int[(end - beg)+1];
        int i = 0;
        while(cursor1 <= mid && cursor2 <= end)
        {
                if(array[cursor1] < array[cursor2])
                {
                    temp[i] = array[cursor1];
                    cursor1++;
                    i++;
                    countcomp++;
                }
                else
                {
                    temp[i] = array[cursor2];
                    cursor2++;
                    i++;
                    countcomp++;
                }
                countswap++;
        }
        while(cursor1 <= mid)
        {
              temp[i] = array[cursor1];
              cursor1++;
              i++;
        }
        while(cursor2 <= end)
        {
            temp[i] = array[cursor2];
            cursor2++;
            i++;
        }
    }
}

