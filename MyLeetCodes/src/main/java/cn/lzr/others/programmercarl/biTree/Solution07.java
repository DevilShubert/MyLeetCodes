package cn.lzr.others.programmercarl.biTree;

public class Solution07 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return preorder(root);
    }

    public int preorder(TreeNode cur){
        if (cur == null) return 0;
        return  Math.max(preorder(cur.left) + 1, preorder(cur.right) + 1);
    }
}
