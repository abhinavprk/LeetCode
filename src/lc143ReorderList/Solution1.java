package lc143ReorderList;

import lc2AddTwoNumbers.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    /*
    Time Complexity:

    O(n):
    Iterating through the linked list once to create the nodeMap takes O(n) time.
    Reordering the list using the nodeMap also takes O(n) time, as it iterates through the list's nodes in a controlled way.
    Space Complexity:

    O(n):
    The nodeMap stores a reference to each node in the linked list, requiring space proportional to the number of nodes (n).
    O(1) additional space:
    The few extra variables used (node, ind, start, end, res, temp) occupy constant space, regardless of the list size.
    Therefore, the overall time complexity is O(n), and the space complexity is O(n).

    Key points:

    The use of a HashMap for quick node retrieval contributes to linear time complexity in reordering.
    The space complexity is dominated by the HashMap, which scales with the input size.
    Potential optimization:

    It's worth considering a constant-space approach to reordering in-place, using techniques like finding the middle node and reversing
    the second half of the list. This would reduce space complexity to O(1). However, it might increase time complexity due to additional
    pointer manipulations.
     */
    public void reorderList(ListNode head) {
        ListNode node = head;
        Map<Integer, ListNode> nodeMap = new HashMap<>();
        int ind = 0;
        while (node != null) {
            nodeMap.put(ind++, node);
            node = node.next;
        }

        int start = 0;
        int end = nodeMap.size()-1;
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(start<=end){
            temp.next = nodeMap.get(start);
            temp.next.next = nodeMap.get(end);
            temp = temp.next.next;
            start++;
            end--;
        }
        temp.next = null;
        head = res.next;
    }
}
