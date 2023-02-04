package cn.lzr.others.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution32 {

  List<List<Integer>> res = new ArrayList<>();
  Deque<TreeNode> deque = new ArrayDeque<>();

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return res;
    deque.addLast(root);

    while (deque.size() != 0) {
      ArrayList<Integer> curLayerList = new ArrayList<>();
      int curLoop = deque.size();
      for (int i = 0; i < curLoop; i++) {
        TreeNode treeNode = deque.removeFirst();
        if (treeNode.left != null) deque.addLast(treeNode.left);
        if (treeNode.right != null) deque.addLast(treeNode.right);
        curLayerList.add(treeNode.val);
      }
      res.add(curLayerList);
    }
    return res;
  }
}
