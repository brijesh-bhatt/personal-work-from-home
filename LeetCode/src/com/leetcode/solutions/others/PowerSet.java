package com.leetcode.solutions.others;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {

    public static Set<String> powerSet(char[] set, int setSize) {

        /* setSize of power set of a set with setSize n is (2**n -1) */
        long powSetSize = (long) Math.pow(2, setSize);

        int counter, j;

        Set<String> output = new HashSet<>();

        /*Run from counter 000..0 to 111..1*/
        for(counter = 0; counter < powSetSize; counter++) {
            String str = "";
            for(j = 0; j < setSize; j++) {
                /* Check if jth bit in the counter is set If set then print jth element from set */
                if((counter & (1 << j)) > 0) {
                    //System.out.print(" counter=" + counter + ", j=" + j + " ");
                    //System.out.print(set[j]);
                    str = str.concat(String.valueOf(set[j]));
                    output.add(str);
                }
            }
            //System.out.println();
        }
        return output;
    }

    public static Set<Set<Integer>> powerSet(int[] nums, int setSize) {

        /* setSize of power set of a set with setSize n is (2**n -1) */
        long powSetSize = (long) Math.pow(2, setSize);

        int counter, j;

        Set<Set<Integer>> output = new HashSet<>();

        /*Run from counter 000..0 to 111..1*/
        for(counter = 0; counter < powSetSize; counter++) {
            Set<Integer> set = new HashSet<>();
            for(j = 0; j < setSize; j++) {
                /* Check if jth bit in the counter is set If set then print jth element from set */
                if((counter & (1 << j)) > 0) {
                    //System.out.print(" counter=" + counter + ", j=" + j + " ");
                    //System.out.print(set[j]);
                    set.add(nums[j]);
                    output.add(set);
                }
            }
            //System.out.println();
        }
        return output;
    }

    // Driver program to test printPowerSet
    public static void main (String[] args)
    {
        char[] set = {'a', 'b', 'c'};
        int[] nums = {-1, -2, 1, 2, 3, -7, 5};
        //System.out.println(powerSet(set, 3));
        System.out.println(powerSet(nums, nums.length));
    }
}
