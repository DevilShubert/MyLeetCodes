package cn.lzr.others.programmercarl.linkedList;

public class Solution06 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummpyA = new ListNode(-1);
        ListNode dummpyB = new ListNode(-2);
        dummpyA.next = headA;
        dummpyB.next = headB;

        //求A的长度
        ListNode curA = dummpyA;
        int lenA = 0;
        while (curA.next != null) {
            lenA++;
            curA = curA.next;
        }

        //求B的长度
        ListNode curB = dummpyB;
        int lenB = 0;
        while (curB.next != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        // 换家策略，把交长的链表赋值给A
        if (lenB > lenA) {
            int temp = lenA;
            lenA = lenB;
            lenB = temp;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }

        int gap = lenA - lenB;
        // 让curA与B尾端对齐
        while (gap-- > 0) {
            curA = curA.next;
        }

        while (curA != null) {
            // 只要指针相同就能保证后面的数据都相同
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
