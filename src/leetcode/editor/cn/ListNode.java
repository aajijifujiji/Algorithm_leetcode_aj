package leetcode.editor.cn;

import java.util.List;
import java.util.ListIterator;

public class ListNode {
    int val;
    ListNode next;

    ListNode tail;

    ListNode first;
    ListNode(int x) {
        this.val = x;
        this.first = this;
        this.tail = this;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
        this.first = this;
        this.tail = next.tail;
    }
    public ListNode(int[] arr){
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        updateEnds(this, cur);
//        ListNode lur = this;
//        while (lur != null){
//            lur.tail = cur;
//            lur = lur.next;
//        }
    }
    private void updateEnds(ListNode startNode, ListNode tail){
        ListNode cur = startNode;
        while (cur != null){
            cur.tail = tail;
            cur.first = startNode;
            cur = cur.next;
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            sb.append(cur.val + " --> ");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public ListNode append(int val) {
        return append(new ListNode(val));
    }

    public ListNode append(ListNode node) {
        this.tail.next = node;
        this.tail = node;
        updateEnds(this.first, node);
        return node;
    }

}
