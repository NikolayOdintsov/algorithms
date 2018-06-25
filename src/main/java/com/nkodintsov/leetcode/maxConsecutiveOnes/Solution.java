package com.nkodintsov.leetcode.maxConsecutiveOnes;

/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 * <p>
 * Created by nikolay.odintsov on 13.06.18.
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max_length = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int current_length = 1;
                int r = i + 1;

                while (r < n && nums[r] == 1) {
                    ++r;
                    ++current_length;
                }
                max_length = Math.max(max_length, current_length);

            }
        }

        return max_length;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int max_length = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int current_length = 1;
                int r = i + 1;

                while (r < n && nums[r] == 1) {
                    ++r;
                    ++current_length;
                }
                i = r;
                max_length = Math.max(max_length, current_length);

            }
        }

        return max_length;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};

        Solution solution = new Solution();

        //1 O(n2)
        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println(result);

        //2 O(n)
        int result2 = solution.findMaxConsecutiveOnes2(nums);
        System.out.println(result2);
    }
}
