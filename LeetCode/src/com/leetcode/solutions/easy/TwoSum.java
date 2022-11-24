package com.leetcode.solutions.easy;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoSum(new int[] {3,3}, 6)));
        System.out.println(Arrays.toString(findTwoSum(new int[] {3,2,4}, 6)));
        System.out.println(Arrays.toString(findTwoSum(new int[] {2,11,7,15}, 9)));
    }

    public static int[] findTwoSum(int[] nums, int target) {
        int[] twoSums = new int[2];
        int numberGap = 1;
        while (twoSums[0] == 0 && twoSums[1] == 0) {
            for(int i=0; i<nums.length; i++) {
                if (i < nums.length - numberGap) {
                    int twoSum = nums[i] + nums[i + numberGap];
                    if (twoSum == target) {
                        twoSums[0] = i;
                        twoSums[1] = i + numberGap;
                    }
                }
            }
            numberGap++;
        }
        return twoSums;
    }
}
