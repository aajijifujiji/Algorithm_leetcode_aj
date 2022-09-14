package leetcode.editor.cn;

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 686 👎 0

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle{
    public static void main(String[] args) {

        Solution solution = new PascalsTriangle().new Solution();
        int num = 5;
        solution.generate(5);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
//        int[][] rows = new int[numRows][];
        List<List<Integer>> rows = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        rows.add(l1);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                l.add(getC(rows.get(i - 1), j));
            }
            rows.add(l);
        }
        return rows;
    }

    private int getC(List<Integer> l, int index){
        if(index <= 0 || index >= l.size() )return 1;
        return l.get(index - 1) + l.get(index);
    }
    private int getC(int[] nums, int index){
        if(index <= 0 || index >= nums.length )return 1;
        int sum = nums[index - 1] + nums[index];
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}