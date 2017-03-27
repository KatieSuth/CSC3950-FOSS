/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.codenlearn.com/2011/07/simple-selection-sort.html
 */
package com.zhokhov.interview.sorting;

import static com.zhokhov.interview.util.Menu.*;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class SelectionSort {

    private int COMPARISONS_COUNT;
    private int SWAPS_COUNT;
    private int LOOP_COUNT;

    public void sort(int array[]) {
        COMPARISONS_COUNT = 0;
        SWAPS_COUNT = 0;
        LOOP_COUNT = 0;

        // Start from first
        for (int index = 0; index < array.length; index++) {
            LOOP_COUNT++;
             System.out.println("\n--------\nindex: " + index);


            // find the next smallest element
            int minIndex = findNextSmallestElement(index, array);

             System.out.println("found smallest element index: " + minIndex);

            SWAPS_COUNT++;
             System.out.println("Swapping: " + index + " and " + minIndex);

            // Swap code
            int temp = array[minIndex];

            array[minIndex] = array[index];
            array[index] = temp;

             System.out.println("==> ");
            __dump(array);
        }
    }

    /*
     * Finds the smallest element starting startIndex
     *
     * @ returns the index of the smallest element.
     */
    private int findNextSmallestElement(int startIndex, int array[]) {
        int minIndex = startIndex;

        int value = array[startIndex];

        for (int i = startIndex; i < array.length; i++) {
            LOOP_COUNT++;
            COMPARISONS_COUNT++;
            if (value > array[i]) {
                minIndex = i;
                value = array[minIndex];
            }
        }

        return minIndex;
    }

    //Katie - renamed this function since Menu.java is the new main
    public void SelectionStart() {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 6, 5, 3};

         System.out.println("\nNew array: ");
        __dump(array);

        System.out.println("\nSorting");

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);

         System.out.println("\nResult: ");
        __dump(array);

        System.out.println("\nStatistics");
        System.out.print("  Comparisons: ");
        System.out.print(selectionSort.COMPARISONS_COUNT);
        System.out.print("\n  Swaps: ");
        System.out.print(selectionSort.SWAPS_COUNT);
        System.out.print("\n  Loops: ");
        System.out.print(selectionSort.LOOP_COUNT);
    }

}
