package leetcode.editor.cn;

//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。 
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 104 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
// Related Topics 栈 数组 哈希表 单调栈 
// 👍 444 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NextGreaterElementI{
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        int[] n1 = {4,1,2};
        int[] n2 = {1,3,4,2};
//        int[] is = solution.nextGreaterElement(n1, n2);
        int[] is = solution.nextGreaterElement(null, null);
        System.out.println(is);
//        for (int i : is) {
//            System.out.println(i);
//        }
    }
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)return null;
        Stack<Integer> stack = new Stack<>();
        int[] is = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) map.put(nums1[i], i);
        for (int i = 0; i < is.length; i++) is[i] = -1;

        for (int i = 0; i < nums2.length; i++) {
            //栈为空 加入当前元素下标
            if(stack.empty() ){
                stack.push(i);
            //栈不为空，栈顶元素值 >= 当前元素 ==> 加入当前元素下标
            }else if(nums2[stack.peek()] >= nums2[i]){
                    stack.push(i);
            //st.top < nums2[i]
            //栈不为空，栈顶元素值 < 当前元素 ==> 循环 ;
            // 找到出栈元素最大值之后，判断是否在 nums1中有这个元素;
            }else {
                while (!stack.empty() && nums2[stack.peek()] < nums2[i]){
                    if(map.get(nums2[stack.peek()]) != null)
                        is[map.get(nums2[stack.peek()])] = nums2[i];//(i - stack.peek());
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return is;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}