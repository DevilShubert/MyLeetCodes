package cn.lzr.others.programmercarl.biTree;

public class Solution04 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        preorder(root);
        return root;
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        preorder(root.left);
        preorder(root.right);
    }

}
