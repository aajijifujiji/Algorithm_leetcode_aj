package leetcode.editor.cn;

//$ {question.content}
class IntersectionOfTwoLinkedLists{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        ListNode l = new ListNode(new int[]{8, 4,  5});
        ListNode headA = new ListNode(4).append(1).append(l);

        ListNode headB = new ListNode(5).append(6).append(1).append(l);
//
        ListNode res = solution.getIntersectionNode(headA, headB);

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)return null;

        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB){
            if(pA != null)
                pA = pA.next;
            else
                pA = headB;
            if(pB != null)
                pB = pB.next;
            else
                pB = headA;
        }
        return pA;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}