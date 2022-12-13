package com.leetcode.solutions.others;

import java.util.*;

public class RoughWork {

    public static void main(String[] args) {
        //System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    private static boolean wordBreak(String str, List<String> dict) {
        Set<String> wordDictSet = new HashSet<>(dict);
        boolean[] visited = new boolean[str.length()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer start = queue.remove();
            if(visited[start]) {
                continue;
            }

            for (int end = start + 1; end <= str.length(); end++) {
                if(wordDictSet.contains(str.substring(start, end))) {
                    queue.add(end);
                    if (end == str.length()) {
                        return true;
                    }
                }
            }

            visited[start] = true;
        }
        return false;
    }


}
