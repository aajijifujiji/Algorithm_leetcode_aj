package leetcode.editor.cn;

//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 800 👎 0

import sun.font.DelegatingShape;

class KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int res = solution.findKthLargest(nums, k);
        System.out.println(res);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return selectK(nums, k, 0, nums.length);
    }
    public  void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public int selectK(int[] nums, int k, int l, int r){
        int p = patition(nums, l, r);
        if(p == (nums.length - k)){
            return nums[p];
        }else if(p < (nums.length - k)){
            return selectK(nums, k, p + 1, r);
        }else {
            return selectK(nums, k, l, p);
        }
    }
    public int patition(int[] nums, int l, int r){
        int lt = l , gt = r, i = l + 1;
        //[l+1...lt] < 0, [lt+1...i-1] = 0, [gt...r] > 0,
        while (i<gt){
            if(nums[l] == nums[i]){
                i++;
            }else if(nums[l] > nums[i]){
                lt++;
                swap(nums, i, lt);
                i++;
            }else if(nums[l] < nums[i]){
                gt--;
                swap(nums, i, gt);
            }
        }
        swap(nums, l, lt);
        return lt;
    }
}
//    public int findKthLargest(int[] nums, int k) {
//        return selectK(nums, k, 0, nums.length - 1);
//    }
//    public  void swap(int[] nums, int i, int j){
//        int t = nums[i];
//        nums[i] = nums[j];
//        nums[j] = t;
//    }
//    public int selectK(int[] nums, int k, int l, int r){
//        int p = patition(nums, l, r);
//        if(p == (nums.length - k)){
//            return nums[p];
//        }else if(p < (nums.length - k)){
//            return selectK(nums, k, p + 1, r);
//        }else {
//            return selectK(nums, k, l, p - 1);
//        }
//    }
//    public int patition(int[] nums, int l, int r){
//        int lt = l , gt = r + 1, i = l + 1;
//        //[l+1...lt] < 0, [lt+1...i-1] = 0, [gt...r] > 0,
//        while (i<gt){
//            if(nums[l] == nums[i]){
//                i++;
//            }else if(nums[l] > nums[i]){
//                lt++;
//                swap(nums, i, lt);
//                i++;
//            }else if(nums[l] < nums[i]){
//                gt--;
//                swap(nums, i, gt);
//            }
//        }
//        swap(nums, l, lt);
//        return lt;
//   }
//}
//leetcode submit region end(Prohibit modification and deletion)

}