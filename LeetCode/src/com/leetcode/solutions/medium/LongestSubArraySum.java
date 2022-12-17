package com.leetcode.solutions.medium;

import com.leetcode.solutions.others.PowerSet;

import java.util.*;
import java.util.stream.Collectors;

/**
 * array with integers ( both +ve & -ve)
 * find sub array where sum is max
 *
 * [-1, -2, 1, 2, 3, -7, 5]
 * o/p: 6
 *
 * [-1, -2, 1, 2, 3, -7, 9]
 */
public class LongestSubArraySum {
    public static void main(String[] args) {
        System.out.println(printSubArray(new int[] { -1, -2, 1, 2, 3, -7, 5 } ));
        System.out.println(printSubArrayKadane(new int[] { -1, -2, 1, 2, 3, -7, 5 } ));
    }

    private static int printSubArray(int[] nums) {
        List<Integer> sums = new ArrayList<>();
        Map<Integer, List<Integer>> subArrayWithSum = new TreeMap<>(Comparator.reverseOrder());
        int sum = Integer.MIN_VALUE;
        // 1st Loop for length of sub-array
        for(int i=1; i<=nums.length; i++) {
            int[] subArray = new int[i];
            // Second Loop for iterating nums but only till that index where the last subarray will start.
            for (int j=0; j<=nums.length-i; j++) {
                // Third Loop for insertingvalues to subarray
                for(int k=0; k<subArray.length; k++) {
                    //System.out.println("i = " + i + ", j =" + j + ", k =" + k);
                    subArray[k] = nums[j + k];
                }
                // Store the max between the existing sum and subArray sum
                sum = Math.max(sum, Arrays.stream(subArray).sum());
                sums.add(sum);
                subArrayWithSum.putIfAbsent(sum, Arrays.stream(subArray).boxed().collect(Collectors.toList()));
            }
        }
        //System.out.println(subArrayWithSum);
        return sums.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    private static int printSubArrayKadane(int[] nums) {
        int overallMax = nums[0],currentMax = nums[0];
        for (int i=1; i<nums.length; i++) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            overallMax = Math.max(overallMax, currentMax);
        }
        return overallMax;
    }
}
