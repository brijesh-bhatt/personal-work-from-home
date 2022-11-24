package com.leetcode.solutions.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    private static String findLongestCommonPrefix(String[] strs) {
        String output = "";
        boolean stop = false;
        for(int i=0; i<strs[0].length(); i++) {
            for(int j=1; j < strs.length; j++) {
                if(i < strs[j].length() && strs[j].charAt(i) == strs[0].charAt(i)) {
                    continue;
                }
                else {
                    stop = true;
                    break;
                }
            }
            if(stop) {
                break;
            }
            else {
                output = output + strs[0].charAt(i);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(findLongestCommonPrefix(new String[] { "flower","flow","flight" }));
        System.out.println(findLongestCommonPrefix(new String[] { "dog","racecar","car" }));
        System.out.println(findLongestCommonPrefix(new String[] { "apcb","apb" }));
        System.out.println(findLongestCommonPrefix(new String[] { "ab", "a" }));
    }
}
