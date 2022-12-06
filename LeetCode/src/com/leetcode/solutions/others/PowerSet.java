package com.leetcode.solutions.others;

public class PowerSet {

    static void printPowerSet(char[] set, int setSize) {

        /* setSize of power set of a set with setSize n is (2**n -1) */
        long powSetSize = (long) Math.pow(2, setSize);

        int counter, j;

        /*Run from counter 000..0 to 111..1*/
        for(counter = 0; counter < powSetSize; counter++) {
            for(j = 0; j < setSize; j++) {
                /* Check if jth bit in the counter is set If set then print jth element from set */
                if((counter & (1 << j)) > 0) {
                    System.out.print(" counter=" + counter + ", j=" + j + " ");
                    System.out.print(set[j]);
                }
            }
            System.out.println();
        }
    }

    // Driver program to test printPowerSet
    public static void main (String[] args)
    {
        char[] set = {'a', 'b', 'c'};
        printPowerSet(set, 3);
    }
}
