package com.leetcode.solutions.easy;

import com.leetcode.models.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list1Itr = list1;
        ListNode list2Itr = list2;
        while (list2Itr != null) {
            ListNode prevElement = null;
            ListNode element = list2Itr;
            ListNode nextElement = list2Itr.next;
//            while (list1Itr != null) {
//                if(prevElement == null) {
//                    if(list1Itr.val <= list2Itr.val) {
//                        list2Itr.next = list1Itr;
//                        second.next = first;
//                    }
//                    else {
//                        if(first.val == second.val) {
//                            ListNode temp = second.next;
//                            second.next = first.next;
//                            first.next = second;
//                        }
//                    }
//                }
//
//                System.out.println(list1);
//                second = second.next;
//            }
//            combinedList = combinedList.next;
        }
        return list1;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode two = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        System.out.println(mergeTwoLists(one, two).toString());
    }
}
