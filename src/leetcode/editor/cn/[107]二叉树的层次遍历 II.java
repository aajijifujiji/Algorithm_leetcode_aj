package leetcode.editor.cn;

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 342 👎 0

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

class BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode t10 = new TreeNode(9);
        TreeNode t11 = new TreeNode(20);
        TreeNode t22 = new TreeNode(15);
        TreeNode t23 = new TreeNode(7);
        root.left = t10;
        root.right = t11;
        t11.left = t22;
        t11.right = t23;
        List<List<Integer>> list = solution.levelOrderBottom(root);
        System.out.println(Arrays.toString(list.toArray()));
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if(root != null)que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size ; i++){
                TreeNode node = que.poll();
                l.add(node.val);
                if(node.left != null)que.add(node.left);
                if(node.right != null)que.add(node.right);
            }
            result.add(l);
        }
        List<List<Integer>> reverse = reverse(result, 0, result.size() - 1);
        return reverse;
    }
    public List<List<Integer>> reverse (List<List<Integer>> l,int s,int e){
        List<List<Integer>> reverse = new ArrayList<>();
        int len = l.size();
        for (int i = 0; i < len; i++) {
            reverse.add(l.get(len - i -1));
        }
        return reverse;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
}