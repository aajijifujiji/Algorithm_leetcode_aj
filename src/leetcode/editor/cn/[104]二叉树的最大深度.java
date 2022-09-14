package leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 
// 👍 714 👎 0

import java.util.ArrayDeque;
import java.util.Queue;

class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
//        int depth = getDepth(root,0);
//        return depth;
        int depth = 0;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()){
            int size = que.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if(node.left != null)que.add(node.left);
                if(node.right != null)que.add(node.right);
            }
        }
        return depth;
    }
    public int getDepth(TreeNode node ,int depth){
        if(node == null)return 0;
        int left = getDepth(node.left,depth);
        int right = getDepth(node.right,depth);
        int biggerDepth = left > right?left:right;
        return biggerDepth+1;
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