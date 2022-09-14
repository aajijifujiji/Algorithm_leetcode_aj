package leetcode.editor.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: aajijifujiji
 * @DATE: 2022/5/10 10:39
 */
public class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static void printByArrays(TreeNode node) {
        List<Integer> nodes = new ArrayList<Integer>();
        getNodes(nodes, node);
        System.out.println(nodes.toArray());
    }
    private static void getNodes (List<Integer> nodes,TreeNode node){
        nodes.add(node.val);
        if(node.left != null)
            getNodes(nodes, node.left);
        if(node.right != null)
            getNodes(nodes, node.right);
    }


}
