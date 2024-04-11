package lc206ReverseLinkedList;

import lc2AddTwoNumbers.ListNode;

public class Solution3 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode m = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return m;
    }
}
