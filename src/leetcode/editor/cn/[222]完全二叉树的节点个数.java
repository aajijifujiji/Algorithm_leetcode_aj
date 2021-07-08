package leetcode.editor.cn;

//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找 
// 👍 251 👎 0

import java.util.ArrayDeque;
import java.util.Queue;

class CountCompleteTreeNodes{
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
        
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
    public int countNodes(TreeNode cur) {
//        if(cur == null)return 0;
//        return 1 + countNodes(cur.left) + countNodes(cur.right);
        if(cur == null)return 0;
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(cur);
        int count = 0;
        while (!que.isEmpty()){
            TreeNode node = que.poll();
            int size = que.size();
            if(node.left !=null)que.add(node.left);
            if(node.right !=null)que.add(node.right);
            count+=1;
        }
        return count;
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