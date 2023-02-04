package cn.lzr.others.programmercarl.biTree;

import java.util.ArrayList;
import java.util.List;

public class Solution01 {
    // traverse binary tree in preorder
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> res =  new ArrayList<Integer>();
         preorder(root, res);
         return res;
    }

    public void preorder(TreeNode root,List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public void postorder(TreeNode root,List<Integer> res){
        if (root == null) return;
        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);
    }
    public void inorder(TreeNode root,List<Integer> res){
        if (root == null) return;
        preorder(root.left, res);
        res.add(root.val);
        preorder(root.right, res);
    }

}
