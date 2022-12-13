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
        ListNode newOrderedListNodes = null;
        ListNode newOrderedListNodeFirst = null;
        while(list1!=null || list2!=null) {
            if(list1!=null && list2!=null) {
                if(list1.val <= list2.val) {
                    if(newOrderedListNodes == null) {
                        newOrderedListNodes = new ListNode(list1.val, new ListNode(list2.val));
                        newOrderedListNodeFirst = newOrderedListNodes;
                        newOrderedListNodes = newOrderedListNodes.next;
                    }
                    else {
                        newOrderedListNodes.next = new ListNode(list1.val, new ListNode(list2.val));
                        newOrderedListNodes = newOrderedListNodes.next.next;
                    }
                }
                else {
                    if(newOrderedListNodes == null) {
                        newOrderedListNodes = new ListNode(list2.val, new ListNode(list1.val));
                        newOrderedListNodeFirst = newOrderedListNodes;
                        newOrderedListNodes = newOrderedListNodes.next;
                    }
                    else {
                        newOrderedListNodes.next = new ListNode(list2.val, new ListNode(list1.val));
                        newOrderedListNodes = newOrderedListNodes.next.next;
                    }
                }
            }
            else if(list1 == null) {
                if(newOrderedListNodes == null) {
                    newOrderedListNodes = new ListNode(list2.val);
                    newOrderedListNodeFirst = newOrderedListNodes;
                    newOrderedListNodes = newOrderedListNodes.next;
                }
                else {
                    if(newOrderedListNodes.val > list2.val) {
                        int temp = newOrderedListNodes.val;
                        newOrderedListNodes.val = list2.val;
                        newOrderedListNodes.next = new ListNode(temp);
                        newOrderedListNodes = newOrderedListNodes.next;
                    }
                    else {
                        newOrderedListNodes.next = new ListNode(list2.val);
                        newOrderedListNodes = newOrderedListNodes.next;
                    }
                }
            }
            else if(list2 == null) {
                if(newOrderedListNodes == null) {
                    newOrderedListNodes = new ListNode(list1.val);
                    newOrderedListNodeFirst = newOrderedListNodes;
                    newOrderedListNodes = newOrderedListNodes.next;
                }
                else {
                    if(newOrderedListNodes.val > list1.val) {
                        int temp = newOrderedListNodes.val;
                        newOrderedListNodes.val = list1.val;
                        newOrderedListNodes.next = new ListNode(temp);
                        newOrderedListNodes = newOrderedListNodes.next;
                    }
                    else {
                        newOrderedListNodes.next = new ListNode(list1.val);
                        newOrderedListNodes = newOrderedListNodes.next;
                    }
                }
            }
            list1 = list1 != null ? list1.next : list1;
            list2 = list2 != null ? list2.next : list2;
        }
        return newOrderedListNodeFirst;
    }

    public static ListNode mergeTwoListsNew(ListNode list1, ListNode list2) {
        ListNode newOrderedListNodes = null;
        ListNode newOrderedListNodeFirst = null;
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        while(list1 != null && list2 != null) {
            if(newOrderedListNodes == null) {
                if(list1.val <= list2.val) {
                    newOrderedListNodes = new ListNode(list1.val, new ListNode(list2.val));
                }
                else {
                    newOrderedListNodes = new ListNode(list2.val, new ListNode(list1.val));
                }
                newOrderedListNodeFirst = newOrderedListNodes;
                newOrderedListNodes = newOrderedListNodes.next;
            }
            else {
                if(newOrderedListNodes.val > list1.val) {
                    int temp = newOrderedListNodes.val;
                    newOrderedListNodes.val = list1.val;
                    newOrderedListNodes.next = new ListNode(temp);
                    newOrderedListNodes = newOrderedListNodes.next;
                }
                else {
                    newOrderedListNodes.next = new ListNode(list1.val);
                    newOrderedListNodes = newOrderedListNodes.next;
                }

                if(newOrderedListNodes.val > list2.val) {
                    int temp = newOrderedListNodes.val;
                    newOrderedListNodes.val = list2.val;
                    newOrderedListNodes.next = new ListNode(temp);
                    newOrderedListNodes = newOrderedListNodes.next;
                }
                else {
                    newOrderedListNodes.next = new ListNode(list2.val);
                    newOrderedListNodes = newOrderedListNodes.next;
                }
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        while (list1 != null) {
            if(newOrderedListNodes.val > list1.val) {
                int temp = newOrderedListNodes.val;
                newOrderedListNodes.val = list1.val;
                newOrderedListNodes.next = new ListNode(temp);
                newOrderedListNodes = newOrderedListNodes.next;
            }
            else {
                newOrderedListNodes.next = new ListNode(list1.val);
                newOrderedListNodes = newOrderedListNodes.next;
            }
            list1 = list1.next;
        }

        while (list2!=null) {
            if(newOrderedListNodes.val > list2.val) {
                int temp = newOrderedListNodes.val;
                newOrderedListNodes.val = list2.val;
                newOrderedListNodes.next = new ListNode(temp);
                newOrderedListNodes = newOrderedListNodes.next;
            }
            else {
                newOrderedListNodes.next = new ListNode(list2.val);
                newOrderedListNodes = newOrderedListNodes.next;
            }
            list2 = list2.next;
        }
        return newOrderedListNodeFirst;
    }

    public static ListNode mergeTwoListsLatest(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        ListNode newOrderedListNodes = list1;
        ListNode newOrderedListNodeFirst = list1;
        ListNode list2FirstNode = list2;
        boolean isList2ElementsGreaterThanList1 = true;
        while (list2 != null) {
            newOrderedListNodes = newOrderedListNodeFirst;
            while(newOrderedListNodes != null) {
                if(newOrderedListNodes.val >= list2.val) {
                    int temp = newOrderedListNodes.val;
                    ListNode nextNode = newOrderedListNodes.next;
                    newOrderedListNodes.val = list2.val;
                    newOrderedListNodes.next = new ListNode(temp, nextNode);
                    isList2ElementsGreaterThanList1 = false;
                    break;
                }
                else {
                    if(newOrderedListNodes.next == null) {
                        newOrderedListNodes.next = new ListNode(list2.val, null);
                        isList2ElementsGreaterThanList1 = false;
                        break;
                    }
                }
                newOrderedListNodes = newOrderedListNodes.next;
            }
            if(list2.next == null && isList2ElementsGreaterThanList1) {
                newOrderedListNodeFirst = list1;
                while(list1.next != null) {
                    list1 = list1.next;
                }
                list1.next = list2FirstNode;
            }
            list2 = list2.next;
        }
        return newOrderedListNodeFirst;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode two = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoListsLatest(one, two).toString());

        one = new ListNode(5);
        two = new ListNode(1, new ListNode(2, new ListNode(4)));
        System.out.println(mergeTwoListsLatest(one, two).toString());

        one = new ListNode(-9, new ListNode(3));
        two = new ListNode(5, new ListNode(7));
        System.out.println(mergeTwoListsLatest(one, two).toString());

        one = new ListNode(-2, new ListNode(5));
        two = new ListNode(-9, new ListNode(-6, new ListNode(-3, new ListNode(-2, new ListNode(-1, new ListNode(1, new ListNode(6)))))));
        System.out.println(mergeTwoListsLatest(one, two).toString());
    }
}
