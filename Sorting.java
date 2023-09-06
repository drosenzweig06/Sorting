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
    private int x;

    /**
     * Constructor for objects of class Sorting
     */
    public void test()
    {
        int[] array1 = {5, 9, 13, 8, 4, 5};
        System.out.println(bubbleSorting(array1));
        System.out.println(InsertionSort(array1));
        mergeSort(array1);
        System.out.println(Arrays.toString(array1));
    }
    public String bubbleSorting(int[] array)
    {
        for(int i = 0; i < array.length - 1; i++)
        {
            for(int j = 0; j < array.length - 1; j++)
            {
                if(array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
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
    public void SelectionSort(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            int minlocation = array[i];
            for(int j = i+1; j < array.length; j++)
            {
                if(array[j] < minlocation)
                {
                    minlocation = j;
                }
            }
        }
    }
    public String InsertionSort(int[] array)
    {
        for(int i = 1; i < array.length; i++)
        {
        	int value = array[i];
        	int place = i - 1;
        	while(place > 0 && array[place]  > value)
        	{
        		array[place + 1] = array[place];
        		place--;
        	}
        	array[place + 1] = value;

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
                }
                else
                {
                    temp[i] = array[cursor2];
                    cursor2++;
                    i++;
                }
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
