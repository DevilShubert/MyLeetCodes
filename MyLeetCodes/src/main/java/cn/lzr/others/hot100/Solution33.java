package cn.lzr.others.hot100;

import java.util.HashMap;

public class Solution33 {

  public static void main(String[] args) {
    Solution33 solution33 = new Solution33();
    int[] pre = new int[] {3, 9, 20, 15, 7};
    int[] in = new int[] {9, 3, 15, 20, 7};
    TreeNode treeNode = solution33.buildTree(pre, in);
    System.out.println(treeNode.val);
  }

  private HashMap<Integer, Integer> hmp = new HashMap<Integer, Integer>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    int len = inorder.length;
    for (int i = 0; i < len; i++) {
      // key value
      hmp.put(inorder[i], i);
    }

    return recursive(preorder, inorder, 0, len - 1, 0, len - 1);
  }

  public TreeNode recursive(
      int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
    // recursive end condition
    if (preLeft > preRight) return null;
    int curRoot = preorder[preLeft];
    int inIndex = hmp.get(curRoot);
    TreeNode curNode = new TreeNode(curRoot);
    curNode.left =
        recursive(preorder, inorder, preLeft + 1, preLeft + inIndex - inLeft, inLeft, inIndex - 1);
    curNode.right =
        recursive(
            preorder, inorder, preLeft + inIndex - inLeft + 1, preRight, inIndex + 1, inRight);
    return curNode;
  }
}
