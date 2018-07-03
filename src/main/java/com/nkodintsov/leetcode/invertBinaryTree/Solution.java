package com.nkodintsov.leetcode.invertBinaryTree;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 * <p>
 * Created by nikolay.odintsov on 03.07.18.
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
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

        System.out.println(solution.invertTree(root));
    }
}
