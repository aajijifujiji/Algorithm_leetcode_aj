package leetcode.editor.cn;

import java.util.List;
import java.util.ListIterator;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
    public ListNode(int[] arr){
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
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


}
