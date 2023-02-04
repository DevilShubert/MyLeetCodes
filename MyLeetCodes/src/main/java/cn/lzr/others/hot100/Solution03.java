package cn.lzr.others.hot100;

public class Solution03 {
  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    ListNode node1 = new ListNode(9);
    ListNode node2 = new ListNode(9);
    ListNode node3 = new ListNode(9);
    ListNode node4 = new ListNode(9);
    ListNode node5 = new ListNode(9);
    ListNode node6 = new ListNode(9);
    ListNode node7 = new ListNode(9);
    ListNode node8 = new ListNode(9);
    ListNode node9 = new ListNode(9);
    ListNode node10 = new ListNode(9);
    node.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    node7.next = node8;
    node8.next = node9;
    node9.next = node10;
    Solution03 solution03 = new Solution03();
    solution03.addTwoNumbers(node1, node);
  }

  // 两数相加
  // https://leetcode-cn.com/problems/add-two-numbers/
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int temp1, temp2;
    ListNode node = new ListNode(0);
    ListNode resNode = node;
    ListNode tempNode;

    while (l1 != null || l2 != null) {
      if (l1 != null) {
        temp1 = l1.val;
        l1 = l1.next;
      } else {
        temp1 = 0;
      }

      if (l2 != null) {
        temp2 = l2.val;
        l2 = l2.next;
      } else {
        temp2 = 0;
      }

      int cur = (temp1 + temp2) + node.val;
      node.val = cur % 10;
      int tempRes = cur / 10;
      tempNode = (tempRes == 1 ? new ListNode(1) : new ListNode(0));
      // 如果两个链表都走到末尾，且末尾不需要进位时则要忽略最后的0
      if (l1 != null || l2 != null || tempNode.val != 0) {
        node.next = tempNode;
        node = tempNode;
      }
    }
    return resNode;
  }
}
