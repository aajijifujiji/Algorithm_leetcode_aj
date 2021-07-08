package leetcode.editor.cn;

//给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
// 0。 
//
// 
//
// 示例： 
//
// 输入：s = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 417 👎 0

class MinimumSizeSubarraySum{
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum().new Solution();
        int[] nums = {2,3,1,2,4,3};
        int result = solution.minSubArrayLen(7,nums);
        System.out.println(result);
    }

    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int result = Integer.MAX_VALUE;
            int sum = 0;
            int subLength = 0;
            int i = 0;
            for (int j = 0; j < nums.length ; j++) {
                sum += nums[j];
                while (sum >= s){
                    subLength = j - i + 1;
                    result = subLength < result?subLength:result;
                    sum -= nums[i++];
                }
            }
            return result == Integer.MAX_VALUE?0:result;
        }
    }
/*
//class Solution {
//    public int minSubArrayLen(int s, int[] nums) {
//        int result = Integer.MAX_VALUE;
//        int sum ;
//        int subLength = 0;
//        for (int i = 0; i < nums.length ; i++) {
//            sum = 0;
//            for (int j = i; j < nums.length ; j++) {
//                sum += nums[j];
//                if(sum >=s){
//                    subLength = j - i + 1;
//                    result = subLength < result?subLength:result;
//                    break;
//                }
//            }
//        }
//        return result == Integer.MAX_VALUE?0:result;
//    }
//}
    */
//class Solution {
//    public int minSubArrayLen(int s, int[] nums) {
//        int sum = 0;
//        int subLength = 0;
//        int result = Integer.MAX_VALUE;
//        int slowIndex = 0;
//        for(int fastIndex = 0;fastIndex < nums.length;fastIndex++){
//            sum +=nums[fastIndex];
//            if(sum >= s){
//                subLength = fastIndex - slowIndex + 1;
//                result = subLength < result?subLength:result;
//                for (; slowIndex < nums.length; slowIndex++) {
//                    sum -= nums[slowIndex];
//                    if(sum<s){
//                        slowIndex++;
////                        sum +=nums[slowIndex];
//                        break;
//                    }else {//sum> s 和大干s
//                        subLength = fastIndex - slowIndex;
//                        result = subLength < result?subLength:result;
//                    }
//                }
//            }
//        }
//        return result==Integer.MAX_VALUE?0:result;
//    }
//}

}