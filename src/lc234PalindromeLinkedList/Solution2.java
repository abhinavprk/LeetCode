package lc234PalindromeLinkedList;

import lc2AddTwoNumbers.ListNode;

import java.util.Stack;

public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        StringBuilder str = new StringBuilder();
        ListNode node = head;
        while(node != null){
            str.append(node.val);
            node = node.next;
        }

        String orig = str.toString();
        String rev = str.reverse().toString();
        return orig.equals(rev);
    }
}
