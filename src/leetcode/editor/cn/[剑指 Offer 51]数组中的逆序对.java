package leetcode.editor.cn;

//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。 
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
// 👍 272 👎 0

import java.util.Arrays;

class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        int[] nums = {7,5,6,4};
        System.out.println(solution.reversePairs(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int res = 0;

        public int reversePairs(int[] nums) {
            int[] temp = Arrays.copyOf(nums, nums.length);
            reversePairs(nums, 0, nums.length - 1, temp);
            return res;
        }

        public void reversePairs(int[] nums, int l, int r, int[] temp) {
            if (l >= r) return;
            int mid = l + (r - l) / 2;
            reversePairs(nums, l, mid, temp);
            reversePairs(nums, mid + 1, r, temp);
            merge(nums, l, mid, r, temp);
        }

        public void merge(int[] nums, int l, int mid, int r, int[] temp) {
            System.arraycopy(nums, l, temp, l, r - l + 1);
            int i = l, j = mid + 1;
            for (int k = l; k <= r; k++) {
                if (i > mid) {
                    nums[k] = temp[j++];
                } else if (j > r) {
                    nums[k] = temp[i++];
                } else if (temp[i] > temp[j]) {
                    nums[k] = temp[j++];
                    res += mid - i + 1;
                } else {
                    nums[k] = temp[i++];
                }
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}