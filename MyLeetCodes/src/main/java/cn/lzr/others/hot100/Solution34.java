package cn.lzr.others.hot100;

import java.util.ArrayDeque;

public class Solution34 {
  // [二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)

  public static void main(String[] args) {
    //
    Solution34 solution34 = new Solution34();
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    node1.left = node2;
    node1.right = node5;
    node2.left = node3;
    node2.right = node4;
    node5.right = node6;
    solution34.flatten(node1);
  }

  private ArrayDeque<Integer> deque = new ArrayDeque<>();

  public void flatten(TreeNode root) {
    if (root == null) return;
    // 首先进行前序遍历，将所有结构保存在deque中
    preOrder(root);
    root.val = deque.removeFirst();
    root.left = null;
    while (deque.size() != 0) {
      TreeNode tempNode = new TreeNode(deque.removeFirst());
      root.right = tempNode;
      root = tempNode;
    }
  }

  public void preOrder(TreeNode root) {
    if (root == null) return;
    deque.addLast(root.val);
    preOrder(root.left);
    preOrder(root.right);
  }
}
