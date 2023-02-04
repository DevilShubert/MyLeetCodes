package cn.lzr.others.hot100;

public class Solution52 {
  // 二叉树的最近公共祖先
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // 分情况对左右子树讨论
    // q p都在root节点的右边
    if (find(root.right, p) && find(root.right, q)) {
      // 则将root.right当做p q新的root传入下一次递归中
      TreeNode res = lowestCommonAncestor(root.right, p, q);
      return res;
    }

    // q p都在root节点的左边
    if (find(root.left, p) && find(root.left, q)) {
      // 则将root.right当做p q新的root传入下一次递归中
      TreeNode res = lowestCommonAncestor(root.left, p, q);
      return res;
    }

    // q p分别在根结点的两边，这一点只能用排除法得出来
    return root;
  }

  // 判断一个结点是否在root的子树中
  public boolean find(TreeNode root, TreeNode q) {
    // 中止条件
    if (root == null) return false;
    if (root == q) return true;
    return find(root.left, q) || find(root.right, q);
  }
}
