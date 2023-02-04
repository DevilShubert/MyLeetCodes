package cn.lzr.others.programmercarl.biTree;

public class Solution09 {
      public static void main(String[] args) {
          TreeNode node1 = new TreeNode(1);
          TreeNode node2 = new TreeNode(2);
          TreeNode node3 = new TreeNode(3);
          node1.left = node2;
          node1.right = node3;

          Solution09 solution09 = new Solution09();
          System.out.println(solution09.hasPathSum(node1, 3));
      }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return  preorder(root, targetSum);
    }

    public boolean preorder(TreeNode root, int target) {
        if (root.left == null && root.right == null && (target - root.val) == 0) {
            return true;
        } else if (root.left == null && root.right == null && (target - root.val) != 0) {
            return false;
        } if (root.left != null && root.right != null) {
            return preorder(root.left, target - root.val) || preorder(root.right, target - root.val);
        } if (root.left != null) {
            return preorder(root.left, target - root.val);
        } else {
            return preorder(root.right, target - root.val);
        }
    }
}
