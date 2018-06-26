package com.nkodintsov.leetcode.baseballGame;

import java.util.Stack;

/**
 * https://leetcode.com/problems/baseball-game/description/
 * <p>
 * Created by nikolay.odintsov on 26.06.18.
 */
public class Solution {

    public int getScore(String[] input) {
        Stack<Integer> validScore = new Stack<>();
        Integer result = 0;

        for (String s : input) {
            if (s.equals("C")) {
                if (!validScore.empty()) {
                    Integer el = validScore.pop();
                    result -= el;
                }
            } else if (s.equals("D")) {
                if (!validScore.empty()) {
                    Integer currentVal = validScore.lastElement() * 2;
                    validScore.push(currentVal);
                    result += currentVal;
                }
            } else if (s.equals("+")) {
                if (validScore.size() > 1) {
                    Integer currentVal = validScore.lastElement() + validScore.get(validScore.size() - 2);
                    validScore.push(currentVal);
                    result += currentVal;
                }
            } else {
                Integer currentVal = Integer.valueOf(s);
                validScore.push(currentVal);
                result += currentVal;
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String[] input = {"5", "2", "C", "D", "+"};

        Solution solution = new Solution();
        System.out.println(solution.getScore(input));

        String[] input2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(solution.getScore(input2));

        String[] input3 = {"C", "D", "9", "+", "+"};
        System.out.println(solution.getScore(input3));
    }
}
