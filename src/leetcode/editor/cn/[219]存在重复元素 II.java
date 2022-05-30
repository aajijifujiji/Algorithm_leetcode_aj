package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 481 👎 0

import java.util.HashMap;

class ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        int[] nums = {};
        int k = 0;
        boolean b = solution.containsNearbyDuplicate(nums, k);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        while (i < nums.length){
            if(map.containsKey(nums[i]) &&
                Math.abs( (map.get(nums[i]) - i ) ) <= k)
                return true;
            map.put(nums[i], i);
            i++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}