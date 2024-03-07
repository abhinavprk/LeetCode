package lc876MiddleOfLinkedList;

import lc2AddTwoNumbers.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        int middle;
        Map<Integer, ListNode> nodeMap= new HashMap<>();
        while(head!=null){
            nodeMap.put(count, head);
            head = head.next;
            count++;
        }

        if(count%2 == 0){
            middle = (count+1)/2;
        } else {
            middle = count/2;
        }
        return nodeMap.get(middle);
    }
}
