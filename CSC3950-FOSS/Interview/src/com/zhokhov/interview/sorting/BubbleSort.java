/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 */
package com.zhokhov.interview.sorting;

import static com.zhokhov.interview.util.Console.*;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class BubbleSort {

    private int COMPARISONS_COUNT;
    private int SWAPS_COUNT;
    private int LOOP_COUNT;

    public void sort(int[] array) {
        COMPARISONS_COUNT = 0;
        SWAPS_COUNT = 0;
        LOOP_COUNT = 0;

        for (int reverseIndex = array.length - 1; reverseIndex > 1; reverseIndex--) {
            LOOP_COUNT++;
           // ____grey("------\nreverseIndex: " + reverseIndex);
            System.out.println("------\nreverseIndex: " + reverseIndex);

            for (int i = 0; i < reverseIndex; i++) {
                LOOP_COUNT++;
               // ____grey("i: " + i);
                 System.out.println("i: " + i);
                COMPARISONS_COUNT++;

                if (array[i] > array[i + 1]) {
                    SWAPS_COUNT++;
                    //____blue("Swapping: " + i + " and " + (i + 1));
                    System.out.println("Swapping: " + i + " and " + (i + 1));
                    // Swap code
                    int temp = array[i];

                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    System.out.println("==> ");
                    __dump(array);
                    System.out.println("");
                }
            }
        }
    }

    //Katie - renamed this function since Menu.java is the new main
    public void BubbleStart() {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 6, 5, 3};

       // __yellow("\nNew array: ");
        System.out.println("\nNew array: ");
        __dump(array);

        System.out.println("\nSorting\n");

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);

         // __green("\nResult: "); 
      System.out.println("\nResult: ");
        __dump(array);

       //____grey("\nStatistics");
       System.out.println("\nStatistics");
       //__green("  Comparisons: ");
       System.out.print("  Comparisons: ");
       System.out.print(bubbleSort.COMPARISONS_COUNT);
       //__green("\n  Swaps: ");
       System.out.print("\n  Swaps: ");
       System.out.print(bubbleSort.SWAPS_COUNT);
       // __green("\n  Loops: ");
       System.out.print("\n  Loops: ");
       System.out.print(bubbleSort.LOOP_COUNT);
    }

}
