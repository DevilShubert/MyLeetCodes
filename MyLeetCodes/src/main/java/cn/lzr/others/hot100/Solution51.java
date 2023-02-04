package cn.lzr.others.hot100;

import java.util.ArrayDeque;

public class Solution51 {
  public boolean isPalindrome(ListNode head) {
    if (head.next == null) return true;
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    while (head != null) {
      int val = head.val;
      deque.addLast(val);
      head = head.next;
    }
    while (deque.size() > 1) {
      int right = deque.removeFirst();
      int left = deque.removeLast();
      if (right != left) return false;
    }
    return true;
  }
}
