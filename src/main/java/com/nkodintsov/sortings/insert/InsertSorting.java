package com.nkodintsov.sortings.insert;

/**
 * Class provides implementation of insert soring.
 * Time complexity is O(n2)
 * <p/>
 * Created by nikolay.odintsov on 17.02.18.
 */
public class InsertSorting {
    public int[] sort(int[] inputArray) {
        for (int i = 1; i < inputArray.length; i++) {
            int key = inputArray[i];
            int j = i - 1;
            while (j >= 0 && inputArray[j] > key) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            inputArray[j + 1] = key;
        }
        return inputArray;
    }
}
