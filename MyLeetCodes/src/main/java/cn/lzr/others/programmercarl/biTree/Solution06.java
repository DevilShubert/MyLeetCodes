package cn.lzr.others.programmercarl.biTree;

public class Solution06 {
    // 检验是否是对称树
    public boolean isSymmetric(TreeNode root) {
        return  isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){

        // all the leaf nodes will return True
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        // recursion
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
