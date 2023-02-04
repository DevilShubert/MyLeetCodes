package cn.lzr.others.programmercarl.biTree;

public class Solution08 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return preorder(root) + 1;
    }

    public int preorder(TreeNode cur){
        if (cur.left == null && cur.right == null) return 0;
        if (cur.left != null && cur.right != null) {
            return Math.min(preorder(cur.left) + 1, preorder(cur.right) + 1);
        } else if (cur.right != null){
            return preorder(cur.right) + 1;
        } else {
            return preorder(cur.left) + 1;
        }
    }
}
