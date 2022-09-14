package leetcode.editor.cn;

//给定一个链表数组，每个链表都已经按升序排列。 
//
// 请将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 
//输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// 
//
// 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/ 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 34 👎 0

import java.util.Arrays;
import java.util.List;

class VvXgSW{
    public static void main(String[] args) {
        Solution solution = new VvXgSW().new Solution();
        int[] arr1 = {1,4,5};
        int[] arr2 = {1,3,4};
        int[] arr3 = { 2,6};
        ListNode[] ls = {new ListNode(arr1), new ListNode(arr2), new ListNode(arr3)};
        solution.mergeKLists(ls);
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        return new ListNode(1);
    }

    private void sortArr(int[] arr){
    }
    private Integer getMinFromArrIndex(int[] arr){
        if(arr.length == 0)return null;
        if(arr.length == 1)return 0;
        int min = 0;
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
                res = i;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}