package leetcode.editor.cn;

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 111 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
    /*
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        if(root != null) que.add(root);
        while (!que.isEmpty()){
            int size = que.size();
            List<Integer> nlist = new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                Node n = que.poll();
                nlist.add(n.val);
                for (int j = 0; j < n.children.size() ; j++) {
                    que.add(n.children.get(j));
                }
            }
            ret.add(nlist);
        }
        return ret;
    }

}
}