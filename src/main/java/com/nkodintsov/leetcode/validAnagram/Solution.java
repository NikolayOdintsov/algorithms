package com.nkodintsov.leetcode.validAnagram;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/description/
 * <p>
 * Created by nikolay.odintsov on 28.06.18.
 */
public class Solution {

    //O(n2)
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        boolean[] matched = new boolean[t.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j) && !matched[j]) {
                    matched[j] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < matched.length; i++) {
            if (!matched[i]) {
                return false;
            }
        }

        return true;

    }

    //O(n lgN)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);

        return Arrays.equals(charS, charT);

    }

    //O(n)
    public boolean isAnagram3(String s, String t) {
        int[] H = new int[128];
        for (int i = 0; i < s.length(); i++) {
            H[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            H[t.charAt(i)]--;
        }

        for (int i = 0; i < 128; i++) {
            if (H[i] != 0) return false;
        }

        return true;

    }

    public static void main(String[] args) {

        String s = "anagram", t = "nagaram";

        Solution solution = new Solution();

        System.out.println(solution.isAnagram3(s, t));

        s = "rat";
        t = "car";
        System.out.println(solution.isAnagram3(s, t));

    }
}
