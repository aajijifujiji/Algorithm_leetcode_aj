package leetcode.editor.cn;

//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 我们应返回其最大深度，3。 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总不会超过 5000。 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 124 👎 0

import java.util.List;

class MaximumDepthOfNAryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfNAryTree().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
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
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int depth = 0;
        for (int i = 0; i < root.children.size() ; i++) {
            int chilMaxDepth = maxDepth(root.children.get(i));
            depth = depth > chilMaxDepth?depth:chilMaxDepth;
        }
        return depth + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class Node {
    public int        val;
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

}