package cn.lzr.others.hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution29 {

  public List<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<>();
    inOrder(root, res);
    return res;
  }

  public void inOrder(TreeNode node, List<Integer> res) {
    if (node == null) return;
    inOrder(node.left, res);
    res.add(node.val);
    inOrder(node.right, res);
  }
}
