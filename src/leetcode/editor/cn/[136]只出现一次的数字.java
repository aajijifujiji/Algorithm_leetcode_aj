package leetcode.editor.cn;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2411 👎 0

import java.util.HashMap;
import java.util.Map;

class SingleNumber{
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
        int[] nums = new int[]{
            2,2,1
        };
        int i = solution.singleNumber(nums);
        System.out.println(i);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(map.containsKey(nums[i]) && map.get(nums[i]) != null){
//                map.put(nums[i], map.get(nums[i]) + 1);
//                continue;
//            }
//            map.put(nums[i], 1);
//        }
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//            if (entry.getValue() == 1) {
//                return entry.getKey();
//            }
//        }
//        return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            i ^= nums[j];
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}