package lc876MiddleOfLinkedList;

import lc2AddTwoNumbers.ListNode;

public class Solution3 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
