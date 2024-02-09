package lc2_add_two_numbers;

import java.util.Arrays;

/**
 * Works for 1565/1568 test cases
 */
public class SecondSolution {

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListNode(Arrays.asList(9,9,9,9,9,9,9), new ListNode());
        ListNode l2 = ListNode.getListNode(Arrays.asList(9,9,9,9), new ListNode());
        ListNode result = addTwoNumbers(l1,l2);
        System.out.println("The result is " + result);
    }
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode currNodeSum = dummyNode;
        ListNode currentNodeInL1 = l1;
        ListNode currentNodeInL2 = l2;
        int carry = 0;
        int sumOfCurrentL1L2;
        while((currentNodeInL1 != null) || (currentNodeInL2 != null) || carry != 0){
            int valAtCurrentL1 = (currentNodeInL1==null) ? 0 : currentNodeInL1.val;
            int valAtCurrentL2 = (currentNodeInL2==null) ? 0 : currentNodeInL2.val;
            int sumVal = valAtCurrentL1 + valAtCurrentL2 + carry ;
            sumOfCurrentL1L2 = sumVal % 10;
            carry = sumVal / 10;
            ListNode sumNode = new ListNode();
            sumNode.val = sumOfCurrentL1L2;
            currNodeSum.next = sumNode;
            currNodeSum = currNodeSum.next;
            currentNodeInL1 = (currentNodeInL1==null) ? null : currentNodeInL1.next;
            currentNodeInL2 = (currentNodeInL2==null) ? null : currentNodeInL2.next;
        }
        return dummyNode.next;
    }

    private static ListNode addTwoNumbersMemory(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null)? l1.val : 0;
            int val2 = (l2 != null)? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            current.next = new ListNode(digit);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        System.gc();
        return dummy.next;
    }


}
