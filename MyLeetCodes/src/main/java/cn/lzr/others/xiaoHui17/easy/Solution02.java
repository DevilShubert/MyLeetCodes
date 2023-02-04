package cn.lzr.others.xiaoHui17.easy;

import hot100.ListNode;

public class Solution02 {
  // 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    ListNode dummy = null;
    ListNode cur = head;
    ListNode next;
    while (cur != null) {
      next = cur.next;
      cur.next = dummy;
      dummy = cur;
      cur = next;
    }
    return head;
  }
}

class Solution2_1 {
  public static void main(String[] args) {
    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;
    reverseBetween(n1, 2, 4);
  }
  // 反转链表2 https://leetcode-cn.com/problems/reverse-linked-list-ii/
  public static ListNode reverseBetween(ListNode head, int left, int right) {
    // 先定位 再反转
    ListNode begin = head;

    // lastOne表示反转链表的前一个
    ListNode lastOne = new ListNode(-1);
    lastOne.next = begin;

    for (int i = 1; i < left; i++) {
      begin = begin.next;
      lastOne = lastOne.next;
    }
    lastOne.next = null;
    ListNode newLeft = doReverse(begin, right - left);
    lastOne.next = newLeft;
    if (left == 1) {
      return lastOne.next;
    } else {
      return head;
    }
  }

  public static ListNode doReverse(ListNode head, int loop) {
    if (loop == 0) return head;
    ListNode dummy = null;
    ListNode cur = head;
    // 当遍历结束时 next自动就是nextOne结点 表示需要反转部分的下一个结点
    ListNode next = null;
    for (int i = 0; i <= loop; i++) {
      next = cur.next;
      cur.next = dummy;
      dummy = cur;
      cur = next;
    }
    head.next = next;
    return dummy;
  }
}
