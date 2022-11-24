package com.leetcode.solutions.easy;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValidString("()"));
        System.out.println(isValidString("(){}[]"));
        System.out.println(isValidString("(]"));
        System.out.println(isValidString("([)]"));
        System.out.println(isValidString("{[]}"));
        System.out.println(isValidString("(){}}{"));
    }

    private static boolean isValidString(String s) {
        Stack<String> braces = new Stack<>();
        int round = 0, curly = 0, square = 0;
        boolean isError = false;
        for(int i=0; i<s.length(); i++) {
            String immediateBracketNeedToBeClosed = !braces.empty() ? braces.peek() : null;
            if(s.charAt(i) == '(') {
                round = round + 1;
                braces.push("ROUND");
            }
            if(s.charAt(i) == ')') {
                if("ROUND".equals(immediateBracketNeedToBeClosed)) {
                    round = round - 1;
                    if(!braces.empty()) {
                        braces.pop();
                    }
                }
                else {
                    isError = true;
                }
            }
            if(s.charAt(i) == '{') {
                curly = curly + 1;
                braces.push("CURLY");
            }
            if(s.charAt(i) == '}') {
                if("CURLY".equals(immediateBracketNeedToBeClosed)) {
                    curly = curly - 1;
                    if(!braces.empty()) {
                        braces.pop();
                    }
                }
                else {
                    isError = true;
                }
            }
            if(s.charAt(i) == '[') {
                square = square + 1;
                braces.push("SQUARE");
            }
            if(s.charAt(i) == ']') {
                if("SQUARE".equals(immediateBracketNeedToBeClosed)) {
                    square = square - 1;
                    if(!braces.empty()) {
                        braces.pop();
                    }
                }
                else {
                    isError = true;
                }
            }
        }
        return s.length()>1 && round == 0 && curly == 0 && square == 0 && !isError;
    }
}
