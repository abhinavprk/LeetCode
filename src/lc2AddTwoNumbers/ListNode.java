package lc2AddTwoNumbers;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode getListNode(List<Integer> list, ListNode listNode){
        List<Integer> intList = new ArrayList<>(list);
        listNode.val = intList.removeFirst();
        if(!intList.isEmpty()){
            listNode.next = new ListNode();
            getListNode(intList, listNode.next);
        }
        return listNode;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
