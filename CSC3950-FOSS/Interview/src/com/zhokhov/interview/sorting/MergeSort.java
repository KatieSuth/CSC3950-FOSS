/*
 *  You are free to use this code anywhere, copy, modify and redistribute at your
 *  own risk.
 *  Your are solely responsibly for any damage that may occur by using this code.
 *
 *  This code is not tested for all boundary conditions. Use it at your own risk.
 *
 *  Original code: http://www.codenlearn.com/2011/10/simple-merge-sort.html
 */
package com.zhokhov.interview.sorting;

import static com.zhokhov.interview.util.Menu.*;

/**
 * @author <a href='mailto:alexey@zhokhov.com'>Alexey Zhokhov</a>
 */
public class MergeSort {

    private int COMPARISONS_COUNT;
    private int LOOP_COUNT;

    public void sort(int[] array) {
        COMPARISONS_COUNT = 0;
        LOOP_COUNT = 0;

        mergeSort(array, 0, array.length - 1);
    }

    /*
     * The mergeSort algorithm implementation
     */
    private void mergeSort(int[] array, int left, int right) {
         System.out.println("\nmergeSort, left: " + left + ", right: " + right + "  ==> ");
        System.out.println("" + (left < right));
        COMPARISONS_COUNT++;
        if (left < right) {
            // split the array into 2
            int center = (left + right) / 2;

            System.out.println("center: " + center);
            // sort the left and right array
            mergeSort(array, left, center);
            mergeSort(array, center + 1, right);

            System.out.println("Merging, center: " + center);

            // merge the result
            merge(array, left, center + 1, right);
        }
    }

    /*
     * The merge method used by the mergeSort algorithm implementation.
     */
    private void merge(int[] array, int leftArrayBegin,
                       int rightArrayBegin, int rightArrayEnd) {
        int leftArrayEnd = rightArrayBegin - 1;

        int numElements = rightArrayEnd - leftArrayBegin + 1;
        int[] resultArray = new int[numElements];
        int resultArrayBegin = 0;

         System.out.println("leftArrayBegin: " + leftArrayBegin);
         System.out.println("leftArrayEnd: " + leftArrayEnd);
         System.out.println("rightArrayBegin: " + rightArrayBegin);
         System.out.println("rightArrayEnd: " + rightArrayEnd);
        // Find the smallest element in both these array and add it to the result
        // array i.e you may have a array of the form [1,5] [2,4]
        // We need to sort the above as [1,2,4,5]
        while (leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd) {
            COMPARISONS_COUNT++;

            if (array[leftArrayBegin] <= array[rightArrayBegin]) {
                resultArray[resultArrayBegin++] = array[leftArrayBegin++];

                 System.out.println(" new leftArrayBegin: " + leftArrayBegin);
            } else {
                resultArray[resultArrayBegin++] = array[rightArrayBegin++];

                 System.out.println(" new rightArrayBegin: " + rightArrayBegin);
            }
        }

        // After the main loop completed we may have few more elements in
        // left array copy them first
        while (leftArrayBegin <= leftArrayEnd) {
            COMPARISONS_COUNT++;

            resultArray[resultArrayBegin++] = array[leftArrayBegin++];

             System.out.println(" [post] new leftArrayBegin: " + leftArrayBegin);
        }

        // After the main loop completed we may have few more elements in
        // right array copy them
        while (rightArrayBegin <= rightArrayEnd) {
            COMPARISONS_COUNT++;

            resultArray[resultArrayBegin++] = array[rightArrayBegin++];

             System.out.println(" [post] new rightArrayBegin: " + rightArrayBegin);
        }

        // Copy resultArray back to the main array
        for (int i = numElements - 1; i >= 0; i--, rightArrayEnd--) {
            LOOP_COUNT++;

            array[rightArrayEnd] = resultArray[i];
        }

         System.out.println("==> ");
        __dump(array);
    }

    /*
     * A sample merge method to help understand the merge routine.
     * This below function is not used by the merge sort.
     *
     * This is here only for explanation purpose.
     */
    public int[] sampleMerge(int[] leftArray, int[] rightArray) {
        int leftArrayEnd = leftArray.length - 1;
        int rightArrayEnd = rightArray.length - 1;
        int leftArrayBegin = 0;
        int rightArrayBegin = 0;

        int numElements = leftArray.length + rightArray.length;
        int[] resultArray = new int[numElements];
        int resultArrayBegin = 0;

         System.out.println("  leftArrayBegin: " + leftArrayBegin);
         System.out.println("  leftArrayEnd: " + leftArrayEnd);
         System.out.println("  rightArrayBegin: " + rightArrayBegin);
         System.out.println("  rightArrayEnd: " + rightArrayEnd);

        // Find the smallest element in both these array and add it to the temp
        // array i.e you may have a array of the form [1,5] [2,4]
        // We need to sort the above as [1,2,4,5]
        while (leftArrayBegin <= leftArrayEnd && rightArrayBegin <= rightArrayEnd) {
            if (leftArray[leftArrayBegin] <= rightArray[rightArrayBegin]) {
                resultArray[resultArrayBegin++] = leftArray[leftArrayBegin++];

                 System.out.println(" new leftArrayBegin: " + leftArrayBegin);
            } else {
                resultArray[resultArrayBegin++] = rightArray[rightArrayBegin++];

                 System.out.println(" new rightArrayBegin: " + rightArrayBegin);
            }
        }

        // After the main loop completed we may have few more elements in
        // left array copy them first
        while (leftArrayBegin <= leftArrayEnd) {
            resultArray[resultArrayBegin++] = leftArray[leftArrayBegin++];

             System.out.println(" [post] new leftArrayBegin: " + leftArrayBegin);
        }

        // After the main loop completed we may have few more elements in
        // right array copy them
        while (rightArrayBegin <= rightArrayEnd) {
            resultArray[resultArrayBegin++] = rightArray[rightArrayBegin++];

             System.out.println(" [post] new rightArrayBegin: " + rightArrayBegin);
        }

        return resultArray;
    }

    //Katie - renamed this function since Menu.java is the new main
    public void MergeStart() {
        int array[] = {7, 1, 8, 2, 0, 12, 10, 7, 5, 3};

        System.out.println("\nNew array: ");
        __dump(array);

        System.out.println("\nSorting");

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);

         System.out.println("\nResult: ");
        __dump(array);

        System.out.println("\nStatistics");
        System.out.print("  Comparisons: ");
        System.out.print(mergeSort.COMPARISONS_COUNT);
        System.out.print("\n  Loops: ");
        System.out.print(mergeSort.LOOP_COUNT);

        System.out.print("\n");
        System.out.println("***********************\n");
        System.out.println("Now demo a simple merge routine.");

        int leftArray[] = {1, 3, 5, 7};
        int rightArray[] = {2, 4, 6, 8, 10};

         System.out.println("\nLeft array: ");
        __dump(leftArray);
         System.out.println("Right array: ");
        __dump(rightArray);

        System.out.println("\nMerging");

        int[] mergedArray = mergeSort.sampleMerge(leftArray, rightArray);

        System.out.println("\nResult: ");
        __dump(mergedArray);
    }

}
