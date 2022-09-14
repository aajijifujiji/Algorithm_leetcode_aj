package leetcode.editor.cn;

//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 377 👎 0

class MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;//如果节点为空，深度为零
        if(root.left == null && root.right == null)return 1;//如果节点的左右子节点为null，深度为当前一个节点深度，为零
        int depth = Integer.MAX_VALUE;//将最小深度设置为最大数
        //叶子节点指的是左右子节点都为空的节点，一个子节点为空，一个子节点不空的节点不是叶子节点，不取这个节点做为这个分枝的最小深度
        //
        if(root.left != null)//如果左节点不为空，在左节点中找最小深度
            depth = Math.min(minDepth(root.left),depth);//
        if(root.right != null)
            depth = Math.min(minDepth(root.right),depth);
//        int leftDepth = minDepth(root.left);
//        int rightDepth = minDepth(root.right);
        return depth + 1;
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