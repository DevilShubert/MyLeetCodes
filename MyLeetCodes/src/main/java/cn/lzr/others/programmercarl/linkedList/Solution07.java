package cn.lzr.others.programmercarl.linkedList;

public class Solution07 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // 如果没有环则直接退出
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // 成环
            if (slow == fast) {
                ListNode index = head;
                ListNode cur = slow;
                while (index != cur) {
                    index = index.next;
                    cur = cur.next;
                }
                return index;
            }

        }
        return null;
    }
}
