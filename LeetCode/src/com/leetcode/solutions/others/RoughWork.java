package com.leetcode.solutions.others;

import java.util.*;

public class RoughWork {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("pwwkew"));
        System.out.println(longestSubstringWithoutRepeatingCharacters(" "));
        System.out.println(longestSubstringWithoutRepeatingCharacters("aab"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("dvdf"));
    }

    private static int longestSubstringWithoutRepeatingCharacters(String str) {
        Set<Character> characterSet = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        int start = -1;
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(!characterSet.contains(str.charAt(i))) {
                characterSet.add(str.charAt(i));
                count++;
                if(start == -1) {
                    start = i;
                }
            }
            else {
                if(ans < count) {
                    ans = count;
                }
                count--;
                characterSet.remove(str.charAt(start));
                start++;
                i--;
            }
        }
        if (count > ans) {
            ans = count;
        }
        return ans;
    }


}
