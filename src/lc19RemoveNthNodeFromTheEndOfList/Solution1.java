package lc19RemoveNthNodeFromTheEndOfList;

import lc2AddTwoNumbers.ListNode;

public class Solution1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head;
        int length = 0;
        while (start != null) {
            length++;
            start = start.next;
        }
        length = length - n;
        start = dummy;
        while ((length > 0)) {
            length--;
            start = start.next;
        }
        start.next = start.next.next;
        return dummy.next;
    }
}
