package leetcode.editor.cn;

//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 482 👎 0

import org.w3c.dom.Node;

import java.util.List;

class RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)return null;
        ListNode res = removeElements(head.next,val);
        if(head.val == val){
            return res;
        }else {
            head.next = res;
            return head;
        }
    }
     */
    /*
    public ListNode removeElements(ListNode head, int val) {
        if(head == null ){
            return null;
        }
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode ret = pre;
        while (pre.val == val){
            pre = pre.next;
            cur = pre.next;
            ret = pre;
        }
        while (cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
                continue;
            }
            pre = cur;
            cur = cur.next;
        }
        return ret;
    }*/
    /*
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            ListNode delNode = head;
            head = delNode.next;
            delNode = null;
        }
        if(head == null)return null;
        ListNode pre = head;
        while (pre.next != null ){
            if(pre.next.val == val){
                 ListNode delNode = pre.next;
                 pre.next = delNode.next;
                 delNode.next = null;
            }else{
                pre = pre.next;
            }
        }
        return head;
    }
     */
}
//leetcode submit region end(Prohibit modification and deletion)
public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}
}