package com.nkodintsov.dataStructures.arrays;

/**
 * Created by nikolay.odintsov on 22.05.18.
 */
public class App {
    public static void main(String[] args) {
        int[] nums = new int[5];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        //O(1) random index
        int num = nums[0];
        System.out.println(num);

        //O(n) "Linear search" --> O(longN) binary trees --> O(1) hashtables
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                System.out.println("Index found, " + i);
            }
        }
    }
}
