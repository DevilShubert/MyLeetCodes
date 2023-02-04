package cn.lzr.others.hot100;

public class Solution12 {
  // [合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

  // 基操解法
  public ListNode mergeKLists(ListNode[] lists) {

    if (lists.length == 0) {
      return null;
    }
    if (lists.length == 1) return lists[0];

    ListNode resNode = null;
    for (int i = 0; i < lists.length; i++) {
      resNode = merge(resNode, lists[i]);
    }
    return resNode;
  }

  // 分治解法

  // 优先队列解法

  // 使用递归合并两个链表
  public ListNode merge(ListNode l1, ListNode l2) {

    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val < l2.val) {
      l1.next = merge(l1.next, l2);
      return l1;
    } else {
      l2.next = merge(l1, l2.next);
      return l2;
    }
  }
}
