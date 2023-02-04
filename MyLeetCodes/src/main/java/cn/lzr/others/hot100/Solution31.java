package cn.lzr.others.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution31 {
  List<Integer> res = new ArrayList<>();

  public boolean isValidBST(TreeNode root) {
    inorder(root);
    int cur = Integer.MIN_VALUE;
    for (int i = 1; i < res.size(); i++) {
      if (res.get(i - 1) >= res.get(i)) return false;
    }
    return true;
  }

  public void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    res.add(root.val);
    inorder(root.right);
  }

  public boolean inorderValid(TreeNode root) {
    if (root == null) return true;
    int val = root.val;
    boolean flag = true;
    if (root.left != null && root.right != null) {
      flag = (val > root.left.val && val < root.right.val);
    } else if (root.left != null) {
      flag = val > root.left.val;
    } else if (root.right != null) {
      flag = val < root.right.val;
    }
    return flag && inorderValid(root.left) && inorderValid(root.right);
  }
}
