package lc141LinkedListCycle;

import lc2AddTwoNumbers.ListNode;

public class Solution3 {
    public static void main(String[] args) {
        System.out.println(hasCycle(new ListNode()));
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
