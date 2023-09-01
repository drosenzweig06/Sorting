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
                if(minlocation > array[j])
                {
                    minlocation = j;
                }
            }
            
        }

    }
    
    public void InsertionSort(int[] array)
    {
        
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
        int curser1 = beg;
        int curser2 = mid + 1;
        int[] temp = array;
        while(curser1 < mid+1 || curser2 < end+1)
        {
                if(temp[curser1] > temp[curser2])
                {
                    array[i] = array[curser2];
                    curser2 += 1;
                }
                else if(temp[curser1] < temp[curser2])
                {
                    array[i] = array[curser1];
                    curser1 += 1;
                }
        
        }
        
    }
}
