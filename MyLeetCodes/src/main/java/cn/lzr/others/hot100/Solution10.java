package cn.lzr.others.hot100;

public class Solution10 {
  // 合并两个有序链表
  // https://leetcode-cn.com/problems/merge-two-sorted-lists/
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

    ListNode l1 = list1;
    ListNode l2 = list2;
    ListNode temp;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        temp = l1.next;
        l1.next = l2;
        // l1 move
        l1 = temp;
      } else if (l1.val >= l2.val && (l1.val <= l2.next.val || l2.next == null)) {
        temp = l1.next;
        l1.next = l2.next;
        l2.next = l1;
        // l2, l1 all move
        l1 = temp;
        l2 = l2.next;
      } else {
        l2 = l2.next;
      }
    }
    return list2;
  }

  public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    if (list1.val < list2.val) {
      list1.next = mergeTwoLists2(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists2(list1, list2.next);
      return list2;
    }
  }
}
