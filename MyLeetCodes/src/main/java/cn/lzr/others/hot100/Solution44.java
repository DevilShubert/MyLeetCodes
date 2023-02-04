package cn.lzr.others.hot100;

public class Solution44 {
  // [相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/)
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode dummyA = headA;
    ListNode dummyB = headB;
    int lenA = 0;
    int lenB = 0;

    while (dummyA != null || dummyB != null) {
      if (dummyA != null) {
        lenA++;
        dummyA = dummyA.next;
      }
      if (dummyB != null) {
        lenB++;
        dummyB = dummyB.next;
      }
    }
    int loop = lenA < lenB ? lenB - lenA : lenA - lenB;

    ListNode longList = lenA < lenB ? headB : headA;
    ListNode shortList = (longList == headA) ? headB : headA;

    for (int i = 0; i < loop; i++) {
      longList = longList.next;
    }

    while (longList != null || shortList != null) {
      if (longList == shortList) return longList;
      longList = longList.next;
      shortList = shortList.next;
    }
    return null;
  }
}
