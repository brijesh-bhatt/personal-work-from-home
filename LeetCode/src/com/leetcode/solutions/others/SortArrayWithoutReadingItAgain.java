package com.leetcode.solutions.others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Sort an array without reading it again and not using any sort method or sorting algorithms.
 */
public class SortArrayWithoutReadingItAgain {

    private static List<Integer> sort(List<Integer> asList) {
        List<Integer> newList = new LinkedList<>();
        asList.forEach(a -> {
            if(newList.size() == 0) {
                IntStream.range(0, a).forEach(i -> newList.add(0));
                newList.add(1);
            }
            else {
                if(a > newList.size() - 1) {
                    IntStream.range(newList.size(), a).forEach(i -> newList.add(0));
                    newList.add(1);
                }
                else {
                    newList.set(a, 1);
                }
            }
        });
        return IntStream.range(0, newList.size()).filter(i -> newList.get(i) == 1).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(sort(Arrays.asList(18,13,99,12,149,11,15,17,16,20,19)));
    }
}
