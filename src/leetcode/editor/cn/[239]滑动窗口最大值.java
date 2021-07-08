package leetcode.editor.cn;

//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 561 👎 0

import java.util.*;

class SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        int[] in = {1,3,1,2,0,5};
        int k = 3;
        int[] re = solution.maxSlidingWindow(in,k);
        System.out.println(re);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        class MyQueque{
            Deque deque ;
            MyQueque(){
                this.deque = new ArrayDeque<>();
            }
            void pop(int value){
                if(!deque.isEmpty() && value == (Integer) deque.getFirst()){
                    deque.removeFirst();
                }
            }
            void push(int value){
                while (!deque.isEmpty() && value > (Integer)deque.getLast()){
                    deque.removeLast();
                }
                deque.addLast(value);
            }
            int front(){
                return (Integer) deque.getFirst();
            }
        }

    public int[] maxSlidingWindow(int[] nums, int k) {
            int[] re = new int[nums.length - k + 1];
            MyQueque m = new MyQueque();
            int i = 0;
            int j = 0;
            while(i < k && i < nums.length){
                m.push(nums[i++]);
            }
            re[j++] = m.front();
            m.pop(nums[i - k ]);
            while (i< nums.length){
                m.pop(nums[i - k]);
                m.push(nums[i]);
                re[j++] = m.front();
                i++;
            }
            return re;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}