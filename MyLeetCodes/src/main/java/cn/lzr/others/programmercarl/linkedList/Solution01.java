package cn.lzr.others.programmercarl.linkedList;

public class Solution01 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }

        // 虚拟一个头结点进行删除
        ListNode myHead = new ListNode(-1, head);
        ListNode pre = myHead;
        ListNode cur = head;

      while (cur != null) {
          if (cur.val == val) {
              pre.next = cur.next;
          } else {
              pre = cur;
          }
          cur = cur.next;
      }

        return myHead.next;
    }
}
