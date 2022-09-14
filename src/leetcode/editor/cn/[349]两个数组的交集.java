package leetcode.editor.cn;

//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 551 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9,4,9,8,4};
        final int[] intersection = solution.intersection(nums1, nums2);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!set.contains(nums1[i]))
                set.add(nums1[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}