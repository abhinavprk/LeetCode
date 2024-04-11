package lc141LinkedListCycle;

import lc2AddTwoNumbers.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println(hasCycle(new ListNode()));
    }

    private static boolean hasCycle(ListNode head) {
        List<ListNode> visited = new ArrayList<>();
        boolean cycle = false;
        while (head != null) {
            if (visited.contains(head)) {
                cycle = true;
                break;
            } else {
                visited.add(head);
                head = head.next;
            }
        }
        return cycle;
    }
}
