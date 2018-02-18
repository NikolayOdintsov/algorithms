package com.nkodintsov.sortings.merge;

/**
 * Class provides implementation of merge soring.
 * Time complexity is O(n lgn)
 * <p/>
 * Created by nikolay.odintsov on 18.02.18.
 */
public class MergeSorting {
    private int[] resultArray;
    private int[] tempArray;

    private int arrayLength;

    public int[] sort(int[] inputArray) {
        resultArray = inputArray;
        arrayLength = inputArray.length;

        this.tempArray = new int[arrayLength];

        mergeSort(0, arrayLength - 1);

        return resultArray;
    }

    private void mergeSort(int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            //index of the element in the middle
            int middle = leftIndex + (rightIndex - leftIndex) / 2;

            //sort the left side array
            mergeSort(leftIndex, middle);

            //sort the right side array
            mergeSort(middle + 1, rightIndex);

            //merge left and right arrays
            merge(leftIndex, middle, rightIndex);
        }
    }

    private void merge(int leftIndex, int middleIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            tempArray[i] = resultArray[i];
        }

        int i = leftIndex;
        int j = middleIndex + 1;
        int k = leftIndex;

        /**
         * Copy the smallest values from either the left or the right side back to the original array
         */
        while (i <= middleIndex && j <= rightIndex) {
            if (tempArray[i] <= tempArray[j]) {
                resultArray[k] = tempArray[i];
                i++;
            } else {
                resultArray[k] = tempArray[j];
                j++;
            }
            k++;
        }

        /**
         * Copy the rest of the left side of the array into the target array
         */
        while (i <= middleIndex) {
            resultArray[k] = tempArray[i];
            k++;
            i++;
        }
    }
}
