package leetcode.editor.cn;

//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 331 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeRightSideView{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
        
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root != null)que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            int r = 0;
            for (int i = 0; i < size ; i++){
                TreeNode node = que.poll();
                if(i == size -1)r = node.val;
                if(node.left != null)que.add(node.left);
                if(node.right != null)que.add(node.right);
            }
            result.add(r);
        }
        return result;
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