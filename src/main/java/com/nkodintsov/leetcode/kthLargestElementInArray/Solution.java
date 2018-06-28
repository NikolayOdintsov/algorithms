package com.nkodintsov.leetcode.kthLargestElementInArray;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * <p>
 * Created by nikolay.odintsov on 28.06.18.
 */
public class Solution {

    //O(n logN)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    //O(n logK)
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else {
                int min = pq.peek();
                if (min < nums[i]) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }

        return pq.peek();

    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        Solution solution = new Solution();

        System.out.println(solution.findKthLargest2(nums, k));

        int nums2[] = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        System.out.println(solution.findKthLargest2(nums2, k));
    }
}
