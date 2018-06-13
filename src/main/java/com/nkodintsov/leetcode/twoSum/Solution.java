package com.nkodintsov.leetcode.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 * <p>
 * Created by nikolay.odintsov on 07.06.18.
 */
public class Solution {

    int[] nums = {2, 7, 11, 15};
    int target = 9;

    int[] indexes = twoSum(nums, target);

    //O(n2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = 0; j <= nums.length - 1; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
        }

        return null;
    }

    //O(n lgN)
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;

        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        //sort array based on values
        Arrays.sort(a, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Double.compare(a[0], b[0]);
            }
        });

        int i = 0;
        int j = n - 1;
        int[] result = new int[2];
        while (i < j) {
            if (a[i][0] + a[j][0] == target) {
                result[0] = Math.min(a[i][1], a[j][1]);
                result[1] = Math.max(a[i][1], a[j][1]);
                break;
            } else if (a[i][0] + a[j][0] > target) {
                --j;
            } else {
                ++i;
            }
        }

        return result;
    }

    //O(n)
    public int[] twoSum3(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numsMap.containsKey(complement)) {
                int index1 = numsMap.get(complement);
                int index2 = i;
                return new int[]{index1, index2};
            }

            numsMap.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 15, 11};
        int target = 13;

        Solution solution = new Solution();

        //1
        int[] indexes = solution.twoSum(nums, target);

        if (indexes != null) {
            System.out.println(Arrays.toString(indexes));
        }

        //2
        int[] indexes2 = solution.twoSum2(nums, target);

        if (indexes2 != null) {
            System.out.println(Arrays.toString(indexes2));
        }

        //3
        int[] indexes3 = solution.twoSum3(nums, target);

        if (indexes3 != null) {
            System.out.println(Arrays.toString(indexes3));
        }

    }
}
