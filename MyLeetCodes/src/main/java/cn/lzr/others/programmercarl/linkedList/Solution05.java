package cn.lzr.others.programmercarl.linkedList;

public class Solution05 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 最好使用head虚头结点，因为链表长度最小为1，有可能不能用双指针
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
