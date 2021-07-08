package leetcode.editor.cn;

//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 199 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AverageOfLevelsInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree().new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode t10 = new TreeNode(9);
        TreeNode t11 = new TreeNode(20);
        TreeNode t22 = new TreeNode(15);
        TreeNode t23 = new TreeNode(7);
        root.left = t10;
        root.right = t11;
        t11.left = t22;
        t11.right = t23;
        List<Double> list = solution.averageOfLevels(root);
        System.out.println(list);
        for(Double d:list){
            System.out.println(d);
        }
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if(root != null)que.add(root);
        while (!que.isEmpty()){
            int si = que.size();
            double sum = 0;
            for (int i = 0; i < si ; i++) {
                TreeNode node = que.poll();
                sum += node.val;
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
//            System.out.println(Math.round(sum/si)*10/10);
//            ret.add((double) (Math.round(sum/si)*10/10));
            ret.add(sum/si);
        }
        return ret;
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