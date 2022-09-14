package leetcode.editor.cn;

//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 166 👎 0

import java.util.PriorityQueue;

class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (; i < arr.length && i < k + 1; i++) {
            pq.add(arr[i]);
        }
        for (; i < arr.length ; i++) {
            if(arr[i] < pq.peek())
                pq.poll();
                pq.add(arr[i]);
        }
        int[] res = new int[k];
        for (int j = 0; j < k && !pq.isEmpty(); j++) {
            res[j] = pq.poll();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}