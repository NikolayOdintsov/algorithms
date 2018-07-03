package com.nkodintsov.leetcode.findKpairsWithSmallestSums;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 * <p>
 * Created by nikolay.odintsov on 02.07.18.
 */
public class Solution {

    //O(n^2 log N)
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0 || n == 0) return new ArrayList<int[]>();

        int[][] pairs = new int[m * n][2];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pairs[index][0] = nums1[i];
                pairs[index][1] = nums2[j];
                index++;
            }
        }

        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] + a[1] == b[0] + b[1]) return 0;
                else if (a[0] + a[1] < b[0] + b[1]) return -1;
                else return 1;
            }
        });

        int[][] first_k = Arrays.copyOfRange(pairs, 0, k);
        List<int[]> ret = new LinkedList<>(Arrays.asList(first_k));
        ret.removeAll(Collections.singleton(null));
        return ret;

    }

    //O(n^2 log k)
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        if (m == 0 || n == 0) return new ArrayList<int[]>();


        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] + a[1] < b[0] + b[1]) {
                    return 1;
                } else if (a[0] + a[1] > b[0] + b[1]) {
                    return -1;
                }
                return 0;
            }
        });

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] temp = new int[2];
                temp[0] = nums1[i];
                temp[1] = nums2[j];

                if (pq.size() < k) {
                    pq.add(temp);
                } else {
                    int[] top_elem = pq.peek();
                    if (nums1[i] + nums2[j] < top_elem[0] + top_elem[1]) {
                        pq.poll();
                        pq.add(temp);
                    }
                }
            }
        }

        List<int[]> ret = new LinkedList<>();
        while (pq.size() != 0) {
            ret.add(0, pq.poll());
        }

        return ret;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.kSmallestPairs(nums1, nums2, k));

        System.out.println(solution.kSmallestPairs2(nums1, nums2, k));


    }
}
