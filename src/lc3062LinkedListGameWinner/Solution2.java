package lc3062LinkedListGameWinner;

import lc2AddTwoNumbers.ListNode;

public class Solution2 {

    public String gameResult(ListNode head) {
        int odd = 0;
        int even = 0;
        String result = "Tie";
        ListNode evenNode = head;
        while (evenNode != null) {
            ListNode oddNode = evenNode.next;
            if (evenNode.val > oddNode.val) {
                even++;
            } else {
                odd++;
            }
            evenNode = oddNode.next;
        }
        if (even > odd) {
            result = "Even";
        } else if (odd > even) {
            result = "Odd";
        }
        return result;
    }

}
