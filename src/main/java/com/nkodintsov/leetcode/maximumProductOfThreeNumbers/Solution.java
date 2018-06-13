package com.nkodintsov.leetcode.maximumProductOfThreeNumbers;

import java.util.Arrays;

/**
 * Created by nikolay.odintsov on 13.06.18.
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int result1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int result2 = nums[n - 1] * nums[0] * nums[1];

        return Math.max(result1, result2);
    }

    public int maximumProduct2(int[] nums) {
        int rangeMin = -1000;
        int rangeMax = 1000;
        int max1 = rangeMin, max2 = rangeMin, max3 = rangeMin, min1 = rangeMax, min2 = rangeMax;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= max3) {
                max1 = max2;
                max2 = max3;
                max3 = nums[i];
            } else if (nums[i] >= max2) {
                max1 = max2;
                max2 = nums[i];
            } else if (nums[i] >= max1) {
                max1 = nums[i];
            }

            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] <= min2) {
                min2 = nums[i];
            }
        }

        int result1 = max1 * max2 * max3;
        int result2 = max3 * min1 * min2;

        return Math.max(result1, result2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        Solution solution = new Solution();

        //1. O(n lgN)
        int result = solution.maximumProduct(nums);
        System.out.println(result);

    }
}
