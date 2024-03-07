package lc876MiddleOfLinkedList;

import lc2AddTwoNumbers.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        int middle;
        ListNode[] nodeArray= new ListNode[100];
        while(head!=null){
            nodeArray[count] = head;
            head = head.next;
            count++;
        }

        if(count%2 == 0){
            middle = (count+1)/2;
        } else {
            middle = count/2;
        }
        return nodeArray[middle];
    }
}
