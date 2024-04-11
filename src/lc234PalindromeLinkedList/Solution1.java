package lc234PalindromeLinkedList;

import lc2AddTwoNumbers.ListNode;

import java.util.Stack;

public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        boolean isPalindrome = true;
        Stack<Integer> st = new Stack<>();
        ListNode node = head;
        while(node != null){
            st.push(node.val);
            node = node.next;
        }
        while(head !=null){
            if(head.val != st.pop()){
                isPalindrome = false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }
}
