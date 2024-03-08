package lc3063LinkedListFrequency;

import lc2AddTwoNumbers.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        ListNode freNode = new ListNode(0);
        ListNode dummy = freNode;
        while (head != null) {
            int val = head.val;
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
            head = head.next;
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freNode.next = new ListNode(entry.getValue());
            freNode = freNode.next;
        }

        return dummy.next;
    }
}
