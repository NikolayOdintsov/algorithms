package com.nkodintsov.leetcode.maximumDepthOfBinaryTree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * <p>
 * Created by nikolay.odintsov on 04.07.18.
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return Math.max(l, r) + 1;

    }

    public static void main(String[] args) {

        TreeNode root = new Solution.TreeNode(4);
        TreeNode left1 = new Solution.TreeNode(2);
        TreeNode left2 = new Solution.TreeNode(1);
        TreeNode right2 = new Solution.TreeNode(3);
        left1.left = left2;
        left1.right = right2;


        TreeNode right1 = new Solution.TreeNode(7);
        TreeNode left3 = new Solution.TreeNode(6);
        TreeNode right3 = new Solution.TreeNode(9);
        right1.left = left3;
        right1.right = right3;

        root.left = left1;
        root.right = right1;

        Solution solution = new Solution();

        System.out.println(solution.maxDepth(root));

    }
}
