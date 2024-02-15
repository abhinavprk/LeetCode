package lc2AddTwoNumbers;

import java.util.Arrays;

/**
 * Works for 1565/1568 test cases
 */
public class FirstSolution {

    public static void main(String[] args) {
        ListNode l1 = ListNode.getListNode(Arrays.asList(2,4,3), new ListNode());
        ListNode l2 = ListNode.getListNode(Arrays.asList(5,6,4), new ListNode());
        ListNode result = addTwoNumbers(l1,l2);
        System.out.println("The result is " + result);
    }
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Long numberA = Long.valueOf(getStringValueOfListNode(l1, new StringBuilder()).reverse().toString());
        Long numberB = Long.valueOf(getStringValueOfListNode(l2, new StringBuilder()).reverse().toString());
        StringBuffer sum = new StringBuffer(Long.toString(numberA + numberB)).reverse();
        System.out.println("Sum is: " + sum);
        return createListNodeFromString(sum.toString(), new ListNode());
    }

    private static StringBuilder getStringValueOfListNode(ListNode node, StringBuilder number) {
        number.append(node.val);
        System.out.println("Number is: " + number);
        if (node.next != null) {
            return getStringValueOfListNode(node.next, number);
        }
        return number;
    }

    private static ListNode createListNodeFromString(String value, ListNode node) {
        if (value.length() > 1) {
            node.val = Integer.parseInt(value.substring(0, 1));
            ListNode nextNode = new ListNode();
            node.next = nextNode;
            createListNodeFromString(value.substring(1), nextNode);

        } else if (value.length() == 1) {
            node.val = Integer.parseInt(value.substring(0, 1));
        }
        return node;
    }
}
