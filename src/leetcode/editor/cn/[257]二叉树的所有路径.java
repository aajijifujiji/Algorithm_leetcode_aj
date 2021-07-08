package leetcode.editor.cn;

//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 378 👎 0

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePaths{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
        
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null)return result;
//        traversal(root,path,result);
        Stack<TreeNode> treeSt = new Stack<>();
        Stack<String> pathSt = new Stack<>();
        treeSt.push(root);
        pathSt.push(root.val + "");
        while (!treeSt.isEmpty()){
            TreeNode node = treeSt.pop();
            String cPath = pathSt.pop();
            if(node.left == null && node.right == null) {
                result.add(cPath);
            }
            if(node.right != null){
                treeSt.push(node.right);
                pathSt.push(cPath + "->"+node.right.val);
            }
            if(node.left != null){
                treeSt.push(node.left);
                pathSt.push(cPath + "->" + node.left.val);
            }
        }
        return result;
    }
    public void traversal(TreeNode cur,List<Integer> path ,List<String> result){
        path.add(cur.val);
        if(cur.left ==  null  && cur.right == null){
            String sPath = "";
            for (int i = 0; i < path.size() -1; i++) {
                sPath +=  path.get(i);
                sPath += "->";
            }
            sPath += path.get(path.size() - 1);
            result.add(sPath);
            return;
        }
        if(cur.left !=null){
            traversal(cur.left,path,result);
            path.remove(path.size()-1);
        }
        if(cur.right !=null){
            traversal(cur.right,path,result);
            path.remove(path.size()-1);
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