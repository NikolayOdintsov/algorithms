package com.nkodintsov.leetcode.sameTree;

/**
 * https://leetcode.com/problems/same-tree/description/
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

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q==null) return true;
        if(p==null || q== null) return false;

        //p!=null && q!=null

        return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        TreeNode p = new Solution.TreeNode(4);
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

        p.left = left1;
        p.right = right1;


        TreeNode q = new Solution.TreeNode(4);
        TreeNode left11 = new Solution.TreeNode(2);
        TreeNode left12 = new Solution.TreeNode(1);
        TreeNode right12 = new Solution.TreeNode(3);
        left11.left = left12;
        left11.right = right12;


        TreeNode right11 = new Solution.TreeNode(7);
        TreeNode left13 = new Solution.TreeNode(6);
        TreeNode right13 = new Solution.TreeNode(9);
        right11.left = left13;
        right11.right = right13;

        q.left = left11;
        q.right = right11;



        Solution solution = new Solution();
        System.out.println(solution.isSameTree(p, q));

    }
}
