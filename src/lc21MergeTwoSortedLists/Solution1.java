package lc21MergeTwoSortedLists;

import lc2AddTwoNumbers.ListNode;

public class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if ((list1 == null) && (list2 == null)) {
            return null;
        }
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode merged = new ListNode();
        ListNode mergedNode = merged;
        while ((list1 != null) && (list2 != null)) {
            if (list1.val <= list2.val) {
                mergedNode.val = list1.val;
                list1 = list1.next;
            } else {
                mergedNode.val = list2.val;
                list2 = list2.next;
            }
            mergedNode.next = new ListNode();
            mergedNode = mergedNode.next;
        }
        while (list1 != null) {
            mergedNode.val = list1.val;
            list1 = list1.next;
            if (list1 != null) {
                mergedNode.next = new ListNode();
                mergedNode = mergedNode.next;
            }

        }
        while (list2 != null) {
            mergedNode.val = list2.val;
            list2 = list2.next;
            if (list2 != null) {
                mergedNode.next = new ListNode();
                mergedNode = mergedNode.next;
            }
        }

        return merged;
    }
}
