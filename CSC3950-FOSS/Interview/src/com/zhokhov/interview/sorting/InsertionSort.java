/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.codenlearn.com/2011/07/simple-insertion-sort.html
 */
package com.zhokhov.interview.sorting;

import static com.zhokhov.interview.util.Console.*;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class InsertionSort {

    private int COMPARISONS_COUNT;
    private int LOOP_COUNT;

    public void sort(int array[]) {
        COMPARISONS_COUNT = 0;
        LOOP_COUNT = 0;

        // Ignore the first element [0]
        // start from the element [1] -- Get that element and insert
        for (int index = 1; index < array.length; index++) {
            LOOP_COUNT++;
             System.out.println("\n--------\nindex: " + index);

            insert(array, index);
        }
    }

    private void insert(int array[], int currentIndex) {
        // value of the element to be inserted
        int value = array[currentIndex];

         System.out.println("value: " + value);
         System.out.println("currentIndex: " + currentIndex);

        // iterate in the loop for all elements below the currentIndex
        int reverseIndex = currentIndex;

         System.out.println("reverseIndex: " + reverseIndex);

        for (int i = currentIndex - 1; i >= 0; i--) {
            LOOP_COUNT++;
             System.out.println("\ni: " + i);

            COMPARISONS_COUNT++;
            // If the array element is  greater than the value
            // move the array element to the next higher index
            if (array[i] >= value) {
                 System.out.println("Move element " + array[i] + " to position " + (i + 1));
                 System.out.println("new reverseIndex: " + i);

                array[i + 1] = array[i];
                reverseIndex = i;

                System.out.print("[" + value + "]");
                 System.out.println(" ==> ");
                __dump(array);
            } else {
                 System.out.println("breaking");

                break;
            }
        }

         System.out.println("\nreverseIndex (after loop): " + reverseIndex + ", put value here");

        array[reverseIndex] = value;

         System.out.println("==> ");
        __dump(array);
    }

    /*
     * A sample merge method to help understand the insert routine.
     * This below function is not used by the insertion sort.
     *
     * This is here only for explanation purpose.
     */
    private void sampleInsert(int array[], int value) {
         System.out.println("value: " + value);

        int reverseIndex = array.length - 1;

         System.out.println("reverseIndex: " + reverseIndex);

        // start the loop from last element
        for (int i = array.length - 2; i >= 0; i--) {
             System.out.println("\ni: " + i);

            // If the array element is greater than the value
            // move the array element to the next index
            // i.e one level higher on the index.
            if (array[i] >= value) {
                 System.out.println("Move element to: " + (i + 1));
                 System.out.println("new reverseIndex: " + i);

                array[i + 1] = array[i];
                reverseIndex = i;
            } else {
                 System.out.println("breaking");

                break;
            }
        }

         System.out.println("\nreverseIndex (after loop): " + reverseIndex + ", put value here");

        array[reverseIndex] = value;
    }

    public static void main(String[] args) {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 7, 5, 3};

         System.out.println("\nNew array: ");
        __dump(array);

        System.out.println("\nSorting");

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(array);

         System.out.println("\nResult: ");
        __dump(array);

         System.out.println("\nStatistics");
         System.out.println("  Comparisons: ");
        System.out.print(insertionSort.COMPARISONS_COUNT);
         System.out.println("\n  Loops: ");
        System.out.println(insertionSort.LOOP_COUNT);

        System.out.print("\n");
        System.out.println("***********************\n");
        System.out.println("Insert item to sorted array.");

        int sortedArray[] = {1, 2, 3, 4, 5, 6, Integer.MAX_VALUE};

        System.out.println("\nNew array: ");
        __dump(array);

        System.out.println("\nInserting");

        insertionSort.sampleInsert(sortedArray, 4);

         System.out.println("\nResult: ");
        __dump(sortedArray);
    }

}
