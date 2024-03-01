package lc3062LinkedListGameWinner;

import lc2AddTwoNumbers.ListNode;

public class Solution1 {
    int odd = 0;
    int even = 0;
    String result = "Tie";

    public String gameResult(ListNode head) {
        findResult(head, 0);
        System.out.println(odd);
        System.out.println(even);
        if (odd > even) {
            result = "Odd";
        } else if (even > odd) {
            result = "Even";
        }
        return result;
    }

    private void findResult(ListNode node, int prev) {
        if (node == null) {
            return;
        }
        int curr = node.val;
        if ((curr % 2) != 0) {
            if (prev > curr) {
                even++;
            } else {
                odd++;
            }
        }
        findResult(node.next, curr);
    }
}
