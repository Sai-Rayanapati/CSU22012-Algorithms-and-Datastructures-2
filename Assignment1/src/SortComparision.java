import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

class SortComparison {

    /**
     * Checks if the array is empty
     */

    static boolean isEmpty(double[] a)
    {
        if(a==null)
        {
            return true;
        }
        else return false;
    }

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
        //todo: implement the sort
        if(isEmpty(a))
        {
            return null;
        }
        for(int i=1; i<a.length; i++)
        {
            for(int j=i;j>0;j--)
            {
                if(a[j]<a[j-1])
                {
                    double temp = a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }
            }
        }

        return a;
    }//end insertionsort

    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){
        //todo: implement the sort
        if(isEmpty(a))
        {
            return null;
        }
        for(int i=0; i<a.length-1; i++)
        {
            int minIndex=i;
            for(int j=i+1;j<a.length;j++)
            {
                if(a[j]<a[minIndex])
                {
                    minIndex=j;
                }
            }
            double temp= a[minIndex];
            a[minIndex]=a[i];
            a[i]=temp;
        }
        return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
        //todo: implement the sort
        if(isEmpty(a))
        {
            return null;
        }
        recursiveQuick(a, 0, a.length-1);
        return a;
    }//end quicksort

    private static void recursiveQuick(double[] a, int lo, int hi)
    {
//        int pivotPosition = partition(a,lo,hi);
//        if(lo<pivotPosition-1)
//            recursiveQuick(a,lo,pivotPosition-1);
//        if(hi>pivotPosition)
//            recursiveQuick(a,pivotPosition,hi);
        if(lo<hi)
        {
            int pivotPosition= partition(a,lo,hi);
            recursiveQuick(a,lo,pivotPosition-1);
            recursiveQuick(a,pivotPosition,hi);
        }
    }


    private static int partition(double [] a, int lo, int hi)
    {
//        double pivot=a[lo];
//        while (lo<=hi)
//        {
//            while (a[lo] < pivot)
//                lo++;
//            while (a[hi] > pivot)
//                hi--;
//
//            if (lo <= hi) {
//                double temp = a[lo];
//                a[lo] = a[hi];
//                a[hi] = temp;
//
//                lo++;
//                hi--;
//            }
//        }
//        return lo;
        double pivot=a[hi];
        int i= lo-1;
        for(int j=lo;j<hi;j++)
        {
            if(a[j]<=pivot)
            {
                i++;
                double temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        return i+1;
    }
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */

    static double [] mergeSort (double a[]){
        if(isEmpty(a))
        {
            return null;
        }
        int length = a.length;
        double [] array= new double[length];
        sort (a , array, 0 , length-1);
        return a;
    }

    private static void sort(double [] a, double [] array, int lo, int hi)
    {
        if(hi<=lo)
            return;
        int mid= lo + (hi - lo)/2;
        sort(a,array, lo, mid);
        sort(a, array,mid+1,hi);
        merge(a,array,lo,mid, hi);
    }

    private static void merge(double [] a, double [] array, int lo ,int mid, int hi)
    {
        for(int k = lo; k <= hi; k++)
        {
            array[k] = a[k];
        }
        int i= lo, j=mid+1;
        for (int k=lo; k<=hi;k++)
        {
            if(i>mid)
                a[k]=array[j++];
            else if(j>hi)
                a[k]=array[i++];
            else if(array[j]<array[i])
                a[k]=array[j++];
            else
                a[k]=array[i++];
        }
    }

    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double [] mergeSortIterative (double a[]){
        if(isEmpty(a))
        {
            return null;
        }
        sortIterative (a);
        return a;
    }

    private static void sortIterative(double [] a)
    {
        int length=a.length;
        double[] array= new double[length];
        for (int i=1;i<length; i=i+i)
            for(int lo=0;lo<length-i;lo+=i+i)
                merge(a,array,lo,lo+i-1,Math.min(lo+i+i-1, length-1));
    }

     static double[] fileToArray(int length,String name) throws IOException {
        double[] a = new double[length];
        String currentLine;
        int index=0;
        BufferedReader numbers = new BufferedReader(new FileReader(name));
        while ((currentLine = numbers.readLine()) != null && index< length) {
            a[index] = Double.parseDouble(currentLine);
            index++;
        }
        return a;
    }

    static void insertionSorttime(double [] a) {
        DecimalFormat df = new DecimalFormat("#.##");
        double start, end, duration, durationAverage = 0;

        for (int i = 0; i < 3; i++) {
            start = System.nanoTime();
            insertionSort(a);
            end = System.nanoTime();
            duration = (end - start) / 1000000;
            durationAverage = durationAverage + duration;
        }
        durationAverage = durationAverage / 3;
        System.out.println("Insertion sort: " + df.format(durationAverage) + " micro seconds");
    }
    static void selectionSorttime(double [] a)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        double start, end, duration, durationAverage = 0;
        durationAverage = 0;
        for (int i = 0; i < 3; i++) {
            start = System.nanoTime();
            selectionSort(a);
            end = System.nanoTime();
            duration = (end - start) / 1000000;
            durationAverage = durationAverage + duration;
        }
        durationAverage = durationAverage / 3;
        System.out.println("Selection sort: " + df.format(durationAverage) + " micro seconds");
    }
    static void mergeSorttime(double [] a)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        double start, end, duration, durationAverage = 0;

        durationAverage = 0;
        for (int i = 0; i < 3; i++) {
            start = System.nanoTime();
            mergeSort(a);
            end = System.nanoTime();
            duration = (end - start) / 1000000;
            durationAverage = durationAverage + duration;
        }
        durationAverage = durationAverage / 3;
        System.out.println("merge sort: " + df.format(durationAverage) + " micro seconds");
    }
    static void quickSorttime(double [] a) {
        DecimalFormat df = new DecimalFormat("#.##");
        double start, end, duration, durationAverage = 0;
        durationAverage=0;
        for(int i = 0; i < 3; i++)
        {
            start = System.nanoTime();
            quickSort(a);
            end = System.nanoTime();
            duration = (end - start)/ 1000000 ;
            durationAverage= durationAverage+duration;
        }
        durationAverage=durationAverage/3;
        System.out.println("quick sort: " + df.format(durationAverage)+ " micro seconds");
        System.out.println();

    }

    public static void main(String[] args) throws IOException {

        //todo: do experiments as per assignment instructions

        double[] a;

        // 100 random numbers
        System.out.print("| 100 random          | ");
        System.out.println();
        a=fileToArray(100,"/Users/subbu/Desktop/Coding/Java workspace/Assignment1/src/numbers1000Duplicates.txt");
        insertionSorttime(a);
        selectionSorttime(a);
        mergeSorttime(a);
        quickSorttime(a);

        // 1000 random numbers
        System.out.print("| 1000 random         | ");
        System.out.println();
        a=fileToArray(1000,"/Users/subbu/Desktop/Coding/Java workspace/Assignment1/src/numbers1000.txt");
        insertionSorttime(a);
        selectionSorttime(a);
        mergeSorttime(a);
        quickSorttime(a);

        // 1000 unique numbers
        System.out.print("| 1000 unique         | ");
        System.out.println();
        a=fileToArray(1000,"/Users/subbu/Desktop/Coding/Java workspace/Assignment1/src/numbers1000Duplicates.txt");
        insertionSorttime(a);
        selectionSorttime(a);
        mergeSorttime(a);
        quickSorttime(a);

        // 1000 nearly ordered numbers
        System.out.print("| 1000 nearly ordered | ");
        System.out.println();
        a=fileToArray(1000,"/Users/subbu/Desktop/Coding/Java workspace/Assignment1/src/numbersNearlyOrdered1000.txt");
        insertionSorttime(a);
        selectionSorttime(a);
        mergeSorttime(a);
        quickSorttime(a);

        // 1000 reverse numbers
        System.out.print("| 1000 reverse        | ");
        System.out.println();
        a=fileToArray(1000,"/Users/subbu/Desktop/Coding/Java workspace/Assignment1/src/numbersReverse1000.txt");
        insertionSorttime(a);
        selectionSorttime(a);
        mergeSorttime(a);
        quickSorttime(a);

        // 1000 sorted numbers
        System.out.print("| 1000 sorted         | ");
        System.out.println();
        a=fileToArray(1000,"/Users/subbu/Desktop/Coding/Java workspace/Assignment1/src/numbersSorted1000.txt");
        insertionSorttime(a);
        selectionSorttime(a);
        mergeSorttime(a);
        quickSorttime(a);

        // 10000 random numbers
        System.out.print("| 10000 random        | ");
        System.out.println();
        a=fileToArray(10000,"/Users/subbu/Desktop/Coding/Java workspace/Assignment1/src/numbers10000.txt");
        insertionSorttime(a);
        selectionSorttime(a);
        mergeSorttime(a);
        quickSorttime(a);
    }
}//end class