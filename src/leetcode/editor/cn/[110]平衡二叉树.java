package leetcode.editor.cn;

//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。 
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
//        1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
// Related Topics 树 深度优先搜索 
// 👍 492 👎 0

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class BalancedBinaryTree{
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
//        return getDepth(root)!=-1;
        if(root == null)return true;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()){
            TreeNode node = que.poll();
            int leftDepth = getDepth(node.left);
            int rightDepth = getDepth(node.right);
            if(Math.abs(leftDepth - rightDepth) > 1)return false;
            if(node.left != null)que.add(node.left);
            if(node.right != null)que.add(node.right);
        }
        return true;

    }
    public int getDepth(TreeNode cur){
        /*
        if(node ==null)return 0;
        int leftDepth = getDepth(node.left);
        if(leftDepth == -1)return -1;
        int rightDepth = getDepth(node.right);
        if(rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth)<= 1?Math.max(leftDepth , rightDepth)+1:-1;
         */
        if(cur == null)return 0;
        Stack<TreeNode> st = new Stack<>();
        int depth = 0;
        int result = 0;
        if(cur != null)st.push(cur);
        while (!st.isEmpty()){
            TreeNode node = st.peek();
            if(node != null){
                st.pop();
                st.push(node);
                st.push(null);
                depth++;
                if(node.left != null)st.push(node.left);
                if(node.right != null)st.push(node.right);
            }else {
                st.pop();
                node = st.peek();
                st.pop();
                depth--;
            }
            result = result> depth?result:depth;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

}