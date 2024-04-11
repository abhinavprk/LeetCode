package lc1669MergeInBetweenLinkedLists;

import lc2AddTwoNumbers.ListNode;

public class Solution1 {
/*
    Time Complexity:

    O(n + m), where n is the length of list1 and m is the length of list2.
    The two while loops that traverse list1 up to nodes a and b respectively take a total time
    proportional to n.
    The while loop that finds the end of list2 takes time proportional to m.
    The remaining operations (pointer manipulations) take constant time.

    Space Complexity:

    O(1), meaning it uses a constant amount of extra space, regardless of input size.
    The method creates a few pointers to nodes within the existing lists, but it doesn't
    allocate any new data structures or large blocks of memory.

    Explanation:
    The method efficiently navigates through the linked lists using pointers, avoiding any memory-intensive operations.
    The overall time complexity is dominated by the two traversals of list1 and one traversal of list2.
    The constant extra space used for pointers contributes to constant space complexity.

    Key Points:

    The method achieves linear time complexity with minimal space overhead, making it efficient for handling
    large linked lists.
    It demonstrates the advantage of linked lists in terms of memory usage for certain operations.
 */
    private static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //Get the front ListNode for the result
        ListNode headList1 = list1;
        int start = 0;
        while(start < a-1){
            headList1 = headList1.next;
            start++;
        }
        //Get the back of the ListNode for the result
        int end = 0;
        ListNode tail = list1;
        while(end < b+1){
            tail = tail.next;
            end++;
        }
        //get the last ListNode of the list2
        ListNode headList2 = list2;
        while(headList2.next != null){
            headList2 = headList2.next;
        }
        //Add back of the result to the ListNode list2
        headList2.next = tail;
        //Add the updated ListNode list2 to the front ListNode for the result
        headList1.next = list2;

        //The list1 will be the updated resulting list node
        return list1;
    }
}
