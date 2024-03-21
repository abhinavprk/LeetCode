package lc206ReverseLinkedList;

import lc2AddTwoNumbers.ListNode;

import java.util.Stack;

public class Solution1 {

    public ListNode reverseList(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode node = head;
        while(node != null){
            st.push(node.val);
            node = node.next;
        }
        ListNode resNode = new ListNode(0);
        ListNode mNode = resNode;
        while(!st.empty()){
            mNode.next = new ListNode(st.pop());
            mNode = mNode.next;
        }
        return resNode.next;
    }
}
