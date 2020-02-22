package Test;

import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShellTest {
    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ... 
        int h = 1;
        int hTemp[] = new int[100];
        hTemp[0] = 1;
        int count = 0;
        while (h < n/3){
        	h = 3*h + 1; 
        	hTemp[count++] = h;
        }
        int hArray[] = new int[count];
        for(int i=0;i<count;i++){
        	hArray[i] = hTemp[i];
        	System.out.print(hArray[i]+" ");
        }
        System.out.println();

        while (hArray[--count] >= 1) {
            // h-sort the array
            for (int i = hArray[count]; i < n; i++) {
                for (int j = i; j >= hArray[count] && less(a[j], a[j-hArray[count]]); j -= hArray[count]) {
                    exch(a, j, j-hArray[count]);
                }
            }
            assert isHsorted(a, hArray[count]); 
            
        }
        assert isSorted(a);
    }



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable<Comparable> v, Comparable w) {
        return v.compareTo(w) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    // is the array h-sorted?
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++)
            if (less(a[i], a[i-h])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; Shellsorts them; 
     * and prints them to standard output in ascending order. 
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Shell.sort(a);
        show(a);
    }
}
