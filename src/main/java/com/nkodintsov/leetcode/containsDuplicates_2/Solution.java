package com.nkodintsov.leetcode.containsDuplicates_2;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 * <p>
 * Created by nikolay.odintsov on 27.06.18.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (i - j > k) break;
                if (nums[i] == nums[j]) return true;
                --j;
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;

        //O(nk)
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(nums, k));

        //O(n)
        int[] nums2 = {1, 2, 3, 1};
        int k2 = 3;
        System.out.println(solution.containsNearbyDuplicate2(nums2, k2));
    }
}
