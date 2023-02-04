package cn.lzr.others.programmercarl.biTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution05 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Stack<List<Integer>> stack = new Stack<>();

        List<Integer> curList;
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(root);
        while (arrayDeque.size() != 0){
            curList = new ArrayList<Integer>();
            int loop = arrayDeque.size();
            for (int i = 0; i < loop; i++) {
                TreeNode treeNode = arrayDeque.removeFirst();
                curList.add(treeNode.val);
                if (treeNode.left != null) arrayDeque.addLast(treeNode.left);
                if (treeNode.right != null) arrayDeque.addLast(treeNode.right);
            }
            stack.push(curList);
        }

        while (!stack.isEmpty()){
            res.add(stack.pop());
        }

        return res;
    }
}
