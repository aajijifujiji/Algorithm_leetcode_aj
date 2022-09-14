package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 👍 1607 👎 0

class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] nums = new int[]{};
        solution.moveZeroes(nums);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int z = 0;
        int f = 0;
        while(f< nums.length){
            //找到第一个0
            if(z == f && nums[f] != 0){
                z++;
                f++;
            }else if(nums[f] == 0)
                f++;
            else if(nums[f] != 0){
                swap(nums, z, f);
                z++;
                f++;
            }
        }

    }
    private void swap(int[] nums, int l, int r){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}