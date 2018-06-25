package com.nkodintsov.leetcode.validParentheses;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * <p>
 * Created by nikolay.odintsov on 25.06.18.
 */
public class Solution {

    //O(n) stack based solution
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.isEmpty()) {
            return true;
        }

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }


        return stack.empty();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean result = solution.isValid("((()))");
        System.out.println(result);

        boolean result2 = solution.isValid("((())");
        System.out.println(result2);

        boolean result3 = solution.isValid("()()()");
        System.out.println(result3);

        boolean result4 = solution.isValid(")()()");
        System.out.println(result4);
    }
}
