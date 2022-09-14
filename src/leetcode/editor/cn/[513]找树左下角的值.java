package leetcode.editor.cn;

//给定一个二叉树，在树的最后一行找到最左边的值。 
//
// 示例 1: 
//
// 
//输入:
//
//    2
//   / \
//  1   3
//
//输出:
//1
// 
//
// 
//
// 示例 2: 
//
// 
//输入:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//输出:
//7
// 
//
// 
//
// 注意: 您可以假设树（即给定的根节点）不为 NULL。 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 119 👎 0

class FindBottomLeftTreeValue{
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode cur) {
        fandBottomLeftVal(cur,0);
        return maxVal;
    }
    int maxVal = 0;
    int maxLevel = -1;
    public void fandBottomLeftVal(TreeNode cur,int level){
        if(cur.left == null && cur.right == null){
            if(level> maxLevel){
                maxLevel = level;
                maxVal = cur.val;
            }
            return ;
        }
        if(cur.left != null){
            fandBottomLeftVal(cur.left,level+1);
        }
        if(cur.right != null){
            fandBottomLeftVal(cur.right,level+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
}