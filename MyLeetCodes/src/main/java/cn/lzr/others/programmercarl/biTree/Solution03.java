package cn.lzr.others.programmercarl.biTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution03 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.right = node4;
        node3.right = node5;

        new Solution03().levelOrder(node1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(root);

        List<Integer> curList;

        while (arrayDeque.size() != 0){
            curList = new ArrayList<Integer>();
            int loop = arrayDeque.size();
            for (int i = 0; i < loop; i++) {
                TreeNode treeNode = arrayDeque.removeFirst();
                curList.add(treeNode.val);
                if (treeNode.left != null) arrayDeque.addLast(treeNode.left);
                if (treeNode.right != null) arrayDeque.addLast(treeNode.right);
            }
            res.add(curList);
        }
        return res;
    }
}
