package cn.lzr.others.programmercarl.linkedList;

public class Solution04 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        // 新建head虚结点
        ListNode myHead = new ListNode(-1);
        myHead.next = head;

        ListNode pre = myHead;
        ListNode p1, p2;

        // 利用&&运算符，一旦前面的pre.next不通过则后面直接不同判断，所以直接避免空指针异常
        while (pre.next != null && pre.next.next != null) {
            pre = pre.next.next;
            // 修改3条线
            p1 = pre.next;
            p2 = pre.next.next;

            p1.next = p2.next;
            p2.next = p1;
            pre.next = p2;
        }
        return myHead.next;
    }
}
