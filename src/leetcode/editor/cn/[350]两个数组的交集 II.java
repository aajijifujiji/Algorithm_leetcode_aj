package leetcode.editor.cn;

//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 766 👎 0

import java.util.*;

class IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
//        int[] nums1 = new int[]{4, 9, 5};
//        int[] nums2 = new int[]{9,4,9,8,4};
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        final int[] intersect = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if(m.containsKey(nums1[i])){
                Integer k = m.get(nums1[i]);
                m.put(nums1[i], ++k);
            }
            else
                m.put(nums1[i],1);
        }
        int[] res = new int[nums2.length];
        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            if(m.containsKey(nums2[i])){
                Integer num = m.get(nums2[i]);
                if(num != 0){
                    res[k++] = nums2[i];
                    m.put(nums2[i], --num);
                }
            }
        }
        return Arrays.copyOfRange(res,0, k);
    }
//    public int[] intersect(int[] nums1, int[] nums2) {
//        ArrayList<Integer> list = new ArrayList<>();
//        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
//        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums1.length; i++) {
//            if(map1.containsKey(nums1[i])){
//                Integer nums = map1.get(nums1[i]);
//                map1.put(nums1[i], ++nums);
//            }
//            else
//                map1.put(nums1[i], 1);
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            if(map2.containsKey(nums2[i])){
//                Integer nums = map2.get(nums2[i]);
//                map2.put(nums2[i], ++nums);
//            }
//            else
//                map2.put(nums2[i], 1);
//        }
//        return getArray(map1, map2);
//    }
    public int[] getArray(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2){
        if(map1.size() > map2.size())
            return getArray(map2, map1);
        List<Integer> list = new ArrayList<>();
        for(Integer i : map1.keySet()){
            if(map2.containsKey(i)){
                int u = map1.get(i);
                int k = map2.get(i);
                int l = u > k? k: u;
                for (int j = 0; j < l; j++) {
                    list.add(i);
                }
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