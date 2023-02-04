package cn.lzr.LeetCodes;

import dataStructure.ListNode;

public class Solution206 {
	// 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		ListNode dummy = null;
		ListNode cur = head;
		ListNode next ;
		while(cur != null) {
			next = cur.next;
			cur.next = dummy;
			dummy = cur;
			cur = next;
		}
		// 结束时，cur为null，dummy为起始结点
		return  dummy;
	}
}
