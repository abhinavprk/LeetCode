package lc2_add_two_numbers;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
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
