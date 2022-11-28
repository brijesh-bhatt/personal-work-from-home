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
        ListNode listNode = list1;
        while (listNode.next != null) {
            listNode = listNode.next;
        }
        listNode.next = list2;

        ListNode outPut = list1;
        ListNode previousNode = null;
//        while(outPut.next != null) {
//            ListNode currentNode = outPut;
//            ListNode nextNode = outPut.next;
//            System.out.println();
//            System.out.println(previousNode);
//            System.out.println(currentNode);
//            System.out.println(nextNode);
//            System.out.println(outPut);
//            if(currentNode != null && nextNode != null && currentNode.val > nextNode.val) {
//                currentNode.next = nextNode.next;
//                previousNode.next = nextNode;
//                nextNode.next = currentNode;
//            }
//            System.out.println();
//            System.out.println(outPut);
//            previousNode = currentNode;
//            outPut = outPut.next;
//        }

        System.out.println(list1);
        ListNode listNodeLoop1 = list1;
        while(listNodeLoop1 != null) {
            ListNode currentNode = listNodeLoop1;
            previousNode = currentNode;
            System.out.println("currentNode: " + currentNode.val);
            ListNode listNodeLoop2 = listNodeLoop1;
            while (listNodeLoop2 != null && listNodeLoop2.next != null) {
                ListNode nextNode = listNodeLoop2.next;
                System.out.println("previousNode: " + previousNode.val);
                System.out.println("nextNode: " + nextNode.val);
                if(previousNode == currentNode) {
                    if(currentNode != null && nextNode != null && currentNode.val >= nextNode.val) {
//                        currentNode.next = nextNode.next;
//                        nextNode.next = currentNode;
                        previousNode.next = nextNode.next;
                        nextNode.next = currentNode.next;
                        currentNode.next = nextNode;
                        System.out.println(list1);
                    }
                }
                else {
                    if(currentNode != null && nextNode != null && currentNode.val >= nextNode.val) {
                        previousNode.next = nextNode.next;
                        nextNode.next = currentNode.next;
                        currentNode.next = nextNode;
                        System.out.println(list1);
                    }
                }
                listNodeLoop2 = listNodeLoop2.next;
                previousNode = listNodeLoop2;
            }
            listNodeLoop1 = listNodeLoop1.next;
            System.out.println();
        }
        return outPut;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode two = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        System.out.println(mergeTwoLists(one, two).toString());
    }
}
