package leetcode.editor.cn;

//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 
// 👍 243 👎 0

import java.util.Stack;
import java.util.TreeMap;

class SumOfLeftLeaves{
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
        
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
    public int sumOfLeftLeaves(TreeNode cur) {
//        if(cur == null)return 0;
//        int leftVal = sumOfLeftLeaves(cur.left);
//        int rightVal = sumOfLeftLeaves(cur.right);
//        int midleVal = 0;
//        if(cur.left != null && cur.left.left == null && cur.left.right == null){
//            midleVal = cur.left.val;
//        }
//        return leftVal + rightVal + midleVal;
        if(cur == null)return 0;
        Stack<TreeNode> st = new Stack<>();
        st.push(cur);
        int sumVal = 0;
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.left!=null && node.left.left == null && node.left.right == null){
                sumVal +=node.left.val;
            }
            if(node.left != null){
                st.push(node.left);
            }
            if(node.right != null){
                st.push(node.right);
            }
        }
        return sumVal;
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