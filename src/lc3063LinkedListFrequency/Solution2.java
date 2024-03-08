package lc3063LinkedListFrequency;

import lc2AddTwoNumbers.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, ListNode> freqMap = new HashMap<>();
        ListNode freNode = null;
        while (head != null) {
            int val = head.val;
            if(freqMap.containsKey(val)){
                ListNode currFreqNode = freqMap.get(val);
                currFreqNode.val++;
                freqMap.put(val, currFreqNode);
            } else {
                ListNode node = new ListNode(1, freNode);
                freqMap.put(val, node);
                freNode = node;
            }
            head = head.next;
        }
        return freNode;
    }
}
