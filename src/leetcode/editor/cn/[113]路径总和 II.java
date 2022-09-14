package leetcode.editor.cn;

//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索 
// 👍 362 👎 0


import java.util.ArrayList;
import java.util.List;

class PathSumIi {
    public static void main(String[] args) {
        Solution solution = new PathSumIi().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> pathSum(TreeNode cur, int sum) {
            if(cur == null){
                return result;
            }
            l.add(cur.val);
            pathSumT(cur, sum - cur.val);
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        public void pathSumT(TreeNode cur, int su) {
            if (cur.left == null && cur.right == null) {
                if(su == 0){
                    result.add(new ArrayList<>(l));
                }
                return;
            }
            if (cur.left != null) {
                l.add(cur.left.val);
                pathSumT(cur.left,su - cur.left.val);
                l.remove(l.size()-1);
            }
            if (cur.right != null) {
                l.add(cur.right.val);
                pathSumT(cur.right,su - cur.right.val);
                l.remove(l.size()-1);
            }
            return ;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int      val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}