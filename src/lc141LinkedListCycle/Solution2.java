package lc141LinkedListCycle;

import lc2AddTwoNumbers.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(hasCycle(new ListNode()));
    }

    private static boolean hasCycle(ListNode head) {
        boolean cycle = false;
        if ((head != null) && (head.next != null)) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null) {
                slow = slow.next;
                if (fast.next != null) {
                    fast = fast.next.next;
                    if (slow == fast) {
                        cycle = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return cycle;
    }
}
